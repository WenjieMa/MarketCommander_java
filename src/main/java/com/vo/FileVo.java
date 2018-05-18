package com.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xiaoma on 2018/5/19.
 */
public class FileVo {
    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    MultipartFile multipartFile;
    Long id;
}
