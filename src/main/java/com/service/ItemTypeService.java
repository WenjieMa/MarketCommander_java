package com.service;

import com.dao.JPAInterface.IInfoItemTypeDAO;
import com.dto.PageTools;
import com.pojo.InfoItemType;
import com.vo.ItemTypeVo;
import org.apache.commons.lang3.StringUtils;
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

    public Page<InfoItemType> findAll(ItemTypeVo itemTypeVo) {
        return iInfoItemTypeDAO.findAll(PageTools.basicPage(itemTypeVo.getPage(), itemTypeVo.getSize()));
    }

    public Page<InfoItemType> findByName(ItemTypeVo itemTypeVo) {
        return iInfoItemTypeDAO.findAll(new Specification<InfoItemType>() {

            String typename = itemTypeVo.getTypename();

            public Predicate toPredicate(Root<InfoItemType> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> typenamePath = root.get("typename");
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (StringUtils.isNotEmpty(typename)) {
                    predicates.add(cb.equal(typenamePath, typename));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(itemTypeVo.getPage() - 1, itemTypeVo.getSize()));
    }
}