package TEST01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author: xuzifan
 * @Date: 2024/1/26 - 01 - 26 - 16:59
 * @Description: TEST01
 * @version: 1.0
 */
public class delete {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user = "root";
    private static String password = "root";


    //这是一个main方法程序的入口
    public static void main(String[] args)  {
        testUpdate();

    }
    public static void testDelete() {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String sql = "delete from dept where deptno=40;";
            int rows = statement.executeUpdate(sql);//代表对数据库多少行数据造成影响
            System.out.println("影响行数：" + rows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void testUpdate() {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String sql = "update dept set dname='总部',loc='北京' where deptno=40;";
            int rows = statement.executeUpdate(sql);//代表对数据库多少行数据造成影响
            System.out.println("影响行数：" + rows);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


