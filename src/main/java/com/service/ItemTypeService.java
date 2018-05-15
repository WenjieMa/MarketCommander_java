package com.service;

import com.dao.IInfoItemTypeDAO;
import com.pojo.InfoItemType;
import com.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemTypeService {
    @Autowired
    IInfoItemTypeDAO iInfoItemTypeDAO;

    public void insert(InfoItemType infoItemType) {
        iInfoItemTypeDAO.save(infoItemType);
    }

    public void update(InfoItemType infoItemType) {
        iInfoItemTypeDAO.save(infoItemType);

    }

    public void delete(Long id) {
        iInfoItemTypeDAO.deleteById(id);

    }

    public List<InfoItemType> findAll(PageInfo page) {

        return null;
    }
}
