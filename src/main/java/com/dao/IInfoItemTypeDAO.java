package com.dao;

import com.pojo.InfoItemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoItemTypeDAO extends JpaRepository<InfoItemType, Long> {
}