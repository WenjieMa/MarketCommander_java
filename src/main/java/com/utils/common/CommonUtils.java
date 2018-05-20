package com.utils.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vo.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xiaoma on 2018/5/14.
 */
public class CommonUtils {
    public static JSON toValue(Object object, boolean ok, String code) {
        JSONObject json = new JSONObject();
        if (object != null) {
            json.put("data", JSON.toJSON(object));
            json.put("ok", ok);
            json.put("code", code);
        } else {
            json.put("data", "");
            json.put("ok", ok);
            json.put("code", code);
        }
        return json;
    }

    public static ItemCommentReplyVo sortCommentReply(List<CommentReplyVo> vos, ItemVo itemVo) {
        ItemCommentReplyVo itemCommentReplyVo = new ItemCommentReplyVo();
        int page = itemVo.getPage();
        int size = itemVo.getSize();

        List<CommentReplyVo> newVos = vos.stream().sorted((o1, o2) -> {
            if (o1.getOrderSmall().getItemstar() - o2.getOrderSmall().getItemstar() > 0) {
                return 1;
            } else if (o1.getOrderSmall().getItemstar() - o2.getOrderSmall().getItemstar() == 0) {
                return 0;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());
        newVos = newVos.subList((page - 1) * size, page * size > newVos.size() ? newVos.size() : page * size);
        itemCommentReplyVo.setCommentReplyVos(newVos);
        itemCommentReplyVo.setTotalElements(Long.parseLong(vos.size() + ""));
        itemCommentReplyVo.setTotalPages(vos.size() % size == 0 ? vos.size() / size : vos.size() / size + 1);
        return itemCommentReplyVo;
    }

    public static ItemCommentVo sortCommentSum(List<CommentSumVo> vos, CommentVo commentVo) {
        ItemCommentVo itemCommentVo = new ItemCommentVo();
        int page = commentVo.getPage();
        int size = commentVo.getSize();
       /* Collections.sort(vos, new Comparator<CommentSumVo>() {
            @Override
            public int compare(CommentSumVo o1, CommentSumVo o2) {
                if (o1.getCount() - o2.getCount() > 0) {
                    return 1;
                } else if (o1.getCount() - o2.getCount() == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });*/
        List<CommentSumVo> newVos = vos.stream().sorted((o1, o2) -> {
            if (o1.getCount() - o2.getCount() > 0) {
                return -1;
            } else if (o1.getCount() - o2.getCount() == 0) {
                return 0;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
        newVos = newVos.subList((page - 1) * size, page * size > newVos.size() ? newVos.size() : page * size);
        itemCommentVo.setCommentSumVos(newVos);
        itemCommentVo.setTotalElements(Long.parseLong(vos.size() + ""));
        itemCommentVo.setTotalPages(vos.size() % size == 0 ? vos.size() / size : vos.size() / size + 1);
        return itemCommentVo;
    }

    public static JSON toValue(Object object, int totalPages, Long totalElements, boolean ok, String code) {
        JSONObject json = new JSONObject();
        if (object != null) {
            json.put("data", JSON.toJSON(object));
            json.put("ok", ok);
            json.put("code", code);
            json.put("pages", totalPages);
            json.put("total", totalElements);
        } else {
            json.put("data", "");
            json.put("ok", ok);
            json.put("code", code);
        }
        return json;
    }
}
