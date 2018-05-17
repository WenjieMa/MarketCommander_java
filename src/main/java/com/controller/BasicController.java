package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoOperator;
import com.pojo.InfoUser;
import com.service.OperatorService;
import com.utils.common.CommonUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@Controller
@CrossOrigin
@RequestMapping(value = "/")
public class BasicController {
    @Autowired
    private OperatorService operatorService;

    @ResponseBody
    @RequestMapping(value = "/")
    public JSON initMethod() {
        return CommonUtils.toValue(null, true, "0");
    }


}
