package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItem;
import com.pojo.RecordCollection;
import com.pojo.RecordCollection;
import com.service.CollectionService;
import com.service.ItemTypeService;
import com.utils.common.CommonUtils;
import com.vo.CollectionVo;
import com.vo.ItemTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @ResponseBody
    @RequestMapping(value = "/obj", method = RequestMethod.POST)
    public JSON insert(@RequestBody RecordCollection recordCollection) {
        recordCollection.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            collectionService.insert(recordCollection);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/obj/findbyuseridanditemid", method = RequestMethod.GET)
    public JSON find(@RequestParam Long itemid, @RequestParam Long userid) {
        RecordCollection record = null;
        try {
            record = collectionService.findByUserIdAndItemId(itemid, userid);
            if (record == null) {
                return CommonUtils.toValue(null, true, "0");
            } else {
                return CommonUtils.toValue(record, true, "0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }

    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public JSON delete(@RequestBody CollectionVo collectionVo) {
        Page<InfoItem> infoItemPage = null;
        try {
            collectionService.delete(collectionVo.getRecordCollection().getUserid(), collectionVo.getRecordCollection().getItemid());
            infoItemPage = collectionService.findAll(collectionVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoItemPage.getContent(), infoItemPage.getTotalPages(), infoItemPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/obj", method = RequestMethod.DELETE)
    public JSON delete(@RequestParam Long itemid, @RequestParam Long userid) {
        System.out.println("进来了");
        try {
            collectionService.delete(userid, itemid);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/obj", method = RequestMethod.GET)
    public JSON findAll(@RequestParam int page, @RequestParam int size, @RequestParam Long userid) {
        Page<InfoItem> infoItemPage = null;
        try {
            infoItemPage = collectionService.findAll(userid, page, size);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoItemPage.getContent(), infoItemPage.getTotalPages(), infoItemPage.getTotalElements(), true, "0");
    }

}
