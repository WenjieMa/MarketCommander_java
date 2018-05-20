package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItemType;
import com.service.CommentService;
import com.service.ItemTypeService;
import com.utils.common.CommonUtils;
import com.vo.CommentVo;
import com.vo.ItemCommentVo;
import com.vo.ItemTypeVo;
import com.vo.OrderSumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

@Controller
@CrossOrigin
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/insert")
    public JSON insert(@RequestBody OrderSumVo orderSumVo) {
        try {
            commentService.insert(orderSumVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/finditemcommentsum")
    public JSON findItemCommentSum(@RequestBody CommentVo commentVo) {
        ItemCommentVo itemCommentVo=new ItemCommentVo();
        try {
            itemCommentVo= commentService.findItemCommentSum(commentVo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(itemCommentVo.getCommentSumVos(),itemCommentVo.getTotalPages(),itemCommentVo.getTotalElements(), true, "0");
    }


}
