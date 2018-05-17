package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoOperator;
import com.pojo.InfoRole;
import com.pojo.InfoUser;
import com.pojo.RecordAssistant2role;
import com.service.OperatorService;
import com.service.RoleService;
import com.utils.common.CommonUtils;
import com.vo.OperatorLoginVo;
import com.vo.UsernameVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private OperatorService operatorService;

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/operator/login")
    public JSON operatorLogin(@RequestBody UsernameVo usernameVo) {
        InfoOperator infoOperator = null;
        List<InfoOperator> infoOperators = null;
        OperatorLoginVo operatorLoginVo = new OperatorLoginVo();
        InfoRole infoRole = null;
        List<InfoRole> infoRoles = null;
        try {
            infoOperators = operatorService.login(usernameVo.getUsername(), DigestUtils.md5Hex(usernameVo.getPassword().getBytes("UTF-8")));
            if (infoOperators.size() > 0) {
                infoRoles = roleService.findRole2Operator(infoOperators.get(0));
                infoOperator = infoOperators.get(0);
                operatorLoginVo.setInfoOperator(infoOperator);
                operatorLoginVo.setInfoRoles(infoRoles);
                return CommonUtils.toValue(operatorLoginVo, true, "0");
            } else {
                return CommonUtils.toValue(null, false, "404");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return CommonUtils.toValue(null, false, "404");
    }

    @ResponseBody
    @RequestMapping(value = "/operator/regist")
    public JSON operatorRegist(@RequestBody InfoOperator infoOperator) {
        System.out.println("来了");
        try {
            infoOperator.setCreatedate(new Timestamp(System.currentTimeMillis()));

            infoOperator.setPassword(DigestUtils.md5Hex(infoOperator.getPassword().getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            operatorService.regist(infoOperator);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

}
