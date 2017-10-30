package com.aisino.admin.companyCard.codeAssign.dao;

import com.aisino.admin.companyCard.codeAssign.bean.KPAssignCodeVO;
import com.aisino.admin.global.paging.Page;
import com.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CodeAssignDaoTest extends BaseTest{
    @Autowired
    CodeAssignDao codeAssignDao;
    @Test
    public void queryPage() throws Exception {
        List<KPAssignCodeVO> kpAssignCodeVOList;
        KPAssignCodeVO kpAssignCodeVO = new KPAssignCodeVO();
        Page<KPAssignCodeVO> page = new Page<KPAssignCodeVO>(kpAssignCodeVO);
        page.setPageSize(15);
        page.setStartIndex(0);
        page.setOrderCol("assign_company_name");
        kpAssignCodeVOList=codeAssignDao.queryPage(page);

        for(KPAssignCodeVO assignCodeVO :kpAssignCodeVOList){
            System.out.println(assignCodeVO);
        }
    }

    @Test
    public void testRegex()throws Exception{
        int size = 0;
        String url = "/dataAnalysis-web/company/phrase?text=%s&size=%d";
        url = url.replaceFirst("%s", "浙江");
        if (size == 0) {
            size = 5;
        }
        url = url.replaceFirst("%", size + "");
        System.out.println(url);
    }

}