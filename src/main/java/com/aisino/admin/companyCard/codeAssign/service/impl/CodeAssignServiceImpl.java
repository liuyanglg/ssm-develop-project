package com.aisino.admin.companyCard.codeAssign.service.impl;

import com.aisino.admin.companyCard.codeAssign.bean.KPAssignCodeVO;
import com.aisino.admin.companyCard.codeAssign.dao.CodeAssignDao;
import com.aisino.admin.companyCard.codeAssign.service.CodeAssignService;
import com.aisino.admin.global.paging.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service("codeAssignService")
public class CodeAssignServiceImpl implements CodeAssignService{
    @Autowired
    CodeAssignDao codeAssignDao;

    public List<KPAssignCodeVO> queryPage(Page<KPAssignCodeVO> page) {
        return codeAssignDao.queryPage(page);
    }

    public int count(Page<KPAssignCodeVO> page) {
        return codeAssignDao.count(page);
    }
}
