package com.service;

import com.dao.JPAInterface.IInfoUserDAO;
import com.dao.JPAInterface.IInfoUserDAO;
import com.dto.PageTools;
import com.pojo.InfoUser;
import com.pojo.InfoUser;
import com.vo.UserVo;
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
public class UserService {
    @Autowired
    IInfoUserDAO iInfoUserDAO;

    public void regist(InfoUser infoUser) {
        iInfoUserDAO.save(infoUser);
    }

    public List<InfoUser> login(String username, String password) {
        return iInfoUserDAO.login(username, password);
    }


    public void insert(InfoUser infoUser) {
        iInfoUserDAO.save(infoUser);
    }

    public void update(InfoUser infoUser) {
        iInfoUserDAO.save(infoUser);

    }

    public void updateForget(UsernameVo usernameVo) {
        System.out.println("账号：" + usernameVo.getPassword() + "密码：" + usernameVo.getUsername());
        iInfoUserDAO.updateForget(usernameVo.getPassword(), usernameVo.getUsername());

    }

    public void delete(Long id) {
        iInfoUserDAO.deleteById(id);

    }

    public Page<InfoUser> findAll(PageVo pageVo) {
        return iInfoUserDAO.findAll(PageTools.basicPage(pageVo.getPage(), pageVo.getSize()));
    }

    public Page<InfoUser> findByName(UserVo userVo) {
        return iInfoUserDAO.findAll(new Specification<InfoUser>() {

            String nickname = userVo.getNickname();
            String phone = userVo.getPhone();
            Long id = userVo.getId();

            public Predicate toPredicate(Root<InfoUser> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Long> nicknamePath = root.get("nickname");
                Path<Long> phonePath = root.get("phone");
                Path<Long> idPath = root.get("id");
                List<Predicate> predicates = new ArrayList<Predicate>();

                if (null != nickname) {
                    predicates.add(cb.equal(nicknamePath, nickname));
                }
                if (null != phone) {
                    predicates.add(cb.equal(phonePath, phone));
                }
                if (id > 0) {
                    predicates.add(cb.equal(idPath, id));
                }
                query.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }

        }, new PageRequest(userVo.getPage() - 1, userVo.getSize()));
    }

    public List<InfoUser> findByUsernameAndPhone(InfoUser infoUser) {
        return iInfoUserDAO.findByUsernameAndPhone(infoUser.getUsername(),infoUser.getPhone());
    }

}
