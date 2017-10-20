package com.aisino.admin.companyCard.codeAssign.dao;

import com.aisino.admin.companyCard.codeAssign.bean.KPCodeMainDO;
import com.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class CodeMainDaoTest extends BaseTest{
    @Autowired
    private CodeMainDao codeMainDao;
    String[] person = {"陈悠", "LYF", "文康", "杨丹", "豆豆"};
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZSDIHRYBGPK";
    String numbers = "01234567896572983975";
    String[] banks = {"中国邮政银行", "中国工商银行", "中国交通银行", "中国农业银行", "杭州银行", "宁波银行"};
    int[] sources = {10,11,12,20,30,31,40,50,99,0};
    int[]statuses={0,8,9,10};

    @Test
    public void get() throws Exception {
        KPCodeMainDO kpCodeMainDO = codeMainDao.get(2);
        System.out.println(kpCodeMainDO);
    }



    @Test
    public void update() throws Exception {
        KPCodeMainDO kpCodeMainDO = codeMainDao.get(2);
        System.out.println(kpCodeMainDO);
        kpCodeMainDO.setAssignCompanyName("company update");
        codeMainDao.update(kpCodeMainDO);
         kpCodeMainDO = codeMainDao.get(2);
        System.out.println(kpCodeMainDO);
    }

    @Test
    public void delete() throws Exception {
        codeMainDao.delete(33);
    }

    @Test
    public void insertBatch() throws Exception {
        Set<String> codesSet = new HashSet<String>();
        int size=10;
        for(int i=0;i<size;i++){
            String code = generateCode();
            codesSet.add(code);
        }
        List<KPCodeMainDO> list = new ArrayList<KPCodeMainDO>();

        Iterator<String> it = codesSet.iterator();
        int i=0;
        while (it.hasNext()){
            String code = it.next();
            KPCodeMainDO kpCodeMainDO = new KPCodeMainDO();
            kpCodeMainDO.setAssignCompanyName("服务商"+code);
            kpCodeMainDO.setAssignCompanyTaxid("201708041123" + code);
            kpCodeMainDO.setAssignAmount(10);
            kpCodeMainDO.setAssignEmployeeId("employee" + code);
            kpCodeMainDO.setAssignEmployeeName("员工" + code);
            kpCodeMainDO.setAssignEmployeeMobile("15988881234");
            kpCodeMainDO.setCreatePerson(person[i % 5]);
            kpCodeMainDO.setCreateTime(new Date());
            kpCodeMainDO.setModifyPerson(person[i % 5]);
            kpCodeMainDO.setModifyTime(new Date());
            list.add(kpCodeMainDO);
            i++;
        }
        codeMainDao.insertBatch(list);
    }


    @Test
    public void insert() throws Exception {
        Set<String> codesSet = new HashSet<String>();
        int size=10;
        for(int i=0;i<size;i++){
            String code = generateCode();
            codesSet.add(code);
        }
        Iterator<String> it = codesSet.iterator();
        int i=0;
        while (it.hasNext()){
            String code = it.next();
            KPCodeMainDO kpCodeMainDO = new KPCodeMainDO();
            kpCodeMainDO.setAssignCompanyName("服务商"+code);
            kpCodeMainDO.setAssignCompanyTaxid("201708041123" + code);
            kpCodeMainDO.setAssignAmount(10);
            kpCodeMainDO.setAssignEmployeeId("employee" + code);
            kpCodeMainDO.setAssignEmployeeName("员工" + code);
            kpCodeMainDO.setAssignEmployeeMobile("15988881234");
            kpCodeMainDO.setCreatePerson(person[i % 5]);
            kpCodeMainDO.setCreateTime(new Date());
            kpCodeMainDO.setModifyPerson(person[i % 5]);
            kpCodeMainDO.setModifyTime(new Date());
            i++;
            codeMainDao.insert(kpCodeMainDO);
        }
    }


    public String generateCode() throws Exception {
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            char c;
            int j = (int) (Math.random() * 5);
            if (j == 0 || j == 1||j==2) {
                c = numbers.charAt((int) (Math.random() * 20));
            } else {
                c = letters.charAt((int) (Math.random() * 36));
            }
            code.append(c);
        }
        return code.toString();
    }
}