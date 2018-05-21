package com.service;

import com.dao.JPAInterface.IInfoItemDAO;
import com.dao.JPAInterface.IRecordCollectionDAO;
import com.dao.JPAInterface.IRecordCollectionDAO;
import com.dto.PageTools;
import com.pojo.*;
import com.pojo.RecordCollection;
import com.vo.CollectionVo;
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

    @Autowired
    IInfoItemDAO iInfoItemDAO;

    public void insert(RecordCollection recordCollection) {
        iRecordCollectionDAO.save(recordCollection);
        InfoItem infoItem=iInfoItemDAO.findById(recordCollection.getItemid()).get();
        infoItem.setLikes(infoItem.getLikes()+1);
    }

    public RecordCollection findByUserIdAndItemId(Long itemid,Long userid) {
        List<RecordCollection> recordCollections = iRecordCollectionDAO.findByUseridAndItemid(userid, itemid);
        return recordCollections.size() == 0 ? null : recordCollections.get(0);

    }

    public void update(RecordCollection recordCollection) {
        iRecordCollectionDAO.save(recordCollection);

    }

    public int delete(Long userid, Long itemid) {
        int n = iRecordCollectionDAO.deleteByUseridAndItemid(userid, itemid);
        InfoItem infoItem=iInfoItemDAO.findById(itemid).get();
        infoItem.setLikes(infoItem.getLikes()-1);
        System.out.println("删除了" + userid + "的" + itemid + "条数" + n);
        return n;
    }

    public Page<InfoItem> findAll(CollectionVo collectionVo) {

        List<RecordCollection> recordCollections = iRecordCollectionDAO.findByUserid(collectionVo.getRecordCollection().getUserid());
        ArrayList ids = new ArrayList<Long>();
        for (RecordCollection recordCollection : recordCollections) {
            ids.add(recordCollection.getItemid());
        }
        Page<InfoItem> infoItemPage = iInfoItemDAO.findAllByIdIn(ids, PageRequest.of(collectionVo.getPage()-1, collectionVo.getSize()));
        System.out.println(infoItemPage.getContent().size() + "+++");
        return infoItemPage;
    }

    public Page<InfoItem> findAll(Long userid, int page, int size) {

        List<RecordCollection> recordCollections = iRecordCollectionDAO.findByUserid(userid);
        ArrayList ids = new ArrayList<Long>();
        for (RecordCollection recordCollection : recordCollections) {
            ids.add(recordCollection.getItemid());
        }
        Page<InfoItem> infoItemPage = iInfoItemDAO.findAllByIdIn(ids, PageRequest.of(page - 1, size));
        System.out.println(infoItemPage.getContent().size() + "+++");
        return infoItemPage;
    }
}