package com.vo;

import com.pojo.InfoOperator;
import com.pojo.InfoRole;
import com.pojo.RecordAssistant2role;

import java.util.List;

/**
 * Created by xiaoma on 2018/5/15.
 */
public class OperatorLoginVo {
    public InfoOperator getInfoOperator() {
        return infoOperator;
    }

    public void setInfoOperator(InfoOperator infoOperator) {
        this.infoOperator = infoOperator;
    }


    public InfoOperator infoOperator;

    public List<InfoRole> getInfoRoles() {
        return infoRoles;
    }

    public void setInfoRoles(List<InfoRole> infoRoles) {
        this.infoRoles = infoRoles;
    }

    public List<InfoRole> infoRoles;

}
