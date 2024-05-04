package TEST01;

import entity.account;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: xuzifan
 * @Date: 2024/1/26 - 01 - 26 - 18:16
 * @Description: TEST01
 * @version: 1.0
 */
public class getAccount {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String user = "root";
    private static String password = "root";

    //这是一个main方法程序的入口
    public static void main(String[] args) {
        Scanner cd=new Scanner(System.in);
        String user=cd.next();
        String password=cd.next();
        //注入攻击
        // asdf
        //asdf'or'a'='a
        account zzh = get(user, password);
        System.out.println(zzh);
    }
    public static account get(String username,String pwd){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;
        account account =null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            String sql = "select * from account where username='"+username+"' and password='"+pwd+"';";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){Integer id=resultSet.getInt("id");
            Double balance=resultSet.getDouble("balance");
            account = new account(id, username, pwd, balance);}else{
                account=null;
            }

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
        return account;
    }

}
