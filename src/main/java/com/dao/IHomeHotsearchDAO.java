package com.dao;

import com.pojo.HomeHotsearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHomeHotsearchDAO extends JpaRepository<HomeHotsearch, Long> {
}