package com.aisino.admin.global.configer;

/**
 * @Package : com.lyf.global.configer
 * @Class : DataSourceContextHolder
 * @Description : 
 * @Author : liuya
 * @CreateDate : 2017-08-15 星期二 15:17:50
 * @Version : V1.0.0
 * @Copyright : 2017 liuya Inc. All rights reserved.
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDBType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDBType() {
        return ((String) contextHolder.get());
    }

    public static void clearDBType() {
        contextHolder.remove();
    }
}