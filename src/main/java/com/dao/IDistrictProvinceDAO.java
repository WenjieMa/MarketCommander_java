package com.dao;

import com.pojo.DistrictProvince;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistrictProvinceDAO extends JpaRepository<DistrictProvince, Long> {
}