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

    public Page<InfoItem> findAll(ItemVo itemVo) {
        return iInfoItemDAO.findAll(PageTools.basicPage(itemVo.getPage(), itemVo.getSize()));
    }

    public InfoItem findById(Long id) {
        return iInfoItemDAO.findById(id).get();
    }


    public Page<RecordImport> findAllImport(ImportVo importVo) {
        return iRecordImportDAO.findAll(PageTools.basicPage(importVo.getPage(), importVo.getSize()));
    }

    public Page<RecordImport> findImportByName(ImportVo importVo) {
        return iRecordImportDAO.findAll(new Specification<RecordImport>() {

            int id = importVo.getId();
            Date start = importVo.getStart();
            Date end = importVo.getEnd();

            public Predicate toPredicate(Root<RecordImport> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Date> startPath = root.get("createdate");
                Path<Long> idPath = root.get("id");
                Path<Date> endPath = root.get("createdate");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (id > 0) {
                    predicates.add(cb.equal(idPath, id));
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

    public Page<InfoItem> findByName(ItemVo itemVo) {
        System.out.println(itemVo.getId() + "||" + itemVo.getTypeid());
        return iInfoItemDAO.findAll(new Specification<InfoItem>() {
            Long id = itemVo.getId();
            Long typeid = itemVo.getTypeid();
            String name = itemVo.getName();

            public Predicate toPredicate(Root<InfoItem> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> namePath = root.get("name");
                Path<Long> idPath = root.get("id");
                Path<Long> typeidPath = root.get("typeid");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (null != name && "" != name) {
                    predicates.add(cb.like(root.get("name").as(String.class), "%" + name + "%"));
                }
                if (null != typeid && typeid != 0) {
                    predicates.add(cb.equal(typeidPath, typeid));
                }

                if (null != id && id != 0) {
                    predicates.add(cb.equal(idPath, id));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(itemVo.getPage() - 1, itemVo.getSize()));
    }
}