package com.dao.JPAInterface;

import com.pojo.InfoOperator;
import com.pojo.RecordAssistant2role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRecordAssistant2roleDAO extends JpaRepository<RecordAssistant2role, Long> ,JpaSpecificationExecutor<RecordAssistant2role> {

    List<RecordAssistant2role> findByAssistantid(Long assistantid);

    List<RecordAssistant2role> findByRoleid(Long roleid);

    int deleteByAssistantidAndRoleid(Long assistantid,Long roleid);

}