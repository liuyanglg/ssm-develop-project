package com.aisino.admin.companyCard.codeAssign.codeAssign.service;

import com.aisino.admin.companyCard.codeAssign.bean.KPCodeMainDO;

import java.util.List;

public interface CodeMainService {
    KPCodeMainDO get(Integer id);

    void insert(KPCodeMainDO kpCodeMainDO);

    void update(KPCodeMainDO kpCodeMainDO);

    void delete(Integer id);

    void insertBatch(List<KPCodeMainDO> kpCodeMainDOList);

    KPCodeMainDO queryByTaxid(String taxid);
}
