package com.dao.JPAInterface;

import com.pojo.InfoItemType;
import com.pojo.InfoOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInfoItemTypeDAO extends JpaRepository<InfoItemType, Long> ,JpaSpecificationExecutor<InfoItemType>{
}