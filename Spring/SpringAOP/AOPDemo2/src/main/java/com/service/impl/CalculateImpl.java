package com.service.impl;

import com.service.Calculate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 16:11
 * @Description: com.service.impl
 * @version: 1.0
 */
@Service
public class CalculateImpl implements Calculate {
    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }

    @Override
    public int sub(int i, int j) {
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        return i*j;
    }
}
