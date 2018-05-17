package com.dao.JPAInterface;

import com.pojo.OrderSum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IOrderSumDAO extends JpaRepository<OrderSum, Long>,JpaSpecificationExecutor<OrderSum> {
}