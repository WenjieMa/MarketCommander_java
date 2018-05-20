package com.vo;

import com.pojo.RecordCollection;

/**
 * Created by xiaoma on 2018/5/15.
 */
public class CollectionVo {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int page;
    public int size;
    public RecordCollection recordCollection;

    public RecordCollection getRecordCollection() {
        return recordCollection;
    }

    public void setRecordCollection(RecordCollection recordCollection) {
        this.recordCollection = recordCollection;
    }
}
