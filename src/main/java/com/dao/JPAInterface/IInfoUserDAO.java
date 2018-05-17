package com.dao.JPAInterface;

import com.pojo.InfoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IInfoUserDAO extends JpaRepository<InfoUser, Long> ,JpaSpecificationExecutor<InfoUser> {
}