package com.aisino.admin.companyCard.codeAssign.service;

import com.aisino.admin.companyCard.codeAssign.bean.KPAssignCodeVO;
import com.aisino.admin.global.paging.Page;
import com.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CodeAssignServiceTest extends BaseTest {
    @Autowired
    private CodeAssignService codeAssignService;
    @Test
    public void queryPage() throws Exception {
        List<KPAssignCodeVO> kpAssignCodeVOList;
        KPAssignCodeVO kpAssignCodeVO = new KPAssignCodeVO();
        Page<KPAssignCodeVO> page = new Page<KPAssignCodeVO>(kpAssignCodeVO);
        page.setPageSize(15);
        page.setStartIndex(0);
        page.setOrderCol("assign_company_name");
        kpAssignCodeVOList=codeAssignService.queryPage(page);

        for(KPAssignCodeVO assignCodeVO :kpAssignCodeVOList){
            System.out.println(assignCodeVO);
        }
    }

    @Test
    public void count() throws Exception {
    }

}