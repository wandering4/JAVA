package TEST01;

import java.sql.*;

/**
 * @Author: xuzifan
 * @Date: 2024/1/26 - 01 - 26 - 2:34
 * @Description: TEST01
 * @version: 1.0
 */
public class TEST00 {
    //这是一个main方法程序的入口
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    //向Dept表增加一条数据
        /*//1.加载驱动
        Driver driver=new com.mysql.cj.jdbc.Driver();
        //2.注册驱动
        DriverManager.registerDriver(driver); */
        //1.+2.通过反射加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获得链接
        /*
        url:统一资源定位符 定位所要链接的数据库
        （1）协议       jdbc:mysql:
        （2）IP         127.0.0.1/localhost/192.168.1.7
        （3）端口号      3306
        （4）数据库名字  mytest
        （5）参数
        协议：//ip:端口/资源路径？参数名=参数值&参数名=参数值&...
        jdbc:mysql://127.0.0.1:3306/mytest
         */
        String url = "jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        //4.获得语句对象
        Statement statement = connection.createStatement();
        //5.执行SQL语句，返回结果
        String sql="insert into dept values(50,'教学部','北京');";
        int rows = statement.executeUpdate(sql);//代表对数据库多少行数据造成影响
        System.out.println("影响行数："+rows);
        //6.释放资源
        statement.close();
        connection.close();


    }
}
