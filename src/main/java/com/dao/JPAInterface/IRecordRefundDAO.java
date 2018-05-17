package com.dao.JPAInterface;

import com.pojo.RecordRefund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRecordRefundDAO extends JpaRepository<RecordRefund, Long>,JpaSpecificationExecutor<RecordRefund> {
}