package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItemType;
import com.service.ItemTypeService;
import com.utils.common.CommonUtils;
import com.vo.ItemTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/itemtype")
public class ItemTypeController {
    @Autowired
    private ItemTypeService itemTypeService;

    @ResponseBody
    @RequestMapping(value = "/insert")
    public JSON insert(@RequestBody InfoItemType infoItemType) {
        infoItemType.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            itemTypeService.insert(infoItemType);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
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
    @RequestMapping(value = "/findall")
    public JSON findAll(@RequestBody ItemTypeVo itemTypeVo) {
        Page<InfoItemType> infoItemTypePage = null;
        try {
            infoItemTypePage = itemTypeService.findAll(itemTypeVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }

        for (InfoItemType infoItemType : infoItemTypePage.getContent()
                ) {
            System.out.println(infoItemType.getTypename());
        }
        return CommonUtils.toValue(infoItemTypePage.getContent(), infoItemTypePage.getTotalPages(), infoItemTypePage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findbyname")
    public JSON findByName(@RequestBody ItemTypeVo itemTypeVo) {
        Page<InfoItemType> infoItemTypePage = null;
        try {
            infoItemTypePage = itemTypeService.findByName(itemTypeVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }

        for (InfoItemType infoItemType : infoItemTypePage.getContent()
                ) {
            System.out.println(infoItemType.getTypename());
        }
        return CommonUtils.toValue(infoItemTypePage.getContent(), infoItemTypePage.getTotalPages(), infoItemTypePage.getTotalElements(), true, "0");
    }
}
