package com.aisino.admin.companyCard.codeAssign.service;

import com.aisino.admin.companyCard.codeAssign.bean.KPAssignCodeVO;
import com.aisino.admin.global.paging.Page;

import java.util.List;

public interface CodeAssignService {
    List<KPAssignCodeVO> queryPage(Page<KPAssignCodeVO> page);

    int count(Page<KPAssignCodeVO> page);
}
