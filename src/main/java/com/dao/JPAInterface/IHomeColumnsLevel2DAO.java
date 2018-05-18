package com.dao.JPAInterface;

import com.pojo.HomeColumnsLevel2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IHomeColumnsLevel2DAO extends JpaRepository<HomeColumnsLevel2, Long>,JpaSpecificationExecutor<HomeColumnsLevel2> {

    List<HomeColumnsLevel2> findByParentid(Long parentid);
}