package com.vo;

import com.pojo.HomeColumnsLevel2;

import java.util.List;


/**
 * Created by xiaoma on 2018/5/15.
 */
public class ColumnObjVo {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HomeColumnsLevel2> getH2s() {
        return h2s;
    }

    public void setH2s(List<HomeColumnsLevel2> h2s) {
        this.h2s = h2s;
    }

    private Long id;
    private String name;

    private List<HomeColumnsLevel2> h2s;
}
