package com.utils.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
