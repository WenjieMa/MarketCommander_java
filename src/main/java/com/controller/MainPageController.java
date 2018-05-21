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
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/hotsearch", method = RequestMethod.POST)
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
    @RequestMapping(value = "/hotsearch", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/hotsearch", method = RequestMethod.DELETE)
    public JSON delete(@RequestParam Long id) {
        try {
            homeHotSearchService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/hotsearch", method = RequestMethod.GET)
    public JSON findAll(@RequestParam int page, @RequestParam int size) {
        Page<HomeHotsearch> HomeHotsearchPage = null;
        PageVo pageVo=new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
        try {
            HomeHotsearchPage = homeHotSearchService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(HomeHotsearchPage.getContent(), HomeHotsearchPage.getTotalPages(), HomeHotsearchPage.getTotalElements(), true, "0");
    }
    @ResponseBody
    @RequestMapping(value = "/hotsearch/eff", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/start/1", method = RequestMethod.POST)
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
    @RequestMapping(value = "/start/1", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/start/1", method = RequestMethod.DELETE)
    public JSON deleteStart(@RequestParam Long id) {
        try {
            startService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/1", method = RequestMethod.GET)
    public JSON findAllStart(@RequestParam int page, @RequestParam int size) {
        Page<HomeColumnsLevel1> homeColumnsLevel1s = null;
        PageVo pageVo=new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
        try {
            homeColumnsLevel1s = startService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(homeColumnsLevel1s.getContent(), homeColumnsLevel1s.getTotalPages(), homeColumnsLevel1s.getTotalElements(), true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/start/all", method = RequestMethod.GET)
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
    @RequestMapping(value = "/start/2", method = RequestMethod.POST)
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
    @RequestMapping(value = "/start/2", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/start/2", method = RequestMethod.DELETE)
    public JSON deleteStart2(@RequestParam Long id) {
        try {
            startService.delete2(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/start/2", method = RequestMethod.GET)
    public JSON findAllStart2(@RequestParam int parentid,@RequestParam int page, @RequestParam int size) {
        ColumnVo columnVo=new ColumnVo();
        columnVo.setPage(page);
        columnVo.setSize(size);
        columnVo.setParentid(parentid);
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
    @RequestMapping(value = "/anounce", method = RequestMethod.POST)
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
    @RequestMapping(value = "/anounce", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/anounce", method = RequestMethod.DELETE)
    public JSON deleteAnounce(@RequestParam Long id) {
        try {
            anounceService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/anounce", method = RequestMethod.GET)
    public JSON findAllAnounce(@RequestParam int page, @RequestParam int size) {
        PageVo pageVo=new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
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
    @RequestMapping(value = "/image", method = RequestMethod.POST)
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
    @RequestMapping(value = "/image", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/image", method = RequestMethod.DELETE)
    public JSON deleteImage(@RequestParam Long id) {
        try {
            startService.deleteImage(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public JSON findAllImage(@RequestParam int page, @RequestParam int size) {
        PageVo pageVo=new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
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
    @RequestMapping(value = "/anounce/eff", method = RequestMethod.PUT)
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
