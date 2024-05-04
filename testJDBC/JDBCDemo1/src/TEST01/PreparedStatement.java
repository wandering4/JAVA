package TEST01;

import entity.account;

import java.sql.*;
import java.util.Scanner;

/**
 * @Author: xuzifan
 * @Date: 2024/1/26 - 01 - 26 - 21:20
 * @Description: TEST01
 * @version: 1.0
 */
public class PreparedStatement {
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
    public static account get(String username, String pwd){
        Connection connection = null;
        java.sql.PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        account account =null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);

            //使用PreparedStatement语句防止注入攻击
            String sql = "select * from account where username= ? and password= ?;";
            preparedStatement = connection.prepareStatement(sql);

            //设置占位符参数
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,pwd);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Double balance = resultSet.getDouble("balance");
                account = new account(id, username, pwd, balance);}else{
                account=null;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
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
