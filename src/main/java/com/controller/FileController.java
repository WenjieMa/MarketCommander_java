package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItem;
import com.pojo.InfoUser;
import com.service.ItemService;
import com.service.OperatorService;
import com.service.UserService;
import com.utils.common.CommonUtils;
import com.utils.common.ImageUtil;
import com.utils.config.SystemInfo;
import com.vo.ImageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@CrossOrigin
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @Value("${img.location}")
    private String location;

    @ResponseBody
    @RequestMapping("/headpic")
    public JSON uploadHeadpic(@RequestParam("file") MultipartFile multipartFile, @RequestParam("userid") Long userid) throws IOException {
        System.out.println("进来了");
        String contentType = multipartFile.getContentType();
        String root_fileName = multipartFile.getOriginalFilename();
        System.out.println("上传图片:name=" + root_fileName + ",type=" + contentType);

        InfoUser infoUser = userService.findById(userid);
        //获取路径
        String return_path = ImageUtil.getFilePath(infoUser);
        String filePath = location + return_path;
        System.out.println("图片保存路径=" + filePath);
        String file_name = null;
        file_name = ImageUtil.saveImg(multipartFile, filePath);
        ImageVo imageVo = new ImageVo();
        imageVo.setSuccess(true);
        imageVo.setUrl(SystemInfo.staticLocation + return_path + File.separator + file_name);

        if (StringUtils.isNotBlank(file_name)) {
            return CommonUtils.toValue(imageVo, true, "0");
        } else {
            return CommonUtils.toValue(null, false, "404");
        }
    }

    @ResponseBody
    @RequestMapping("/itempic")
    public JSON uploadItemPic(@RequestParam("file") MultipartFile multipartFile, @RequestParam("itemid") Long itemid) throws IOException {
        System.out.println("进来了");
        String contentType = multipartFile.getContentType();
        String root_fileName = multipartFile.getOriginalFilename();
        System.out.println("上传图片:name=" + root_fileName + ",type=" + contentType);

        InfoItem infoItem = itemService.findById(itemid);
        //获取路径
        String return_path = ImageUtil.getFilePath(infoItem);
        String filePath = location + return_path;
        System.out.println("图片保存路径=" + filePath);
        String file_name = null;
        file_name = ImageUtil.saveImg(multipartFile, filePath);
        ImageVo imageVo = new ImageVo();
        imageVo.setSuccess(true);
        imageVo.setUrl(SystemInfo.staticLocation + return_path + File.separator + file_name);

        if (StringUtils.isNotBlank(file_name)) {
            return CommonUtils.toValue(imageVo, true, "0");
        } else {
            return CommonUtils.toValue(null, false, "404");
        }
    }

    @ResponseBody
    @RequestMapping("/homepic")
    public JSON uploadHomePic(@RequestParam("file") MultipartFile multipartFile, @RequestParam("picid") Long picid) throws IOException {
        System.out.println("进来了");
        String contentType = multipartFile.getContentType();
        String root_fileName = multipartFile.getOriginalFilename();
        System.out.println("上传图片:name=" + root_fileName + ",type=" + contentType);

        String return_path = ImageUtil.getFilePath(picid);
        String filePath = location + return_path;
        System.out.println("图片保存路径=" + filePath);
        String file_name = null;
        file_name = ImageUtil.saveImg(multipartFile, filePath);
        ImageVo imageVo = new ImageVo();
        imageVo.setSuccess(true);
        imageVo.setUrl(SystemInfo.staticLocation + return_path + File.separator + file_name);

        if (StringUtils.isNotBlank(file_name)) {
            return CommonUtils.toValue(imageVo, true, "0");
        } else {
            return CommonUtils.toValue(null, false, "404");
        }
    }
}