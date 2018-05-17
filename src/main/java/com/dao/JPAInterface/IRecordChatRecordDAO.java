package com.dao.JPAInterface;

import com.pojo.RecordChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRecordChatRecordDAO extends JpaRepository<RecordChatRecord, Long> ,JpaSpecificationExecutor<RecordChatRecord> {
}