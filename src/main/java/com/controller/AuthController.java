package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoOperator;
import com.pojo.InfoUser;
import com.service.OperatorService;
import com.utils.common.CommonUtils;
import com.vo.UsernameVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private OperatorService operatorService;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/operator/login")
    public JSON operatorLogin(@RequestBody UsernameVo usernameVo) {
        InfoOperator infoOperator = null;
        List<InfoOperator> infoOperators = null;
        try {
            infoOperators = operatorService.login(usernameVo.getUsername(), DigestUtils.md5Hex(usernameVo.getPassword().getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (infoOperators.size() > 0) {
            infoOperator = infoOperators.get(0);
            return CommonUtils.toValue(infoOperator, true, "0");
        } else {
            return CommonUtils.toValue(infoOperator, false, "404");
        }
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/operator/regist")
    public JSON operatorRegist(@RequestBody InfoOperator infoOperator) {
        System.out.println("来了");
        try {
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
