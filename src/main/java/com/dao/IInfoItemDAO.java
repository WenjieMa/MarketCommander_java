package com.dao;

import com.pojo.InfoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoItemDAO extends JpaRepository<InfoItem, Long> {
}