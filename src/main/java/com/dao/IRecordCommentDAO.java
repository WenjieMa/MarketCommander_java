package com.dao;

import com.pojo.RecordComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecordCommentDAO extends JpaRepository<RecordComment, Long> {
}