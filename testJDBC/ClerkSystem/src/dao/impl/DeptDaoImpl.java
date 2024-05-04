package dao.impl;

import dao.DeptDao;
import pojo.Dept;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/1/27 - 01 - 27 - 1:04
 * @Description: dao.impl
 * @version: 1.0
 */
public class DeptDaoImpl extends BaseDao implements DeptDao {

    @Override
    public int insert(Dept dept) {
        String sql = "insert into dept values(?,?,?)";
        return baseUpdate(sql, dept.getDeptno(), dept.getDname(), dept.getLoc());
    }

    @Override
    public List<Dept> findAll() {
        String sql = "select * from dept";
        return baseQuery(Dept.class, sql);
    }
}
