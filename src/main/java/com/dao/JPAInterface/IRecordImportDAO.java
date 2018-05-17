package com.dao.JPAInterface;

import com.pojo.RecordImport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRecordImportDAO extends JpaRepository<RecordImport, Long> ,JpaSpecificationExecutor<RecordImport> {
}