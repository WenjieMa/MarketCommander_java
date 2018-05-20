package com.vo;

import com.pojo.RecordComment;
import com.pojo.RecordCommentReply;

/**
 * Created by xiaoma on 2018/5/20.
 */
public class WholeComment {
    private RecordComment recordComment;
    private RecordCommentReply recordCommentReply;

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
