package com.dao;

import com.pojo.InfoUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInfoUserDAO extends JpaRepository<InfoUser, Long> {
}