package com.aisino.admin.companyCard.codeAssign.bean;

import java.util.Date;

public class KPCodeDetailDO {
    private int detailId;
    private int mainId;
    private String preAssignCode;
    private String bindCompanyName;
    private String bindCompanyTaxid;
    private String bindPerson;
    private Date bindTime;
    private String originCode;
    private String status;

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getMainId() {
        return mainId;
    }

    public void setMainId(int mainId) {
        this.mainId = mainId;
    }

    public String getPreAssignCode() {
        return preAssignCode;
    }

    public void setPreAssignCode(String preAssignCode) {
        this.preAssignCode = preAssignCode;
    }

    public String getBindCompanyName() {
        return bindCompanyName;
    }

    public void setBindCompanyName(String bindCompanyName) {
        this.bindCompanyName = bindCompanyName;
    }

    public String getBindCompanyTaxid() {
        return bindCompanyTaxid;
    }

    public void setBindCompanyTaxid(String bindCompanyTaxid) {
        this.bindCompanyTaxid = bindCompanyTaxid;
    }

    public String getBindPerson() {
        return bindPerson;
    }

    public void setBindPerson(String bindPerson) {
        this.bindPerson = bindPerson;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
