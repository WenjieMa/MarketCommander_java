package com.service;

import com.dao.JPAInterface.IInfoItemDAO;
import com.dao.JPAInterface.IRecordImportDAO;
import com.dto.PageTools;
import com.pojo.InfoItem;
import com.pojo.RecordImport;
import com.vo.ImportVo;
import com.vo.ImportingVo;
import com.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ItemService {
    @Autowired
    IInfoItemDAO iInfoItemDAO;

    @Autowired
    IRecordImportDAO iRecordImportDAO;

    public void insert(InfoItem infoItem) {
        iInfoItemDAO.save(infoItem);
    }

    public void update(InfoItem infoItem) {
        iInfoItemDAO.save(infoItem);

    }

    public void delete(Long id) {
        iInfoItemDAO.deleteById(id);

    }

    public Page<InfoItem> findAll(ItemVo itemTypeVo) {
        return iInfoItemDAO.findAll(PageTools.basicPage(itemTypeVo.getPage(), itemTypeVo.getSize()));
    }

    public Page<RecordImport> findAllImport(ImportVo importVo) {
        return iRecordImportDAO.findAll(PageTools.basicPage(importVo.getPage(), importVo.getSize()));
    }

    public Page<RecordImport> findImportByName(ImportVo importVo) {
        return iRecordImportDAO.findAll(new Specification<RecordImport>() {

            int page = importVo.getPage();
            int size = importVo.getSize();
            int id = importVo.getId();
            String name = importVo.getName();
            Date start = importVo.getStart();
            Date end = importVo.getEnd();

            public Predicate toPredicate(Root<RecordImport> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Date> startPath = root.get("start");
                Path<Long> idPath = root.get("id");
                Path<Long> namePath = root.get("name");
                Path<Date> endPath = root.get("end");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (null != name) {
                    predicates.add(cb.equal(namePath, name));
                }
                if (null != start) {
                    predicates.add(cb.greaterThan(startPath, start));
                }
                if (null != end) {
                    predicates.add(cb.lessThan(endPath, end));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(importVo.getPage() - 1, importVo.getSize()));
    }

    public void importGoods(ImportingVo importingVo) {
        InfoItem infoItem = importingVo.getInfoItem();
        infoItem.setStore(infoItem.getStore() + importingVo.getRecordImport().getAmount());
        iInfoItemDAO.save(infoItem);
        iRecordImportDAO.save(importingVo.getRecordImport());
    }

    public Page<InfoItem> findByName(ItemVo itemTypeVo) {
        return iInfoItemDAO.findAll(new Specification<InfoItem>() {
            int id = itemTypeVo.getId();
            int typeid = itemTypeVo.getTypeid();
            String name = itemTypeVo.getName();

            public Predicate toPredicate(Root<InfoItem> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> namePath = root.get("typename");
                Path<Long> idPath = root.get("id");
                Path<Long> typeidPath = root.get("typeid");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (null != name) {
                    predicates.add(cb.equal(namePath, name));
                    predicates.add(cb.equal(typeidPath, typeid));
                    predicates.add(cb.equal(idPath, id));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(itemTypeVo.getPage() - 1, itemTypeVo.getSize()));
    }
}