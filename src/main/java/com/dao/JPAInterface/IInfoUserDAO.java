package com.dao.JPAInterface;

import com.pojo.InfoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IInfoUserDAO extends JpaRepository<InfoUser, Long>, JpaSpecificationExecutor<InfoUser> {
    @Query("select u from InfoUser u where u.username = ?1 and u.password = ?2")
    List<InfoUser> login(String username, String password);

    @Modifying
    @Transactional
    @Query("update InfoUser u set u.password = ?1 where u.username = ?2")
    int updateForget(String password, String username);


    List<InfoUser> findByUsernameAndPhone(String username, String phone);
}