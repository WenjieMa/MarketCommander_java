package com.dao;

import com.pojo.DistrictCounty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistrictCountyDAO extends JpaRepository<DistrictCounty, Long> {
}