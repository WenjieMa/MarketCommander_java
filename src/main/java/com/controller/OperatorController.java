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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/operator")
public class OperatorController {
    @Autowired
    private OperatorService operatorService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
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
    @RequestMapping(method = RequestMethod.PUT)
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
    @RequestMapping(value = "/updateforget", method = RequestMethod.PUT)
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
    @RequestMapping(method = RequestMethod.DELETE)
    public JSON delete(@RequestParam Long id) {
        try {
            operatorService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JSON findAll(@RequestParam int page, @RequestParam int size) {
        PageVo pageVo = new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
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
    @RequestMapping(value = "/findbyname", method = RequestMethod.GET)
    public JSON findByName(@RequestParam String name, @RequestParam String phone, @RequestParam Long id, @RequestParam int page, @RequestParam int size) {
        OperatorVo operatorVo = new OperatorVo();
        operatorVo.setId(id);
        operatorVo.setName(name);
        operatorVo.setPage(page);
        operatorVo.setSize(size);
        operatorVo.setPhone(phone);
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
    @RequestMapping(value = "/findbyusernameandphone", method = RequestMethod.GET)
    public JSON findByUsernameAndPhone(@RequestParam String username, @RequestParam String phone) {
        List<InfoOperator> infoOperators = null;
        InfoOperator infoOperatorUsed = null;
        InfoOperator vo = new InfoOperator();
        vo.setUsername(username);
        vo.setPhone(phone);
        try {
            infoOperators = operatorService.findByUsernameAndPhone(vo);
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
