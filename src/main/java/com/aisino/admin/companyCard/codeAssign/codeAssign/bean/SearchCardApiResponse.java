package com.aisino.admin.companyCard.codeAssign.codeAssign.bean;

import com.aisino.admin.companyCard.cardMaintain.bean.CompanyCard;
import com.aisino.admin.companyCard.codeAssign.bean.KPCodeMainDO;

import java.io.Serializable;
import java.util.List;

public class SearchCardApiResponse implements Serializable {
    private static final long serialVersionUID = 8682109128768414465L;

    private String code;
    private String message;
    private List<com.aisino.admin.companyCard.codeAssign.bean.KPCodeMainDO> kpCodeMainDOList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<com.aisino.admin.companyCard.codeAssign.bean.KPCodeMainDO> getKpCodeMainDOList() {
        return kpCodeMainDOList;
    }

    public void setKpCodeMainDOList(List<KPCodeMainDO> kpCodeMainDOList) {
        this.kpCodeMainDOList = kpCodeMainDOList;
    }
}
