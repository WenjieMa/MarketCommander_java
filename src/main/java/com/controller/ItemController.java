package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItem;
import com.pojo.RecordImport;
import com.service.ItemService;
import com.utils.common.CommonUtils;
import com.vo.ImportVo;
import com.vo.ImportingVo;
import com.vo.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
@CrossOrigin
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @ResponseBody
    @RequestMapping(value = "/insert")
    public JSON insert(@RequestBody InfoItem infoItem) {
        infoItem.setCreatedate(new Timestamp(System.currentTimeMillis()));
        infoItem.setIseffective(true);
        infoItem.setStore(0l);
        try {
            itemService.insert(infoItem);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public JSON update(@RequestBody InfoItem infoItem) {
        try {
            itemService.update(infoItem);
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
            itemService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findall")
    public JSON findAll(@RequestBody ItemVo itemVo) {
        System.out.println(1);
        Page<InfoItem> infoItemPage = null;
        try {
            infoItemPage = itemService.findAll(itemVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoItemPage.getContent(), infoItemPage.getTotalPages(), infoItemPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findbyname")
    public JSON findByName(@RequestBody ItemVo itemVo) {
        Page<InfoItem> infoItemPage = null;
        try {
            infoItemPage = itemService.findByName(itemVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoItemPage.getContent(), infoItemPage.getTotalPages(), infoItemPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/import/findall")
    public JSON findAllImport(@RequestBody ImportVo importVo) {
        Page<RecordImport> recordImportPage = null;
        try {
            recordImportPage = itemService.findAllImport(importVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(recordImportPage.getContent(), recordImportPage.getTotalPages(), recordImportPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/import/findbyname")
    public JSON findImportByName(@RequestBody ImportVo importVo) {
        System.out.println("进来了"+importVo.getStart());
        Page<RecordImport> recordImportPage = null;
        try {
            recordImportPage = itemService.findImportByName(importVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(recordImportPage.getContent(), recordImportPage.getTotalPages(), recordImportPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/changeeff")
    public JSON changeEff(@RequestBody InfoItem itemVo) {
        try {
            itemVo.setIseffective(!itemVo.getIseffective());
            itemService.update(itemVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/import")
    public JSON importItem(@RequestBody ImportingVo importingVo) {
        importingVo.getRecordImport().setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            itemService.importGoods(importingVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }


}
