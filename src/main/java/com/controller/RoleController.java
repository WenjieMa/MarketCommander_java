package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoOperator;
import com.pojo.InfoRole;
import com.pojo.RecordAssistant2role;
import com.pojo.RecordImport;
import com.service.ItemService;
import com.service.RoleService;
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
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public JSON insert(@RequestBody InfoRole infoRole) {
        infoRole.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            roleService.insert(infoRole);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public JSON update(@RequestBody InfoRole infoRole) {
        try {
            roleService.update(infoRole);
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
            roleService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public JSON findAll(@RequestParam int page, @RequestParam int size) {
        PageVo pageVo=new PageVo();
        pageVo.setPage(page);
        pageVo.setSize(size);
        System.out.println(1);
        Page<InfoRole> infoRoles = null;
        try {
            infoRoles = roleService.findAll(pageVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoRoles.getContent(), infoRoles.getTotalPages(), infoRoles.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant",method = RequestMethod.POST)
    public JSON insertRole2Assistant(@RequestBody RecordAssistant2role recordAssistant2role) {
        recordAssistant2role.setCreatedate(new Timestamp(System.currentTimeMillis()));
        System.out.println("现在的roleid是" + recordAssistant2role.getRoleid() + "人员Id是" + recordAssistant2role.getAssistantid());
        try {
            roleService.insertRole2Assistant(recordAssistant2role);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant",method = RequestMethod.PUT)
    public JSON updateRole2Assistant(@RequestBody RecordAssistant2role recordAssistant2role) {
        try {
            roleService.updateRole2Assistant(recordAssistant2role);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant",method = RequestMethod.DELETE)
    public JSON deleteRole2Assistant(@RequestParam Long assistantid,@RequestParam Long roleid ) {
        RecordAssistant2role recordAssistant2role=new RecordAssistant2role();
        recordAssistant2role.setAssistantid(assistantid);
        recordAssistant2role.setRoleid(roleid);
        try {
            roleService.deleteRole2Assistant(recordAssistant2role);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant",method = RequestMethod.GET)
    public JSON findAllRole2Assistant(@RequestParam Long roleid,@RequestParam int page, @RequestParam int size ) {
        RoleVo roleVo=new RoleVo();
        roleVo.setPage(page);
        roleVo.setSize(size);
        roleVo.setRoleid(roleid);
        Page<InfoOperator> infoOperators = null;
        try {
            infoOperators = roleService.findAllRole2AssistantIn(roleVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoOperators.getContent(), infoOperators.getTotalPages(), infoOperators.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant/findallnone",method = RequestMethod.GET)
    public JSON findAllRole2AssistantNone(@RequestParam Long roleid,@RequestParam int page, @RequestParam int size ) {
        RoleVo roleVo=new RoleVo();
        roleVo.setPage(page);
        roleVo.setSize(size);
        roleVo.setRoleid(roleid);
        System.out.println("id为" + roleVo.getRoleid() + "的权限下没有的人的查询");
        Page<InfoOperator> infoOperators = null;
        try {
            infoOperators = roleService.findAllRole2AssistantNone(roleVo);
            System.out.println("共有" + infoOperators.getContent().size() + "的人");
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoOperators.getContent(), infoOperators.getTotalPages(), infoOperators.getTotalElements(), true, "0");
    }

}
