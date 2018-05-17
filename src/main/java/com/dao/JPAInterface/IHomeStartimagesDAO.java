package com.dao.JPAInterface;

import com.pojo.HomeStartimages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IHomeStartimagesDAO extends JpaRepository<HomeStartimages, Long> ,JpaSpecificationExecutor<HomeStartimages> {
}