package com.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-cmp-spring.xml"})
public class BaseTest {
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZSDIHRYBGPK";
    String numbers = "98234567896572983975";

    public String generateCode() throws Exception {
        StringBuffer code = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            char c;
            int j = (int) (Math.random() * 5);
            if (j == 0 || j == 1 || j == 2) {
                c = numbers.charAt((int) (Math.random() * 20));
            } else {
                c = letters.charAt((int) (Math.random() * 36));
            }
            code.append(c);
        }
        return code.toString();
    }
}
