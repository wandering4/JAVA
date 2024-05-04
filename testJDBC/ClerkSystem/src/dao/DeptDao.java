package dao;

import pojo.Dept;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/1/27 - 01 - 27 - 0:47
 * @Description: dao
 * @version: 1.0
 */
public interface DeptDao {
     public List<Dept> findAll();

     /**
      * 增加部门信息
      * @param dept 所增加的部门信息
      * @return 返回影响的行数
      */
     public int insert(Dept dept);
}
