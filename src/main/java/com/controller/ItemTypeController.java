package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItemType;
import com.service.ItemTypeService;
import com.utils.common.CommonUtils;
import com.vo.ItemTypeVo;
import org.springframework.beans.factory.NamedBean;
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
    @RequestMapping(value = "/obj", method = RequestMethod.POST)
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
    @RequestMapping(value = "/obj", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/obj", method = RequestMethod.DELETE)
    public JSON delete(@RequestParam Long id) {
        try {
            itemTypeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/obj", method = RequestMethod.GET)
    public JSON findAll(@RequestParam int page, @RequestParam int size) {
        Page<InfoItemType> infoItemTypePage = null;
        ItemTypeVo itemTypeVo=new ItemTypeVo();
        itemTypeVo.setPage(page);
        itemTypeVo.setSize(size);
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
    @RequestMapping(value = "/obj/allbyname", method = RequestMethod.GET)
    public JSON findByName(@RequestParam int page, @RequestParam int size,@RequestParam String typename) {
        Page<InfoItemType> infoItemTypePage = null;
        ItemTypeVo itemTypeVo=new ItemTypeVo();
        itemTypeVo.setPage(page);
        itemTypeVo.setSize(size);
        itemTypeVo.setTypename(typename);
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
