package com.service;

import com.dao.JPAInterface.*;
import com.dao.JPAInterface.IOrderSmallDAO;
import com.dao.daoimpl.OrderSumDAO;
import com.dto.PageTools;
import com.pojo.*;
import com.pojo.OrderSmall;
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
public class OrderService {
    @Autowired
    IOrderSmallDAO iOrderSmallDAO;

    @Autowired
    IOrderSumDAO iOrderSumDAO;

    @Autowired
    IInfoItemDAO iInfoItemDAO;

    @Autowired
    IRecordCommentDAO iRecordCommentDAO;

    @Autowired
    IRecordCommentReplyDAO iRecordCommentReplyDAO;


    public boolean insert(OrderSumVo orderSumVo) {
        OrderSum orderSum = new OrderSum();
        orderSum.setAddress(orderSumVo.getAddress());
        orderSum.setCount(orderSumVo.getCount());
        orderSum.setCreatedate(new Timestamp(System.currentTimeMillis()));
        orderSum.setUserid(orderSumVo.getUserid());
        orderSum.setState(0l);
        orderSum.setPhone(orderSumVo.getPhone());
        orderSum.setTotalprice(orderSumVo.getSumprice());
        orderSum.setType(orderSumVo.getType());

        Long orderSumId = iOrderSumDAO.save(orderSum).getId();
        for (OrderSmallVo orderSmallVo : orderSumVo.getOrderSmalls()) {
            InfoItem infoItem= iInfoItemDAO.findById(orderSmallVo.getItemid()).get();
            if(infoItem.getStore()-orderSmallVo.getQuantity()<0){
                return false;
            }else{
                infoItem.setStore(infoItem.getStore()-orderSmallVo.getQuantity());
                iInfoItemDAO.save(infoItem);
            }
            OrderSmall orderSmall = new OrderSmall();
            orderSmall.setCreatedate(new Timestamp(System.currentTimeMillis()));
            orderSmall.setItemid(orderSmallVo.getData().getId());
            orderSmall.setQuantity(orderSmallVo.getQuantity());
            orderSmall.setSumid(orderSumId);
            orderSmall.setItemstar(0d);
            orderSmall.setCommentid(-1l);
            orderSmall.setAddcommentid(-1l);
            iOrderSmallDAO.save(orderSmall);
        }
        return true;
    }

    public void update(OrderSum orderSum) {
        iOrderSumDAO.save(orderSum);

    }

    public void sendDelivery(DeliveryVo deliveryVo) {
        OrderSum orderSum = findOrdersumbyId(deliveryVo.getId());
        orderSum.setDeliveryid(deliveryVo.getDeliveryid());
        orderSum.setState(2l);
        iOrderSumDAO.save(orderSum);
    }

    public void updateState(OrderSumVo orderSumVo) {
        OrderSum orderSum = findOrdersumbyId(orderSumVo.getId());
        orderSum.setState(orderSumVo.getState());
        iOrderSumDAO.save(orderSum);
    }

    public void deleteSum(Long id) {
        iOrderSumDAO.deleteById(id);

    }

    public void insert(OrderSmall orderSmall) {
        iOrderSmallDAO.save(orderSmall);
    }

    public OrderSum findOrdersumbyId(Long id) {
        return iOrderSumDAO.findById(id).get();
    }

    public void update(OrderSmall orderSmall) {
        iOrderSmallDAO.save(orderSmall);

    }

    public void delete(Long id) {
        iOrderSmallDAO.deleteById(id);

    }

    public List<OrderSmall> findOrderSmallBySumid(Long sumid) {
        return iOrderSmallDAO.findBySumid(sumid);
    }

