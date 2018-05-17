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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/insert")
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
    @RequestMapping(value = "/update")
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
    @RequestMapping(value = "/delete")
    public JSON delete(@RequestBody Long id) {
        try {
            roleService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findall")
    public JSON findAll(@RequestBody PageVo pageVo) {
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
    @RequestMapping(value = "/role2assistant/insert")
    public JSON insertRole2Assistant(@RequestBody RecordAssistant2role recordAssistant2role) {
        recordAssistant2role.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            roleService.insertRole2Assistant(recordAssistant2role);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant/update")
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
    @RequestMapping(value = "/role2assistant/delete")
    public JSON deleteRole2Assistant(@RequestBody RecordAssistant2role recordAssistant2role) {
        try {
            roleService.deleteRole2Assistant(recordAssistant2role);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant/findall")
    public JSON findAllRole2Assistant(@RequestBody RoleVo roleVo) {
        System.out.println(1);
        Page<InfoOperator> infoOperators = null;
        try {
            infoOperators = roleService.findAllRole2Assistant(roleVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoOperators.getContent(), infoOperators.getTotalPages(), infoOperators.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/role2assistant/findallnone")
    public JSON findAllRole2AssistantNone(@RequestBody RoleVo roleVo) {
        System.out.println(1);
        Page<InfoOperator> infoOperators = null;
        try {
            infoOperators = roleService.findAllRole2AssistantNone(roleVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(infoOperators.getContent(), infoOperators.getTotalPages(), infoOperators.getTotalElements(), true, "0");
    }

}
