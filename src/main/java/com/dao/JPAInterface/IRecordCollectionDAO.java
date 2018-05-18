package com.dao.JPAInterface;

import com.pojo.RecordAssistant2role;
import com.pojo.RecordCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IRecordCollectionDAO extends JpaRepository<RecordCollection, Long>, JpaSpecificationExecutor<RecordCollection> {

    List<RecordCollection> findByUseridAndItemid(Long userid, Long itemid);

    int deleteByUseridAndItemid(Long userid, Long itemid);

    List<RecordCollection> findByUserid(Long userid);

}