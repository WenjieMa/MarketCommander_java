package com.dao;

import com.pojo.OrderSmall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderSmallDAO extends JpaRepository<OrderSmall, Long> {
}