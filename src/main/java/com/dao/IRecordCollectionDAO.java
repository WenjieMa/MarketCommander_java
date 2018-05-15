package com.dao;

import com.pojo.RecordCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecordCollectionDAO extends JpaRepository<RecordCollection, Long> {
}