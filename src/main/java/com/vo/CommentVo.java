package com.vo;

import java.sql.Timestamp;

/**
 * Created by xiaoma on 2018/5/20.
 */
public class CommentVo {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    Timestamp start;
    Timestamp end;
    private int page;
    private int size;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {

        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
