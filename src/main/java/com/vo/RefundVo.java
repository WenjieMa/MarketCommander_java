package com.vo;

import com.pojo.RecordRefund;

import java.sql.Timestamp;

/**
 * InfoOperator entity. @author MyEclipse Persistence Tools
 */

public class RefundVo {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public RecordRefund getRecordRefund() {
        return recordRefund;
    }

    public void setRecordRefund(RecordRefund recordRefund) {
        this.recordRefund = recordRefund;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public int page;
    public int size;

    public RecordRefund recordRefund;

    public Timestamp start;
    public Timestamp end;

}