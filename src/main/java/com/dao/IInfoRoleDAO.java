package com.dao;

import com.pojo.InfoRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoRoleDAO extends JpaRepository<InfoRole, Long> {
}