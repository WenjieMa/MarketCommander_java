package com.service;

import com.dao.JPAInterface.*;
import com.pojo.InfoItem;
import com.pojo.OrderSmall;
import com.pojo.OrderSum;
import com.pojo.RecordComment;
import com.utils.common.CommonUtils;
import com.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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

    public void insert(OrderSumVo orderSumVo) {
        for (OrderSmallVo vo : orderSumVo.getOrderSmalls()) {
            RecordComment recordComment = new RecordComment();
            recordComment.setComment(vo.getRecordComment().getComment());
            recordComment.setItemid(vo.getId());
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

    public ItemCommentVo findItemCommentSum(CommentVo commentVo) {
        ItemCommentVo itemCommentVo = new ItemCommentVo();
        List<InfoItem> infoItems = null;
        infoItems = iInfoItemDAO.findAll(new Specification<InfoItem>() {
            Long id = commentVo.getId();
            String name = commentVo.getName();
            Date start = commentVo.getStart();
            Date end = commentVo.getEnd();

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
                if (null != name) {
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
        itemCommentVo = CommonUtils.sortCommentSum(commentSumVos, commentVo);
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