package com.dao.JPAInterface;

import com.pojo.InfoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInfoItemDAO extends JpaRepository<InfoItem, Long>,JpaSpecificationExecutor<InfoItem> {

}