    public List<OrderSmallVo> findOrderSmallVoBySumid(Long sumid) {
        List<OrderSmallVo> orderSmallVos = new ArrayList<OrderSmallVo>();
        List<OrderSmall> orderSmalls = iOrderSmallDAO.findBySumid(sumid);
        for (OrderSmall orderSmall : orderSmalls) {
            OrderSmallVo orderSmallVo = new OrderSmallVo();
            InfoItem infoItem = iInfoItemDAO.findById(orderSmall.getItemid()).get();
            RecordComment recordComment = null;
            RecordCommentReply addRecordComment = null;
            if (orderSmall.getCommentid() != -1l) {
                recordComment = iRecordCommentDAO.findById(orderSmall.getCommentid()).get();
            }else{
                recordComment=new RecordComment();
                recordComment.setComment("无");
            }
            if (orderSmall.getAddcommentid() != -1l) {
                addRecordComment = iRecordCommentReplyDAO.findById(orderSmall.getAddcommentid()).get();
            }else{
                addRecordComment = new RecordCommentReply();
                addRecordComment.setText("无");
            }
            orderSmallVo.setData(new OrderItemVo(infoItem));
            orderSmallVo.setAddRecordComment(addRecordComment);
            orderSmallVo.setRecordComment(recordComment);
            orderSmallVo.setId(orderSmall.getId());
            orderSmallVo.setItemstar(orderSmall.getItemstar());
            orderSmallVo.setQuantity(orderSmall.getQuantity());
            orderSmallVo.setSumid(orderSmall.getSumid());
            orderSmallVo.setItemstar(orderSmall.getItemstar());
            orderSmallVos.add(orderSmallVo);
        }
        return orderSmallVos;
    }

