package com.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 21:36
 * @Description: pojo
 * @version: 1.0
 */
@Component
public class User implements Serializable {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
