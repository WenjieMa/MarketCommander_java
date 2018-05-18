package com.vo;

/**
 * Created by xiaoma on 2018/5/19.
 */
public class ImageVo {
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    boolean success;
    String url;

}
