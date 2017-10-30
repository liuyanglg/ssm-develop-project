package com.other;

import com.aisino.admin.global.utils.SpringUtils;
import com.aisino.projects.usercenter.redis.support.service.IUserCenterRedisService;
import com.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ApiTest extends BaseTest {
    IUserCenterRedisService companyApi;

    @Test
    public void testUserCenter(){
        companyApi = (IUserCenterRedisService) SpringUtils.getBean("companyApi");
        List<Map<String, Object>> employees=companyApi.getAllEmployeeList("taxnum13800080008");
        System.out.println(employees);
    }
}
