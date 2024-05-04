package dao;

import pojo.Emp;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/1/27 - 01 - 27 - 1:26
 * @Description: dao
 * @version: 1.0
 */
public interface EmpDao {
    List<Emp> findAll();

    /**
     *根据工号删除员工
     * @return 返回影响行数
     */
    int delete(int empno);
    int insert(Emp emp);

    /**
     * 根据员工编号修改员工信息
     * @param emp 所要修改成为的形式
     * @return 返回影响的行数
     */
    int modify(Emp emp);
}
