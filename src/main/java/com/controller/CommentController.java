package com.controller;

import com.alibaba.fastjson.JSON;
import com.pojo.InfoItemType;
import com.service.CommentService;
import com.service.ItemTypeService;
import com.utils.common.CommonUtils;
import com.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@Controller
@CrossOrigin
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/obj", method = RequestMethod.POST)
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
    @RequestMapping(value = "/obj/reply", method = RequestMethod.POST)
    public JSON reply(@RequestBody WholeComment wholeComment) {
        try {
            commentService.reply(wholeComment);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(null, true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/obj/finditemcommentsum", method = RequestMethod.POST)
    public JSON findItemCommentSum(@RequestBody CommentVo commentVo) {
        ItemCommentVo itemCommentVo = new ItemCommentVo();
        try {
            itemCommentVo = commentService.findItemCommentSum(commentVo.getId(), commentVo.getName(), commentVo.getStart(), commentVo.getEnd(), commentVo.getPage(), commentVo.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(itemCommentVo.getCommentSumVos(), itemCommentVo.getTotalPages(), itemCommentVo.getTotalElements(), true, "0");
    }

    @ResponseBody
    @RequestMapping(value = "/obj/findcommentbyitemid", method = RequestMethod.GET)
    public JSON findCommentVoByItemid(@RequestParam Long id, @RequestParam int page, @RequestParam int size) {
        ItemCommentReplyVo itemCommentReplyVo = new ItemCommentReplyVo();
        try {
            itemCommentReplyVo = commentService.findCommentVoByItemid(id, page, size);
            System.out.println("总评价数" + itemCommentReplyVo.getCommentReplyVos().size());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonUtils.toValue(null, false, "404");
        }
        return CommonUtils.toValue(itemCommentReplyVo, itemCommentReplyVo.getTotalPages(), itemCommentReplyVo.getTotalElements(), true, "0");
    }


}
