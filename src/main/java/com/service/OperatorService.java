package com.service;

import com.dao.IInfoOperatorDAO;
import com.pojo.InfoOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

}
