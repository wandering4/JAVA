package dao.impl;
import dao.MyConnectionPool;
import pojo.Emp;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/1/27 - 01 - 27 - 22:25
 * @Description: dao.impl
 * @version: 1.0
 */
public abstract class BaseDao {
    public int baseUpdate(String sql,Object...args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MyConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            int result=preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            if(null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
                MyConnectionPool.returnConnection(connection);

        }
    }
    public List baseQuery(Class clazz,String sql,Object...args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        List list = null;
        try {
            connection = MyConnectionPool.getConnection();
            list=new ArrayList<>();
            preparedStatement = connection.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
            }
            while(resultSet.next()){
                //通过反射创建对象
                Object object=clazz.newInstance();
                for (Field declaredField : declaredFields) {
                    String fieldname=declaredField.getName();
                    Object data=resultSet.getObject(fieldname);
                    declaredField.set(object,data);
                }
                list.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            MyConnectionPool.returnConnection(connection);
        }
        return list;
    }
}
