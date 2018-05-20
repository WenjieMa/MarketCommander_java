package com.vo;

import java.util.List;

/**
 * Created by xiaoma on 2018/5/15.
 */
public class ItemCommentVo {
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int totalPages;
    public Long totalElements;

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    List<CommentSumVo> commentSumVos;

    public List<CommentSumVo> getCommentSumVos() {
        return commentSumVos;
    }

    public void setCommentSumVos(List<CommentSumVo> commentSumVos) {
        this.commentSumVos = commentSumVos;
    }
}
