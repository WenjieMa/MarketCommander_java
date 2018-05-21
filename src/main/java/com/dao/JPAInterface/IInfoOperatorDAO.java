package com.dao.JPAInterface;

import com.pojo.InfoOperator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IInfoOperatorDAO extends JpaRepository<InfoOperator, Long>, JpaSpecificationExecutor<InfoOperator> {

    List<InfoOperator> findByUsername(String username);

    Page<InfoOperator> findAllByIdNotIn(List<Long> ids, Pageable pageable);

    Page<InfoOperator> findAllByIdIn(List<Long> ids, Pageable pageable);

    @Query("select u from InfoOperator u where u.username = ?1 and u.password = ?2")
    List<InfoOperator> login(String username, String password);

    List<InfoOperator> findByUsernameAndPhone(String username, String phone);

    @Modifying
    @Transactional
    @Query("update InfoOperator u set u.password = ?1 where u.username = ?2")
    int updateForget(String password, String username);

}