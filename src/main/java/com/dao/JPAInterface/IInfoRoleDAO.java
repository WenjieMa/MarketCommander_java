package com.dao.JPAInterface;

import com.pojo.InfoOperator;
import com.pojo.InfoRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IInfoRoleDAO extends JpaRepository<InfoRole, Long>, JpaSpecificationExecutor<InfoRole> {

    List<InfoRole> findByIdIn(List<Long> ids);

}