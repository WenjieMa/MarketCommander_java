package com.service;

import com.dao.JPAInterface.IInfoOperatorDAO;
import com.dao.JPAInterface.IInfoRoleDAO;
import com.dao.JPAInterface.IInfoRoleDAO;
import com.dao.JPAInterface.IRecordAssistant2roleDAO;
import com.dto.PageTools;
import com.pojo.*;
import com.vo.ItemTypeVo;
import com.vo.PageVo;
import com.vo.RoleVo;
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
public class RoleService {
    @Autowired
    IInfoRoleDAO iInfoRoleDAO;

    @Autowired
    IRecordAssistant2roleDAO iRecordAssistant2roleDAO;

    @Autowired
    IInfoOperatorDAO iInfoOperatorDAO;

    public void insert(InfoRole infoRole) {
        iInfoRoleDAO.save(infoRole);
    }

    public void update(InfoRole infoRole) {
        iInfoRoleDAO.save(infoRole);

    }

    public void delete(Long id) {
        iInfoRoleDAO.deleteById(id);

    }

    public Page<InfoRole> findAll(PageVo pageVo) {
        return iInfoRoleDAO.findAll(PageTools.basicPage(pageVo.getPage(), pageVo.getSize()));
    }

    public List<InfoRole> findRole2Operator(InfoOperator infoOperator) {
        List<RecordAssistant2role> recordAssistant2roles = iRecordAssistant2roleDAO.findByAssistantid(infoOperator.getId());
        ArrayList ids = new ArrayList<Long>();
        for (RecordAssistant2role role : recordAssistant2roles) {
            ids.add(role.getRoleid());
        }
        return iInfoRoleDAO.findByIdIn(ids);

    }


    public void insertRole2Assistant(RecordAssistant2role infoRole) {

        iRecordAssistant2roleDAO.save(infoRole);
    }

    public void updateRole2Assistant(RecordAssistant2role infoRole) {
        iRecordAssistant2roleDAO.save(infoRole);

    }

    public void deleteRole2Assistant(RecordAssistant2role recordAssistant2role) {
        int n = iRecordAssistant2roleDAO.deleteByAssistantidAndRoleid(recordAssistant2role.getAssistantid(), recordAssistant2role.getRoleid());
        System.out.println("删除了" + n + "条");
    }

    public Page<InfoOperator> findAllRole2Assistant(RoleVo roleVo) {
        List<RecordAssistant2role> recordAssistant2roles = iRecordAssistant2roleDAO.findByRoleid(roleVo.getRoleid());
        ArrayList ids = new ArrayList<Long>();
        for (RecordAssistant2role role : recordAssistant2roles) {
            ids.add(role.getAssistantid());
        }
        if (ids.size() == 0) {
            ids.add(-1l);
        }
        return iInfoOperatorDAO.findAll(new Specification<InfoOperator>() {
            List<Long> idlist = ids;

            public Predicate toPredicate(Root<InfoOperator> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> idPath = root.get("id");
                List<Predicate> predicates = new ArrayList<Predicate>();
                for (Long id : idlist) {
                    predicates.add(cb.or(cb.equal(idPath, id)));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, new PageRequest(roleVo.getPage() - 1, roleVo.getSize()));

    }

    public Page<InfoOperator> findAllRole2AssistantNone(RoleVo roleVo) {
        List<RecordAssistant2role> recordAssistant2roles = iRecordAssistant2roleDAO.findByRoleid(roleVo.getRoleid());
        ArrayList ids = new ArrayList<Long>();
        for (RecordAssistant2role role : recordAssistant2roles) {
            ids.add(role.getAssistantid());
        }
        return iInfoOperatorDAO.findAllByIdIn(ids,PageRequest.of(roleVo.getPage()-1,roleVo.getSize()));
    }


}