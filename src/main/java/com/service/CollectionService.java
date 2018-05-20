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
    }

    public void update(RecordCollection recordCollection) {
        iRecordCollectionDAO.save(recordCollection);

    }

    public int delete(Long userid, Long itemid) {
        int n = iRecordCollectionDAO.deleteByUseridAndItemid(userid, itemid);
        System.out.println("删除了" + userid + "的" + itemid + "条数" + n);
        return n;
    }

    public Page<InfoItem> findAll(CollectionVo collectionVo) {

        List<RecordCollection> recordCollections = iRecordCollectionDAO.findByUserid(collectionVo.getRecordCollection().getUserid());
        ArrayList ids = new ArrayList<Long>();
        for (RecordCollection recordCollection : recordCollections) {
            ids.add(recordCollection.getItemid());
        }
        return iInfoItemDAO.findAll(new Specification<InfoItem>() {
            List<Long> idlist = ids;

            public Predicate toPredicate(Root<InfoItem> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (Object id : ids) {
                    Path<List<Long>> idPath = root.get("id");
                    predicates.add(cb.or(cb.equal(idPath, id)));
                }
                if (ids.size() == 0) {
                    Path<List<Long>> idPath = root.get("id");
                    predicates.add(cb.equal(idPath, -1));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, new PageRequest(collectionVo.getPage() - 1, collectionVo.getSize()));
    }
}