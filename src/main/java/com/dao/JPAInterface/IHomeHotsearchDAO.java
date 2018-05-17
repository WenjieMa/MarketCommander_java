package com.dao.JPAInterface;

import com.pojo.HomeHotsearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IHomeHotsearchDAO extends JpaRepository<HomeHotsearch, Long>,JpaSpecificationExecutor<HomeHotsearch> {
}