package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoOperator;
import com.pojo.InfoRole;
import com.pojo.InfoUser;
import com.pojo.RecordAssistant2role;
import com.service.OperatorService;
import com.service.RoleService;
import com.service.UserService;
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
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/operator/basic", method = RequestMethod.GET)
    public JSON operatorLogin(@RequestParam String username, @RequestParam String password) {
        System.out.println(username);
        InfoOperator infoOperator = null;
        List<InfoOperator> infoOperators = null;
        OperatorLoginVo operatorLoginVo = new OperatorLoginVo();
        InfoRole infoRole = null;
        List<InfoRole> infoRoles = null;
        try {
            infoOperators = operatorService.login(username, DigestUtils.md5Hex(password.getBytes("UTF-8")));
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
    @RequestMapping(value = "/operator/basic", method = RequestMethod.POST)
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

    @ResponseBody
    @RequestMapping(value = "/user/basic", method = RequestMethod.GET)
    public JSON userLogin(@RequestParam String username, @RequestParam String password) {
        InfoUser infoUser = null;
        List<InfoUser> infoUsers = null;
        try {
            infoUsers = userService.login(username, DigestUtils.md5Hex(password.getBytes("UTF-8")));
            if (infoUsers.size() > 0) {
                infoUser = infoUsers.get(0);
                return CommonUtils.toValue(infoUser, true, "0");
            } else {
                return CommonUtils.toValue(null, false, "404");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return CommonUtils.toValue(null, false, "404");
    }

    @ResponseBody
    @RequestMapping(value = "/user/basic", method = RequestMethod.POST)
    public JSON userRegist(@RequestBody InfoUser infoUser) {
        System.out.println("来了");
        try {
            infoUser.setCreatedate(new Timestamp(System.currentTimeMillis()));
            infoUser.setPassword(DigestUtils.md5Hex(infoUser.getPassword().getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            userService.regist(infoUser);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

}
