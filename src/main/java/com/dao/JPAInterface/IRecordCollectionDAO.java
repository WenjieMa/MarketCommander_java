package com.dao.JPAInterface;

import com.pojo.RecordCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRecordCollectionDAO extends JpaRepository<RecordCollection, Long>,JpaSpecificationExecutor<RecordCollection> {
}