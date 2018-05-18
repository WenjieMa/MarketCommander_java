package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.RecordCollection;
import com.pojo.RecordCollection;
import com.service.CollectionService;
import com.service.ItemTypeService;
import com.utils.common.CommonUtils;
import com.vo.ItemTypeVo;
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
@RequestMapping(value = "/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    @ResponseBody
    @RequestMapping(value = "/insert")
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
    @RequestMapping(value = "/update")
    public JSON update(@RequestBody RecordCollection recordCollection) {
        try {
            collectionService.update(recordCollection);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    public JSON delete(@RequestBody RecordCollection recordCollection) {
        List<RecordCollection> recordCollections = null;
        try {
            collectionService.delete(recordCollection.getUserid(),recordCollection.getItemid());
            recordCollections = collectionService.findAll(recordCollection.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(recordCollections, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findall")
    public JSON findAll(@RequestBody RecordCollection recordCollection) {
        List<RecordCollection> recordCollectionPage = null;
        try {
            recordCollectionPage = collectionService.findAll(recordCollection.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(recordCollectionPage, true, "0");
    }

}
