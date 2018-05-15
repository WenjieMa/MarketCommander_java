package com.dao;

import com.pojo.InfoExpress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoExpressDAO extends JpaRepository<InfoExpress, Long> {
}