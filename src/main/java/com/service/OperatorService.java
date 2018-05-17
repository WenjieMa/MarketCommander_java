package com.service;

import com.dao.JPAInterface.IInfoOperatorDAO;
import com.dto.PageTools;
import com.pojo.InfoOperator;
import com.pojo.InfoOperator;
import com.vo.ItemTypeVo;
import com.vo.OperatorVo;
import com.vo.PageVo;
import com.vo.UsernameVo;
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
public class OperatorService {
    @Autowired
    IInfoOperatorDAO iInfoOperatorDAO;

    public void regist(InfoOperator infoOperator) {
        iInfoOperatorDAO.save(infoOperator);
    }

    public List<InfoOperator> login(String username, String password) {
        return iInfoOperatorDAO.login(username, password);
    }


    public void insert(InfoOperator infoOperator) {
        iInfoOperatorDAO.save(infoOperator);
    }

    public void update(InfoOperator infoOperator) {
        iInfoOperatorDAO.save(infoOperator);

    }

    public void updateForget(UsernameVo usernameVo) {
        System.out.println("账号：" + usernameVo.getPassword() + "密码：" + usernameVo.getUsername());
        iInfoOperatorDAO.updateForget(usernameVo.getPassword(), usernameVo.getUsername());

    }

    public void delete(Long id) {
        iInfoOperatorDAO.deleteById(id);

    }

    public Page<InfoOperator> findAll(PageVo pageVo) {
        return iInfoOperatorDAO.findAll(PageTools.basicPage(pageVo.getPage(), pageVo.getSize()));
    }

    public Page<InfoOperator> findByName(OperatorVo operatorVo) {
        return iInfoOperatorDAO.findAll(new Specification<InfoOperator>() {

            String name = operatorVo.getName();
            String phone = operatorVo.getPhone();
            Long id = operatorVo.getId();

            public Predicate toPredicate(Root<InfoOperator> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> namePath = root.get("name");
                Path<Long> phonePath = root.get("phone");
                Path<Long> idPath = root.get("id");
                List<Predicate> predicates = new ArrayList<Predicate>();

                if (null != name) {
                    predicates.add(cb.equal(namePath, name));
                }
                if (null != phone) {
                    predicates.add(cb.equal(phonePath, phone));
                }
                if (null != id) {
                    predicates.add(cb.equal(idPath, id));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(operatorVo.getPage() - 1, operatorVo.getSize()));
    }

    public List<InfoOperator> findByUsernameAndPhone(InfoOperator infoOperator) {
        return iInfoOperatorDAO.findByUsernameAndPhone(infoOperator.getUsername(),infoOperator.getPhone());
    }

}
