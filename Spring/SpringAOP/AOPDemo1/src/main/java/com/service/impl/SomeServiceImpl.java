package com.service.impl;

import com.service.SomeService;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 15:07
 * @Description: com
 * @version: 1.0
 */
@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public String doSome() {
        System.out.println("目标对象执行了----");
        return "hello";
    }
}
