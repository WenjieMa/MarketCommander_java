package com.service;

import com.dao.JPAInterface.IHomeHotsearchDAO;
import com.dao.JPAInterface.IHomeHotsearchDAO;
import com.dao.JPAInterface.IRecordImportDAO;
import com.dto.PageTools;
import com.pojo.HomeHotsearch;
import com.pojo.HomeHotsearch;
import com.pojo.RecordImport;
import com.vo.ImportVo;
import com.vo.ImportingVo;
import com.vo.ItemVo;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class HomeHotSearchService {
    @Autowired
    IHomeHotsearchDAO iHomeHotsearchDAO;

    public void insert(HomeHotsearch homeHotsearch) {
        iHomeHotsearchDAO.save(homeHotsearch);
    }

    public void update(HomeHotsearch homeHotsearch) {
        iHomeHotsearchDAO.save(homeHotsearch);

    }

    public void delete(Long id) {
        iHomeHotsearchDAO.deleteById(id);

    }

    public Page<HomeHotsearch> findAll(PageVo pageVo) {
        return iHomeHotsearchDAO.findAll(PageTools.basicPage(pageVo.getPage(), pageVo.getSize()));
    }

}