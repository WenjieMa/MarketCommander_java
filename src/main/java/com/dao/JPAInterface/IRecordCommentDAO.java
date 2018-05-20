package com.dao.JPAInterface;

import com.pojo.RecordComment;
import com.vo.CommentSumVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface IRecordCommentDAO extends JpaRepository<RecordComment, Long>, JpaSpecificationExecutor<RecordComment> {

    Long countByItemid(Long itemid);

    List<RecordComment> findByItemid(Long itemid);
}