package com.service;

import com.dao.JPAInterface.IRecordCollectionDAO;
import com.dao.JPAInterface.IRecordCollectionDAO;
import com.dto.PageTools;
import com.pojo.RecordCollection;
import com.pojo.RecordCollection;
import com.vo.ItemTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CollectionService {
    @Autowired
    IRecordCollectionDAO iRecordCollectionDAO;

    public void insert(RecordCollection recordCollection) {
        iRecordCollectionDAO.save(recordCollection);
    }

    public void update(RecordCollection recordCollection) {
        iRecordCollectionDAO.save(recordCollection);

    }

    public int delete(Long userid,Long itemid) {
        return iRecordCollectionDAO.deleteByUseridAndItemid(userid,itemid);
    }

    public List<RecordCollection> findAll(Long userid) {
        return iRecordCollectionDAO.findByUserid(userid);
    }
}