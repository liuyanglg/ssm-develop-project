package com.aisino.admin.companyCard.codeAssign.dao;

import com.aisino.admin.companyCard.codeAssign.bean.KPCodeMainDO;

import java.util.List;

public interface CodeMainDao {
    void insert(KPCodeMainDO kpCodeMainDO);

    void insertBatch(List<KPCodeMainDO> kpCodeMainDOList);
}
