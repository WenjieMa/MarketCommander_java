package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItemType;
import com.pojo.InfoOperator;
import com.service.ItemTypeService;
import com.service.OperatorService;
import com.utils.common.CommonUtils;
import com.vo.PageInfo;
import com.vo.UsernameVo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/itemtype")
public class ItemTypeController {
    @Autowired
    private ItemTypeService itemTypeService;

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/insert")
    public JSON insert(@RequestBody InfoItemType infoItemType) {
        try {
            itemTypeService.insert(infoItemType);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/update")
    public JSON update(@RequestBody InfoItemType infoItemType) {
        try {
            itemTypeService.update(infoItemType);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/delete")
    public JSON delete(@RequestBody Long id) {
        try {
            itemTypeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/findAll")
    public JSON findAll(@RequestBody PageInfo pageInfo) {
        try {
            itemTypeService.findAll(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }
}
