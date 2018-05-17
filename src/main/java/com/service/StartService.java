package com.service;

import com.dao.JPAInterface.IHomeColumnsLevel1DAO;
import com.dao.JPAInterface.IHomeColumnsLevel2DAO;
import com.dao.JPAInterface.IHomeStartimagesDAO;
import com.dto.PageTools;
import com.pojo.HomeColumnsLevel1;
import com.pojo.HomeColumnsLevel2;
import com.pojo.HomeStartimages;
import com.vo.ColumnVo;
import com.vo.PageVo;
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
public class StartService {
    @Autowired
    IHomeColumnsLevel1DAO iHomeColumnsLevel1DAO;

    @Autowired
    IHomeColumnsLevel2DAO iHomeColumnsLevel2DAO;

    @Autowired
    IHomeStartimagesDAO iHomeStartimagesDAO;

    public void insertImage(HomeStartimages homeStartimages) {
        iHomeStartimagesDAO.save(homeStartimages);
    }

    public void updateImage(HomeStartimages homeStartimages) {
        iHomeStartimagesDAO.save(homeStartimages);

    }

    public void deleteImage(Long id) {
        iHomeStartimagesDAO.deleteById(id);

    }

    public Page<HomeStartimages> findAllImage(PageVo pageVo) {
        return iHomeStartimagesDAO.findAll(PageTools.basicPage(pageVo.getPage(), pageVo.getSize()));
    }

    public void insert(HomeColumnsLevel1 homeColumnsLevel1) {

        iHomeColumnsLevel1DAO.save(homeColumnsLevel1);
    }

    public void update(HomeColumnsLevel1 homeColumnsLevel1) {
        iHomeColumnsLevel1DAO.save(homeColumnsLevel1);

    }

    public void delete(Long id) {
        iHomeColumnsLevel1DAO.deleteById(id);

    }

    public Page<HomeColumnsLevel1> findAll(PageVo pageVo) {
        return iHomeColumnsLevel1DAO.findAll(PageTools.basicPage(pageVo.getPage(), pageVo.getSize()));
    }


    public void insert2(HomeColumnsLevel2 homeColumnsLevel2) {
        iHomeColumnsLevel2DAO.save(homeColumnsLevel2);
    }

    public void update2(HomeColumnsLevel2 homeColumnsLevel2) {
        iHomeColumnsLevel2DAO.save(homeColumnsLevel2);

    }

    public void delete2(Long id) {
        iHomeColumnsLevel2DAO.deleteById(id);

    }

    public Page<HomeColumnsLevel2> findAll2(ColumnVo columnVo) {
        return iHomeColumnsLevel2DAO.findAll(new Specification<HomeColumnsLevel2>() {
            int parentid = columnVo.getParentid();

            public Predicate toPredicate(Root<HomeColumnsLevel2> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> parentidPath = root.get("parentid");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (null != parentid + "") {
                    predicates.add(cb.equal(parentidPath, parentid));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(columnVo.getPage() - 1, columnVo.getSize()));
    }

}