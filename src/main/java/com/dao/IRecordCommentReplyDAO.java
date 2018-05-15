package com.dao;

import com.pojo.RecordCommentReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecordCommentReplyDAO extends JpaRepository<RecordCommentReply, Long> {
}