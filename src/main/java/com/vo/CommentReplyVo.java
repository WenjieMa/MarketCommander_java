package com.vo;

import com.pojo.*;

import java.sql.Timestamp;

/**
 * Created by xiaoma on 2018/5/20.
 */
public class CommentReplyVo {
    private InfoUser infoUser;

    private InfoOperator infoOperator;
    private RecordComment recordComment;
    private RecordCommentReply recordCommentReply;
    private OrderSmall orderSmall;

    public OrderSmall getOrderSmall() {
        return orderSmall;
    }

    public void setOrderSmall(OrderSmall orderSmall) {
        this.orderSmall = orderSmall;
    }

    public InfoUser getInfoUser() {
        return infoUser;
    }

    public void setInfoUser(InfoUser infoUser) {
        this.infoUser = infoUser;
    }

    public InfoOperator getInfoOperator() {
        return infoOperator;
    }

    public void setInfoOperator(InfoOperator infoOperator) {
        this.infoOperator = infoOperator;
    }

    public RecordComment getRecordComment() {
        return recordComment;
    }

    public void setRecordComment(RecordComment recordComment) {
        this.recordComment = recordComment;
    }

    public RecordCommentReply getRecordCommentReply() {
        return recordCommentReply;
    }

    public void setRecordCommentReply(RecordCommentReply recordCommentReply) {
        this.recordCommentReply = recordCommentReply;
    }
}
