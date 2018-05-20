package com.vo;

import com.pojo.*;

import java.sql.Timestamp;
import java.util.List;

public class OrderSmallVo implements java.io.Serializable {

    // Fields

    private Long id;
    private Long sumid;
    private OrderItemVo data;
    private Long quantity;
    private Double itemstar;
    private RecordComment recordComment;
    private RecordCommentReply addRecordComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSumid() {
        return sumid;
    }

    public void setSumid(Long sumid) {
        this.sumid = sumid;
    }

    public OrderItemVo getData() {
        return data;
    }

    public void setData(OrderItemVo data) {
        this.data = data;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getItemstar() {
        return itemstar;
    }

    public void setItemstar(Double itemstar) {
        this.itemstar = itemstar;
    }

    public RecordComment getRecordComment() {
        return recordComment;
    }

    public void setRecordComment(RecordComment recordComment) {
        this.recordComment = recordComment;
    }

    public RecordCommentReply getAddRecordComment() {
        return addRecordComment;
    }

    public void setAddRecordComment(RecordCommentReply addRecordComment) {
        this.addRecordComment = addRecordComment;
    }
}