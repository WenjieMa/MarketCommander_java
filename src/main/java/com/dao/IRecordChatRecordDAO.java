package com.dao;

import com.pojo.RecordChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecordChatRecordDAO extends JpaRepository<RecordChatRecord, Long> {
}