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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
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
    @RequestMapping(method = RequestMethod.PUT)
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
    @RequestMapping(value = "/updateforget", method = RequestMethod.PUT)
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
    @RequestMapping(method = RequestMethod.DELETE)
    public JSON delete(@RequestParam Long id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JSON findAll(@RequestParam int page, @RequestParam int size) {
        PageVo pageVo = new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
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
    @RequestMapping(value = "/findbyname", method = RequestMethod.GET)
    public JSON findByName(@RequestParam String nickname, @RequestParam String phone, @RequestParam Long id, @RequestParam int page, @RequestParam int size) {
        UserVo userVo = new UserVo();
        userVo.setSize(size);
        userVo.setPage(page);
        userVo.setId(id);
        userVo.setNickname(nickname);
        userVo.setPhone(phone);
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
    @RequestMapping(value = "/findbyusernameandphone", method = RequestMethod.GET)
    public JSON findByUsernameAndPhone(@RequestParam String username, @RequestParam String phone) {
        InfoUser infoUser = new InfoUser();
        infoUser.setUsername(username);
        infoUser.setPhone(phone);
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
