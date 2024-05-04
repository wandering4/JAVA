package com.dao;

import com.pojo.Student;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 16:18
 * @Description: com.dao
 * @version: 1.0
 */
public interface IStudentDao {
    public List<Student> AllStu();

    public int insert(Student stu);

    public int update(Student stu);

    public int delById(Integer id);
}
