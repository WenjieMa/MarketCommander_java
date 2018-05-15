package com.dao;

import com.pojo.InfoOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInfoOperatorDAO extends JpaRepository<InfoOperator, Long> {

    List<InfoOperator> findByUsername(String username);

    @Query("select u from InfoOperator u where u.username = ?1 and u.password = ?2")
    List<InfoOperator> login(String username, String password);

}