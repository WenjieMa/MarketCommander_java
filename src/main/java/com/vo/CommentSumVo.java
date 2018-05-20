package com.vo;

/**
 * Created by xiaoma on 2018/5/15.
 */
public class CommentSumVo {
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

    public Double getAvgstar() {
        return avgstar;
    }

    public void setAvgstar(Double avgstar) {
        this.avgstar = avgstar;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long id;
    public String name;
    public Double avgstar;
    public Long count;

}
