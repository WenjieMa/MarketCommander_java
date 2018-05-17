package com.dao.JPAInterface;

import com.pojo.OrderSmall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IOrderSmallDAO extends JpaRepository<OrderSmall, Long> ,JpaSpecificationExecutor<OrderSmall> {
}