package com.vo;

import com.pojo.InfoItem;
import com.pojo.RecordImport;

import java.sql.Timestamp;

/**
 * InfoOperator entity. @author MyEclipse Persistence Tools
 */

public class ImportingVo {
    public InfoItem getInfoItem() {
        return infoItem;
    }

    public void setInfoItem(InfoItem infoItem) {
        this.infoItem = infoItem;
    }

    public RecordImport getRecordImport() {
        return recordImport;
    }

    public void setRecordImport(RecordImport recordImport) {
        this.recordImport = recordImport;
    }

    private InfoItem infoItem;
    private RecordImport recordImport;

}