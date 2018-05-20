package com.vo;

import com.pojo.InfoItem;

import java.util.List;

/**
 * Created by xiaoma on 2018/5/15.
 */
public class ItemCommentReplyVo {
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int totalPages;
    public Long totalElements;
    private InfoItem infoItem;

    public InfoItem getInfoItem() {
        return infoItem;
    }

    public void setInfoItem(InfoItem infoItem) {
        this.infoItem = infoItem;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    List<CommentReplyVo> commentReplyVos;

    public List<CommentReplyVo> getCommentReplyVos() {
        return commentReplyVos;
    }

    public void setCommentReplyVos(List<CommentReplyVo> commentReplyVos) {
        this.commentReplyVos = commentReplyVos;
    }
}
