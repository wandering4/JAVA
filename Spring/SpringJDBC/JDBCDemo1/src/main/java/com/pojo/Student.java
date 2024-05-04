package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 16:17
 * @Description: com.pojo
 * @version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}
