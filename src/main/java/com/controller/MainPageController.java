package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.*;
import com.pojo.HomeHotsearch;
import com.service.AnounceService;
import com.service.HomeHotSearchService;
import com.service.ItemService;
import com.service.StartService;
import com.utils.common.CommonUtils;
import com.vo.*;
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
@RequestMapping(value = "/mainpage")
public class MainPageController {
    @Autowired
    private HomeHotSearchService homeHotSearchService;

    @Autowired
    private StartService startService;

    @Autowired
    private AnounceService anounceService;

    @ResponseBody
    @RequestMapping(value = "/hotsearch/insert")
    public JSON insert(@RequestBody HomeHotsearch homeHotsearch) {
        homeHotsearch.setCreatedate(new Timestamp(System.currentTimeMillis()));
        homeHotsearch.setIseffective(true);
        try {
            homeHotSearchService.insert(homeHotsearch);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/hotsearch/update")
    public JSON update(@RequestBody HomeHotsearch HomeHotsearch) {
        try {
            homeHotSearchService.update(HomeHotsearch);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/hotsearch/delete")
    public JSON delete(@RequestBody DeleteVo id) {
        try {
            homeHotSearchService.delete(Long.parseLong(id.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/hotsearch/findall")
    public JSON findAll(@RequestBody PageVo pageVo) {
        Page<HomeHotsearch> HomeHotsearchPage = null;
        try {
            HomeHotsearchPage = homeHotSearchService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(HomeHotsearchPage.getContent(), HomeHotsearchPage.getTotalPages(), HomeHotsearchPage.getTotalElements(), true, "0");
    }
    @ResponseBody
    @RequestMapping(value = "/hotsearch/changeeff")
    public JSON changeEff(@RequestBody HomeHotsearch homeHotsearch) {
        try {
            homeHotsearch.setIseffective(!homeHotsearch.getIseffective());
            homeHotSearchService.update(homeHotsearch);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/1/insert")
    public JSON insertStart(@RequestBody HomeColumnsLevel1 homeColumnsLevel1) {
        homeColumnsLevel1.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            startService.insert(homeColumnsLevel1);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/1/update")
    public JSON updateStart(@RequestBody HomeColumnsLevel1 homeColumnsLevel1) {
        try {
            startService.update(homeColumnsLevel1);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/1/delete")
    public JSON deleteStart(@RequestBody DeleteVo id) {
        try {
            startService.delete(Long.parseLong(id.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/1/findall")
    public JSON findAllStart(@RequestBody PageVo pageVo) {
        Page<HomeColumnsLevel1> homeColumnsLevel1s = null;
        try {
            homeColumnsLevel1s = startService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(homeColumnsLevel1s.getContent(), homeColumnsLevel1s.getTotalPages(), homeColumnsLevel1s.getTotalElements(), true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/start/findallabove")
    public JSON findAllAbove() {
        List<ColumnObjVo> columnObjVos = null;
        try {
            columnObjVos = startService.findAllAbove();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(columnObjVos, true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/start/2/insert")
    public JSON insertStart2(@RequestBody HomeColumnsLevel2 homeColumnsLevel2) {
        homeColumnsLevel2.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            startService.insert2(homeColumnsLevel2);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/2/update")
    public JSON updateStart2(@RequestBody HomeColumnsLevel2 homeColumnsLevel2) {
        try {
            startService.update2(homeColumnsLevel2);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/2/delete")
    public JSON deleteStart2(@RequestBody DeleteVo id) {
        try {
            startService.delete2(Long.parseLong(id.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/2/findall")
    public JSON findAllStart2(@RequestBody ColumnVo columnVo) {
        Page<HomeColumnsLevel2> homeColumnsLevel2s = null;
        try {
            homeColumnsLevel2s = startService.findAll2(columnVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(homeColumnsLevel2s.getContent(), homeColumnsLevel2s.getTotalPages(), homeColumnsLevel2s.getTotalElements(), true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/anounce/insert")
    public JSON insertAnounce(@RequestBody HomeAnnouncement homeAnnouncement) {
        homeAnnouncement.setCreatedate(new Timestamp(System.currentTimeMillis()));
        homeAnnouncement.setIseffective(true);
        try {
            anounceService.insert(homeAnnouncement);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/anounce/update")
    public JSON updateAnounce(@RequestBody HomeAnnouncement homeAnnouncement) {
        try {
            anounceService.update(homeAnnouncement);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/anounce/delete")
    public JSON deleteAnounce(@RequestBody DeleteVo id) {
        try {
            anounceService.delete(Long.parseLong(id.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/anounce/findall")
    public JSON findAllAnounce(@RequestBody PageVo pageVo) {
        Page<HomeAnnouncement> homeAnnouncements = null;
        try {
            homeAnnouncements = anounceService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(homeAnnouncements.getContent(), homeAnnouncements.getTotalPages(), homeAnnouncements.getTotalElements(), true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/image/insert")
    public JSON insertImage(@RequestBody HomeStartimages homeStartimages) {
        homeStartimages.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            startService.insertImage(homeStartimages);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/image/update")
    public JSON updateImage(@RequestBody HomeStartimages homeStartimages) {
        try {
            startService.updateImage(homeStartimages);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/image/delete")
    public JSON deleteImage(@RequestBody DeleteVo id) {
        try {
            startService.deleteImage(Long.parseLong(id.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/image/findall")
    public JSON findAllImage(@RequestBody PageVo pageVo) {
        Page<HomeStartimages> homeStartimages = null;
        try {
            homeStartimages = startService.findAllImage(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(homeStartimages.getContent(), homeStartimages.getTotalPages(), homeStartimages.getTotalElements(), true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/anounce/changeeff")
    public JSON changeEffAnounce(@RequestBody HomeAnnouncement homeAnnouncement) {
        try {
            homeAnnouncement.setIseffective(!homeAnnouncement.getIseffective());
            anounceService.update(homeAnnouncement);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

}
