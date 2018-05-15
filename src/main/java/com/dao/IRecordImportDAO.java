package com.dao;

import com.pojo.RecordImport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecordImportDAO extends JpaRepository<RecordImport, Long> {
}