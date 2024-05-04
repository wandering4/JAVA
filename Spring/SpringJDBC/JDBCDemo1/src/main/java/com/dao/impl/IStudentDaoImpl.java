package com.dao.impl;

import com.dao.IStudentDao;
import com.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 16:20
 * @Description: com.dao.impl
 * @version: 1.0
 */
@Repository
public class IStudentDaoImpl implements IStudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

/*    @Override
    public List<Student> AllStu() {
        String sql = "select * from t_student";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }*/

    @Override
    public List<Student> AllStu() {
        String sql = "select * from t_student";
       return jdbcTemplate.query(sql, new RowMapper<Student>() {
           @Override
           public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
               return new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("sex"));
           }
       });
    }

    @Override
    public int insert(Student stu) {
        String sql="insert into t_student(name,age,sex) values(?,?,?) ";
        return jdbcTemplate.update(sql, stu.getName(), stu.getAge(), stu.getSex());
    }

    @Override
    public int update(Student stu) {
        String sql="update t_student set name=? ,age=? ,sex=? where id=?";
        return jdbcTemplate.update(sql, stu.getName(), stu.getAge(), stu.getSex(), stu.getId());
    }

    @Override
    public int delById(Integer id) {
        String sql="delete from t_student where id =?";
        return jdbcTemplate.update(sql, id);
    }
}
