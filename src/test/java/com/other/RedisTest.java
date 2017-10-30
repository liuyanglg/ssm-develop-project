package com.other;

import com.aisino.admin.global.utils.SpringUtils;
import com.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedisTest extends BaseTest {
    private JedisPool cmpJedisPool;

    @Test
    public void testRedis() throws Exception {
        Set<String> codeSet = fetchCodes(10);
        System.out.printf(String.valueOf(codeSet));
    }

    public Set<String> fetchCodes(int size) {

        Set<String> codeSet = new HashSet<String>();
        Jedis jedis = null;
        try {
            Map globalConfig = (Map) SpringUtils.getBean("globalConfig");
            String redisKey = (String) globalConfig.get("code.prepare.assign.pool");

            jedis = cmpJedisPool.getResource();
            Set<Response<String>> responseSet = new HashSet<Response<String>>();
            Pipeline pipeline = jedis.pipelined();
            while (responseSet.size() < size) {
                pipeline.spop(redisKey);
                Response<String> response = pipeline.spop(redisKey);
                if (response == null) {
                    break;
                }
                responseSet.add(response);
            }
            pipeline.sync();

            for (Response<String> res : responseSet) {
                String code = res.get();
                if (code != null && code.trim().length() == 6) {
                    codeSet.add(code);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return codeSet;
    }

    @Test
    public void generateCodeToRedis() throws Exception {
        Set<String> codeSet = new HashSet<String>();
        while (codeSet.size() < 150) {
            codeSet.add(generateCode());
        }
        String key = "pool_card_code_test";
        Jedis jedis = null;
        Map globalConfig = (Map) SpringUtils.getBean("globalConfig");
        cmpJedisPool = (JedisPool) SpringUtils.getBean("cmpJedisPool");
        String redisKey = (String) globalConfig.get("code.prepare.assign.pool");

        jedis = cmpJedisPool.getResource();
        Pipeline pipeline = jedis.pipelined();
        for(String code:codeSet){
            pipeline.sadd(key, code);
        }
        pipeline.sync();
    }
}
