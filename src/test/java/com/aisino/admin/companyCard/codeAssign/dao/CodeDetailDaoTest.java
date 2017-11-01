package com.aisino.admin.companyCard.codeAssign.dao;

import com.aisino.admin.companyCard.codeAssign.bean.KPCodeDetailDO;
import com.aisino.admin.companyCard.codeAssign.bean.KPCodeDetailDO;
import com.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.Assert.*;

public class CodeDetailDaoTest extends BaseTest {
    @Autowired
    CodeDetailDao codeDetailDao;

    String[] person = {"陈悠", "LYF", "文康", "杨丹", "豆豆"};
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZSDIHRYBGPK";
    String numbers = "01234567896572983975";
    String[] banks = {"中国邮政银行", "中国工商银行", "中国交通银行", "中国农业银行", "杭州银行", "宁波银行"};
    int[] sources = {10, 11, 12, 20, 30, 31, 40, 50, 99, 0};
    int[] statuses = {0, 8, 9, 10};
    String[] status = {"0", "1", "2"};

    @Test
    public void get() throws Exception {
        KPCodeDetailDO kpCodeDetailDO;
        kpCodeDetailDO = codeDetailDao.get(2);
        System.out.println(kpCodeDetailDO);
    }

    @Test
    public void insert() throws Exception {
        Set<String> codesSet = new HashSet<String>();
        int size = 5;
        for (int i = 0; i < size; i++) {
            String code = generateCode();
            codesSet.add(code);
        }

        Iterator<String> it = codesSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String code = it.next();
            KPCodeDetailDO kpCodeDetailDO = new KPCodeDetailDO();
            kpCodeDetailDO.setBindCompanyName("服务商子公司" + code);
            kpCodeDetailDO.setBindCompanyTaxid("201708041123" + code);
            kpCodeDetailDO.setPreAssignCode(code);
            kpCodeDetailDO.setBindPerson(person[i % 5]);
            kpCodeDetailDO.setBindTime(new Date());
            kpCodeDetailDO.setStatus(person[i % 5]);
            kpCodeDetailDO.setStatus(status[i % 3]);

            i++;
            codeDetailDao.insert(kpCodeDetailDO);
            System.out.println("detailId: "+kpCodeDetailDO.getDetailId());
            System.out.println("insertId="+ kpCodeDetailDO.getDetailId());

        }
    }

    @Test
    public void insertBatch() throws Exception {
        Set<String> codesSet = new HashSet<String>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            String code = generateCode();
            codesSet.add(code);
        }
        List<KPCodeDetailDO> list = new ArrayList<KPCodeDetailDO>();

        Iterator<String> it = codesSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String code = it.next();
            KPCodeDetailDO kpCodeDetailDO = new KPCodeDetailDO();
            kpCodeDetailDO.setBindCompanyName("服务商子公司" + code);
            kpCodeDetailDO.setBindCompanyTaxid("201708041123" + code);
            kpCodeDetailDO.setPreAssignCode(code);
            kpCodeDetailDO.setBindPerson(person[i % 5]);
            kpCodeDetailDO.setBindTime(new Date());
            kpCodeDetailDO.setStatus(person[i % 5]);
            kpCodeDetailDO.setStatus(status[i % 3]);
            list.add(kpCodeDetailDO);
            i++;
        }
        codeDetailDao.insertBatch(list);
    }

    @Test
    public void update() throws Exception {
        KPCodeDetailDO kpCodeDetailDO;
        kpCodeDetailDO = codeDetailDao.get(2);
        System.out.println(kpCodeDetailDO);

        kpCodeDetailDO.setPreAssignCode("ABCDEF");
        codeDetailDao.update(kpCodeDetailDO);
        System.out.println(kpCodeDetailDO);
    }

    @Test
    public void delete() throws Exception {
        int deleteId = 16;
        KPCodeDetailDO kpCodeDetailDO = codeDetailDao.get(deleteId);
        System.out.println(kpCodeDetailDO);
        if (kpCodeDetailDO != null) {
            codeDetailDao.delete(16);
        }
    }

    @Test
    public void deleteBatch() throws Exception {
    }

}