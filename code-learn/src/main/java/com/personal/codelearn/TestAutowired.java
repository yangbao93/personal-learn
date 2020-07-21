package com.personal.codelearn;

import com.personal.codelearn.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestAutowired {

    @Autowired
    private TestConfig config;

    TestAutowired() {
        System.out.println(config.getKey());
        System.out.println(config.getValue());
    }
}
