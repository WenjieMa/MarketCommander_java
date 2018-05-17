package com.dao.JPAInterface;

import com.pojo.RecordCommentReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRecordCommentReplyDAO extends JpaRepository<RecordCommentReply, Long> ,JpaSpecificationExecutor<RecordCommentReply> {
}