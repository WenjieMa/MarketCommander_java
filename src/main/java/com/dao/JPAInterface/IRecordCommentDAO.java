package com.dao.JPAInterface;

import com.pojo.RecordComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRecordCommentDAO extends JpaRepository<RecordComment, Long> ,JpaSpecificationExecutor<RecordComment> {
}