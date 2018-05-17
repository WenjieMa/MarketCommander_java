package com.controller;

import com.alibaba.fastjson.JSON;
import com.dao.JPAInterface.IInfoOperatorDAO;
import com.pojo.InfoOperator;
import com.service.ItemTypeService;
import com.service.OperatorService;
import com.utils.common.CommonUtils;
import com.vo.ItemTypeVo;
import com.vo.OperatorVo;
import com.vo.PageVo;
import com.vo.UsernameVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/operator")
public class OperatorController {
    @Autowired
    private OperatorService operatorService;

    @ResponseBody
    @RequestMapping(value = "/insert")
    public JSON insert(@RequestBody InfoOperator infoOperator) {
        infoOperator.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            operatorService.insert(infoOperator);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public JSON update(@RequestBody InfoOperator infoOperator) {
        try {
            operatorService.update(infoOperator);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/updateforget")
    public JSON updateForget(@RequestBody UsernameVo usernameVo) {
        try {
            usernameVo.setPassword(DigestUtils.md5Hex(usernameVo.getPassword().getBytes("UTF-8")));
            operatorService.updateForget(usernameVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public JSON delete(@RequestBody Long id) {
        try {
            operatorService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findall")
    public JSON findAll(@RequestBody PageVo pageVo) {
        Page<InfoOperator> infoOperatorPage = null;
        try {
            infoOperatorPage = operatorService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoOperatorPage.getContent(), infoOperatorPage.getTotalPages(), infoOperatorPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findbyname")
    public JSON findByName(@RequestBody OperatorVo operatorVo) {
        Page<InfoOperator> infoOperatorPage = null;
        try {
            infoOperatorPage = operatorService.findByName(operatorVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoOperatorPage.getContent(), infoOperatorPage.getTotalPages(), infoOperatorPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findbyusernameandphone")
    public JSON findByUsernameAndPhone(@RequestBody InfoOperator infoOperator) {
        List<InfoOperator> infoOperators = null;
        InfoOperator infoOperatorUsed = null;
        try {
            infoOperators = operatorService.findByUsernameAndPhone(infoOperator);
            if (infoOperators.size() > 0) {
                infoOperatorUsed = infoOperators.get(0);
                return CommonUtils.toValue(null, true, "0");
            } else {
                return CommonUtils.toValue(null, false, "404");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
    }
}
