package com.dao.JPAInterface;

import com.pojo.HomeColumnsLevel1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IHomeColumnsLevel1DAO extends JpaRepository<HomeColumnsLevel1, Long>,JpaSpecificationExecutor<HomeColumnsLevel1> {
}