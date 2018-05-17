package com.dao.JPAInterface;

import com.pojo.InfoSuperOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IInfoSuperOperatorDAO extends JpaRepository<InfoSuperOperator, Long>,JpaSpecificationExecutor<InfoSuperOperator> {
}