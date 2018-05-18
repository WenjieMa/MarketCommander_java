package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoUser;
import com.pojo.InfoUser;
import com.service.UserService;
import com.utils.common.CommonUtils;
import com.vo.UserVo;
import com.vo.PageVo;
import com.vo.UsernameVo;
import org.apache.commons.codec.digest.DigestUtils;
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
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/insert")
    public JSON insert(@RequestBody InfoUser infoUser) {
        infoUser.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            userService.insert(infoUser);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public JSON update(@RequestBody InfoUser infoUser) {
        try {
            userService.update(infoUser);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/updateforget")
    public JSON updateForget(@RequestBody UsernameVo usernameVo) {
        try {
            usernameVo.setPassword(DigestUtils.md5Hex(usernameVo.getPassword().getBytes("UTF-8")));
            userService.updateForget(usernameVo);
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
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findall")
    public JSON findAll(@RequestBody PageVo pageVo) {
        Page<InfoUser> infoUserPage = null;
        try {
            infoUserPage = userService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoUserPage.getContent(), infoUserPage.getTotalPages(), infoUserPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findbyname")
    public JSON findByName(@RequestBody UserVo userVo) {
        Page<InfoUser> infoUserPage = null;
        try {
            infoUserPage = userService.findByName(userVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoUserPage.getContent(), infoUserPage.getTotalPages(), infoUserPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findbyusernameandphone")
    public JSON findByUsernameAndPhone(@RequestBody InfoUser infoUser) {
        List<InfoUser> infoUsers = null;
        InfoUser infoUserUsed = null;
        try {
            infoUsers = userService.findByUsernameAndPhone(infoUser);
            if (infoUsers.size() > 0) {
                infoUserUsed = infoUsers.get(0);
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
