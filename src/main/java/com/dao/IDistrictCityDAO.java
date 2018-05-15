package com.dao;

import com.pojo.DistrictCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDistrictCityDAO extends JpaRepository<DistrictCity, Long> {
}