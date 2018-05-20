package com.vo;

import com.pojo.OrderSum;

import java.sql.Timestamp;
import java.util.List;

public class OrderSumPageVo implements java.io.Serializable {
    private int totalPages;
    private Long totalElements;

    public List<OrderSumVo> getOrderSumVos() {
        return orderSumVos;
    }

    public void setOrderSumVos(List<OrderSumVo> orderSumVos) {
        this.orderSumVos = orderSumVos;
    }

    private List<OrderSumVo> orderSumVos;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}