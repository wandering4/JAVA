package TEST01;

import java.sql.*;

/**
 * @Author: xuzifan
 * @Date: 2024/1/26 - 01 - 26 - 17:11
 * @Description: TEST01
 * @version: 1.0
 */
public class select {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user = "root";
    private static String password = "root";


    //这是一个main方法程序的入口
    public static void main(String[] args)  {
testSelect();

    }
    public static void testSelect() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String sql = "select * from emp;";
            resultSet = statement.executeQuery(sql);//代表对数据库多少行数据造成影响
            while (resultSet.next()){
                System.out.println(resultSet.getInt("empno"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
