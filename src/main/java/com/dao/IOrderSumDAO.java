package com.dao;

import com.pojo.OrderSum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderSumDAO extends JpaRepository<OrderSum, Long> {
}