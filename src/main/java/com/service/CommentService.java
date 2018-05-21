package com.service;

import com.dao.JPAInterface.*;
import com.pojo.*;
import com.utils.common.CommonUtils;
import com.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    IRecordCommentDAO iRecordCommentDAO;

    @Autowired
    IOrderSumDAO iOrderSumDAO;

    @Autowired
    IRecordCommentReplyDAO iRecordCommentReplyDAO;

    @Autowired
    IOrderSmallDAO iOrderSmallDAO;

    @Autowired
    IInfoItemDAO iInfoItemDAO;

    @Autowired
    IInfoUserDAO iInfoUserDAO;

    @Autowired
    IInfoOperatorDAO iInfoOperatorDAO;


    public void reply(WholeComment wholeComment) {
        RecordCommentReply vo = wholeComment.getRecordCommentReply();
        vo.setCreatedate(new Timestamp(System.currentTimeMillis()));
        RecordCommentReply recordCommentReply = iRecordCommentReplyDAO.save(vo);

        RecordComment recordComment = iRecordCommentDAO.findById(wholeComment.getRecordComment().getId()).get();
        recordComment.setReplyid(recordCommentReply.getId());
        iRecordCommentDAO.save(recordComment);
    }


    public ItemCommentReplyVo findCommentVoByItemid(Long id, int page, int size) {
        ItemCommentReplyVo itemCommentReplyVo = new ItemCommentReplyVo();
        List<RecordComment> commentList = iRecordCommentDAO.findByItemid(id);
        List<CommentReplyVo> replyVos = new ArrayList<>();
        InfoItem infoItem = iInfoItemDAO.findById(id).get();
        for (RecordComment comment : commentList) {
            CommentReplyVo commentReplyVo = new CommentReplyVo();
            InfoUser infoUser = iInfoUserDAO.findById(comment.getUserid()).get();
            InfoOperator infoOperator = null;
            RecordCommentReply recordCommentReply = null;
            List<OrderSmall> orderSmallss = iOrderSmallDAO.findByCommentid(comment.getId());
            OrderSmall orderSmall = orderSmallss.size() > 0 ? orderSmallss.get(0) : null;
            System.out.println(comment.getReplyid());
            if (comment.getReplyid() > 0) {
                recordCommentReply = iRecordCommentReplyDAO.findById(comment.getReplyid()).get();
                infoOperator = iInfoOperatorDAO.findById(recordCommentReply.getAssistantid()).get();
            } else {
                recordCommentReply = new RecordCommentReply();
                recordCommentReply.setText("");
                infoOperator = new InfoOperator();
                infoOperator.setId(-1l);
            }
            commentReplyVo.setRecordComment(comment);
            commentReplyVo.setRecordCommentReply(recordCommentReply);
            commentReplyVo.setInfoOperator(infoOperator);
            commentReplyVo.setInfoUser(infoUser);
            commentReplyVo.setOrderSmall(orderSmall);
            replyVos.add(commentReplyVo);
        }
        itemCommentReplyVo = CommonUtils.sortCommentReply(replyVos, page, size);
        itemCommentReplyVo.setInfoItem(infoItem);
        return itemCommentReplyVo;
    }

    public void insert(OrderSumVo orderSumVo) {
        for (OrderSmallVo vo : orderSumVo.getOrderSmalls()) {
            RecordComment recordComment = new RecordComment();
            recordComment.setComment(vo.getRecordComment().getComment());
            recordComment.setItemid(vo.getItemid());
            recordComment.setUserid(orderSumVo.getUserid());
            recordComment.setReplyid(-1l);
            recordComment.setCreatedate(new Timestamp(System.currentTimeMillis()));
            RecordComment newRecordComment1 = iRecordCommentDAO.save(recordComment);
            OrderSmall orderSmall = iOrderSmallDAO.findById(vo.getId()).get();
            orderSmall.setCommentid(newRecordComment1.getId());
            orderSmall.setItemstar(vo.getItemstar());
            iOrderSmallDAO.save(orderSmall);
        }
        OrderSum orderSum = iOrderSumDAO.findById(orderSumVo.getId()).get();
        orderSum.setState(4l);
    }

    public void update(RecordComment recordComment) {
        iRecordCommentDAO.save(recordComment);

    }

    public void delete(Long id) {
        iRecordCommentDAO.deleteById(id);

    }

    public List<RecordComment> findAll(RecordComment recordComment) {
        return iRecordCommentDAO.findAll();
    }

    public ItemCommentVo findItemCommentSum(Long id, String name, Timestamp start, Timestamp end, int page, int size) {
        ItemCommentVo itemCommentVo = new ItemCommentVo();
        List<InfoItem> infoItems = null;
        infoItems = iInfoItemDAO.findAll(new Specification<InfoItem>() {
            public Predicate toPredicate(Root<InfoItem> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Date> startPath = root.get("createdate");
                Path<Long> idPath = root.get("id");
                Path<Long> namePath = root.get("name");
                Path<Date> endPath = root.get("createdate");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (id > 0) {
                    predicates.add(cb.equal(idPath, id));
                }
                if (StringUtils.isNotEmpty(name)) {
                    predicates.add(cb.equal(namePath, name));
                }
                if (null != start) {
                    predicates.add(cb.greaterThan(startPath, start));
                }
                if (null != end) {
                    predicates.add(cb.lessThan(endPath, end));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(0, 9999999)).getContent();
        List<CommentSumVo> commentSumVos = new ArrayList<>();
        for (InfoItem infoItem : infoItems) {
            Long count = iRecordCommentDAO.countByItemid(infoItem.getId());
            CommentSumVo commentSumVo = new CommentSumVo();
            commentSumVo.setCount(count);
            commentSumVo.setId(infoItem.getId());
            commentSumVo.setName(infoItem.getName());
            List<RecordComment> recordComment = iRecordCommentDAO.findByItemid(infoItem.getId());
            if (recordComment.size() > 0) {
                commentSumVo.setAvgstar(Double.parseDouble(iOrderSmallDAO.avgByItemid(infoItem.getId()).get(0).get("star") + ""));
            } else {
                commentSumVo.setAvgstar(0.00);
            }
            commentSumVos.add(commentSumVo);

        }
        itemCommentVo = CommonUtils.sortCommentSum(commentSumVos, page, size);
        return itemCommentVo;
    }


    public Page<RecordComment> findCommentVoByItemIdAndTime(CommentVo commentVo) {
        return iRecordCommentDAO.findAll(new Specification<RecordComment>() {

            Long itemid = Long.parseLong(commentVo.getId() + "");
            Timestamp start = commentVo.getStart();
            Timestamp end = commentVo.getEnd();

            public Predicate toPredicate(Root<RecordComment> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> itemidPath = root.get("itemid");
                Path<Date> startPath = root.get("createdate");
                Path<Date> endPath = root.get("createdate");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (itemid > 0) {
                    predicates.add(cb.equal(itemidPath, itemid));
                }
                if (null != start) {
                    predicates.add(cb.greaterThan(startPath, start));
                }
                if (null != end) {
                    predicates.add(cb.lessThan(endPath, end));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(commentVo.getPage() - 1, commentVo.getSize()));
    }
}