    public Page<OrderSum> findOrderSumByParams(OrderSumSearchVo orderSum) {
        return iOrderSumDAO.findAll(new Specification<OrderSum>() {
            Long id = orderSum.getId();
            Long userid = orderSum.getUserid();
            String type = orderSum.getType();
            int state = orderSum.getState();
            Timestamp start = orderSum.getStart();
            Timestamp end = orderSum.getEnd();

            public Predicate toPredicate(Root<OrderSum> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Date> startPath = root.get("createdate");
                Path<Date> endPath = root.get("createdate");
                Path<Long> idPath = root.get("id");
                Path<Long> useridPath = root.get("userid");
                Path<Long> typePath = root.get("type");
                Path<Long> statePath = root.get("state");

                List<Predicate> predicates = new ArrayList<Predicate>();
                if (null != type) {
                    predicates.add(cb.equal(typePath, type));
                }
                if (id > 0) {
                    predicates.add(cb.equal(idPath, id));
                }

                if (userid > 0) {
                    predicates.add(cb.equal(useridPath, userid));
                }

                if (state > 0) {
                    predicates.add(cb.equal(statePath, state));
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

        }, new PageRequest(orderSum.getPage() - 1, orderSum.getSize()));
    }


    public OrderSumPageVo findOrderSumVoByUserid(UserVo userVo) {
        List<OrderSumVo> orderSumVos = new ArrayList<OrderSumVo>();
        OrderSumPageVo orderSumPageVo = new OrderSumPageVo();
        Page<OrderSum> orderSumPage = iOrderSumDAO.findAll(new Specification<OrderSum>() {
            Long userid = userVo.getId();

            public Predicate toPredicate(Root<OrderSum> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> useridPath = root.get("userid");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (userid > 0) {
                    predicates.add(cb.equal(useridPath, userid));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, new PageRequest(userVo.getPage() - 1, userVo.getSize()));
        List<OrderSum> orderSums = orderSumPage.getContent();
        System.out.println("总订单数：" + orderSums.size());
        for (OrderSum sum : orderSums) {
            OrderSumVo orderSumVo = new OrderSumVo(sum);
            orderSumVo.setId(sum.getId());
            List<OrderSmallVo> orderSmallVos = new ArrayList<OrderSmallVo>();
            List<OrderSmall> orderSmalls = findOrderSmallBySumid(sum.getId());
            for (OrderSmall orderSmall : orderSmalls) {
                OrderSmallVo orderSmallVo = new OrderSmallVo();
                InfoItem infoItem = iInfoItemDAO.findById(orderSmall.getItemid()).get();
                System.out.println(infoItem+"123");
                RecordComment recordComment = null;
                RecordCommentReply addRecordComment = null;
                if (orderSmall.getCommentid() != -1l) {
                    recordComment = iRecordCommentDAO.findById(orderSmall.getCommentid()).get();
                }else{
                    recordComment=new RecordComment();
                    recordComment.setComment("无");
                }
                if (orderSmall.getAddcommentid() != -1l) {
                    addRecordComment = iRecordCommentReplyDAO.findById(orderSmall.getAddcommentid()).get();
                }else{
                    addRecordComment = new RecordCommentReply();
                    addRecordComment.setText("无");
                }
                orderSmallVo.setData(new OrderItemVo(infoItem));
                orderSmallVo.setAddRecordComment(addRecordComment);
                orderSmallVo.setRecordComment(recordComment);
                orderSmallVo.setId(orderSmall.getId());
                orderSmallVo.setItemid(orderSmall.getItemid());
                orderSmallVo.setItemstar(orderSmall.getItemstar());
                orderSmallVo.setQuantity(orderSmall.getQuantity());
                orderSmallVo.setSumid(orderSmall.getSumid());
                orderSmallVo.setItemstar(orderSmall.getItemstar());
                orderSmallVos.add(orderSmallVo);
            }
            orderSumVo.setOrderSmalls(orderSmallVos);
            orderSumVos.add(orderSumVo);
        }
        orderSumPageVo.setOrderSumVos(orderSumVos);
        orderSumPageVo.setTotalElements(orderSumPage.getTotalElements());
        orderSumPageVo.setTotalPages(orderSumPage.getTotalPages());
        return orderSumPageVo;
    }

    public OrderSumVo findOrderSumVoBySumid(Long id) {
        OrderSum sum = iOrderSumDAO.findById(id).get();
        OrderSumVo orderSumVo = new OrderSumVo(sum);
        orderSumVo.setId(sum.getId());
        List<OrderSmallVo> orderSmallVos = new ArrayList<OrderSmallVo>();
        List<OrderSmall> orderSmalls = findOrderSmallBySumid(sum.getId());
        for (OrderSmall orderSmall : orderSmalls) {
            OrderSmallVo orderSmallVo = new OrderSmallVo();
            InfoItem infoItem = iInfoItemDAO.findById(orderSmall.getItemid()).get();
            RecordComment recordComment = null;
            RecordCommentReply addRecordComment = null;
            if (orderSmall.getCommentid() != -1l) {
                recordComment = iRecordCommentDAO.findById(orderSmall.getCommentid()).get();
            }else{
                recordComment=new RecordComment();
                recordComment.setComment("无");
            }
            if (orderSmall.getAddcommentid() != -1l) {
                addRecordComment = iRecordCommentReplyDAO.findById(orderSmall.getAddcommentid()).get();
            }else{
                addRecordComment = new RecordCommentReply();
                addRecordComment.setText("无");
            }
            orderSmallVo.setData(new OrderItemVo(infoItem));
            orderSmallVo.setAddRecordComment(addRecordComment);
            orderSmallVo.setRecordComment(recordComment);
            orderSmallVo.setId(orderSmall.getId());
            orderSmallVo.setItemid(orderSmall.getItemid());
            orderSmallVo.setItemstar(orderSmall.getItemstar());
            orderSmallVo.setQuantity(orderSmall.getQuantity());
            orderSmallVo.setSumid(orderSmall.getSumid());
            orderSmallVo.setItemstar(orderSmall.getItemstar());
            orderSmallVos.add(orderSmallVo);
        }
        orderSumVo.setOrderSmalls(orderSmallVos);
        return orderSumVo;
    }
}