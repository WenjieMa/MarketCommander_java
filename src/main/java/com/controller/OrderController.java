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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
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
    @RequestMapping(value = "/insertrefund",method = RequestMethod.POST)
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
    @RequestMapping(method = RequestMethod.PUT)
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
    @RequestMapping(value = "/updatestate",method = RequestMethod.PUT)
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
    @RequestMapping(value = "/senddelivery",method = RequestMethod.PUT)
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
    @RequestMapping(method = RequestMethod.DELETE)
    public JSON delete(@RequestParam Long id) {
        try {
            orderService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findordersmallbysumid",method = RequestMethod.GET)
    public JSON findOrderSmallBySumid(@RequestParam Long sumid) {
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
    @RequestMapping(value = "/findordersumbyparams",method = RequestMethod.POST)
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
    @RequestMapping(value = "/findordersumbyuserid",method = RequestMethod.GET)
    public JSON findOrderSumVoByUserid(@RequestParam Long id,@RequestParam int page,@RequestParam int size) {
        OrderSumPageVo orderSumVoPage = null;
        UserVo userVo=new UserVo();
        userVo.setId(id);
        userVo.setPage(page);
        userVo.setSize(size);
        try {
            orderSumVoPage = orderService.findOrderSumVoByUserid(userVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(orderSumVoPage.getOrderSumVos(), orderSumVoPage.getTotalPages(), orderSumVoPage.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/findordersumbysumid",method = RequestMethod.GET)
    public JSON findOrderSumVoBySumid(@RequestParam Long id) {
        System.out.println("进来查询了");
        OrderSumVo orderSumVo = null;
        try {
            orderSumVo = orderService.findOrderSumVoBySumid(id);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(orderSumVo, true, "0");
    }

}
