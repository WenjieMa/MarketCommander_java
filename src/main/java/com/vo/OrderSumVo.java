package com.vo;

import com.pojo.OrderSum;

import java.sql.Timestamp;
import java.util.List;

public class OrderSumVo implements java.io.Serializable {

    // Fields

    private Long id;
    private Long userid;
    private String type;
    private Double sumprice;
    private String address;
    private Long deliveryid;
    private String phone;
    private Long state;
    private Long count;
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    private Timestamp createdate;
    private List<OrderSmallVo> orderSmalls;

    public OrderSumVo() {
    }

    public OrderSumVo(OrderSum orderSum) {
        this.phone=  orderSum.getPhone();
        this.count = orderSum.getCount();
        this.userid = orderSum.getUserid();
        this.type = orderSum.getType();
        this.sumprice = orderSum.getTotalprice();
        this.address = orderSum.getAddress();
        this.deliveryid = orderSum.getDeliveryid();
        this.state =orderSum.getState();
    }

    public List<OrderSmallVo> getOrderSmalls() {
        return orderSmalls;
    }

    public void setOrderSmalls(List<OrderSmallVo> orderSmalls) {
        this.orderSmalls = orderSmalls;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getUserid() {
        return this.userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }


    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Double getSumprice() {
        return this.sumprice;
    }

    public void setSumprice(Double sumprice) {
        this.sumprice = sumprice;
    }


    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Long getDeliveryid() {
        return this.deliveryid;
    }

    public void setDeliveryid(Long deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Timestamp getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

}