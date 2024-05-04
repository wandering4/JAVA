package dao.impl;

import dao.EmpDao;
import pojo.Dept;
import pojo.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/1/27 - 01 - 27 - 1:26
 * @Description: dao.impl
 * @version: 1.0
 */
public class EmpDaoImpl extends BaseDao implements EmpDao {
    @Override
    public int modify(Emp emp) {
        String sql="update emp  set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        return baseUpdate(sql,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHireDate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno());
    }

    @Override
    public List<Emp> findAll() {
            String sql="select * from emp";
     return baseQuery(Emp.class,sql);
    }

    @Override
    public int insert(Emp emp) {
        String sql="insert into emp values(null,?,?,?,?,?,?,?)";
        return baseUpdate(sql,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHireDate(),emp.getSal(),emp.getComm(),emp.getDeptno());
    }

    @Override
    public int delete(int empno) {
    String sql="delete from emp where empno=?";
    return baseUpdate(sql,empno);
    }

}

