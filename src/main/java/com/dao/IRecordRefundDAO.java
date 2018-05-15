package com.dao;

import com.pojo.RecordRefund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecordRefundDAO extends JpaRepository<RecordRefund, Long> {
}