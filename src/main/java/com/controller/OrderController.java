package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItemType;
import com.pojo.OrderSmall;
import com.pojo.OrderSum;
import com.service.ItemTypeService;
import com.service.OrderService;
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
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/insert")
    public JSON insert(@RequestBody OrderSumVo orderSumVo) {
        System.out.println(orderSumVo.getUserid() + "这是用户id");
        orderSumVo.setCreatedate(new Timestamp(System.currentTimeMillis()));
        boolean b = false;
        try {
            b = orderService.insert(orderSumVo);
            if (b) {
                return CommonUtils.toValue(null, true, "0");
            } else {
                return CommonUtils.toValue(null, false, "404");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/insertrefund")
    public JSON insertRefund(@RequestBody OrderSumVo orderSumVo) {
        orderSumVo.setType("2");
        orderSumVo.setCreatedate(new Timestamp(System.currentTimeMillis()));
        try {
            orderService.insert(orderSumVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/update")
    public JSON update(@RequestBody OrderSum orderSum) {
        try {
            orderService.update(orderSum);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/updatestate")
    public JSON updateState(@RequestBody OrderSumVo orderSumVo) {
        try {
            orderService.updateState(orderSumVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/senddelivery")
    public JSON sendDelivery(@RequestBody DeliveryVo deliveryVo) {
        OrderSumVo orderSumVo = null;
        try {
            orderService.sendDelivery(deliveryVo);
            orderSumVo = orderService.findOrderSumVoBySumid(deliveryVo.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(orderSumVo, true, "0");
    }


    @ResponseBody
    @RequestMapping(value = "/delete")
    public JSON delete(@RequestBody Long id) {
        try {
            orderService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findordersmallbysumid")
    public JSON findOrderSmallBySumid(@RequestBody Long sumid) {
        List<OrderSmallVo> orderSmallVos = null;
        try {
            orderSmallVos = orderService.findOrderSmallVoBySumid(sumid);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }

        return CommonUtils.toValue(orderSmallVos, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findordersumbyparams")
    public JSON findOrderSumByParams(@RequestBody OrderSumSearchVo orderSumSearchVo) {
        Page<OrderSum> orderSumVoPage = null;
        try {
            orderSumVoPage = orderService.findOrderSumByParams(orderSumSearchVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(orderSumVoPage.getContent(), orderSumVoPage.getTotalPages(), orderSumVoPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findordersumbyuserid")
    public JSON findOrderSumVoByUserid(@RequestBody UserVo userVo) {
        OrderSumPageVo orderSumVoPage = null;
        try {
            orderSumVoPage = orderService.findOrderSumVoByUserid(userVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(orderSumVoPage.getOrderSumVos(), orderSumVoPage.getTotalPages(), orderSumVoPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findordersumbysumid")
    public JSON findOrderSumVoBySumid(@RequestBody UserVo userVo) {
        System.out.println("进来查询了");
        OrderSumVo orderSumVo = null;
        try {
            orderSumVo = orderService.findOrderSumVoBySumid(userVo.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(orderSumVo, true, "0");
    }

}
