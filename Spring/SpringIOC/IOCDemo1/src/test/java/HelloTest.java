import Bean.HelloWorld;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xuzifan
 * @Date: 2024/4/21 - 04 - 21 - 1:35
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class HelloTest {
    //这是一个main方法程序的入口
    public static void main(String[] args) {
        //通过非Spring容器的方式
        HelloWorld helloWorld=new HelloWorld();
        helloWorld.sayHello();
        //加载Spring容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //从容器中获取对象
        HelloWorld hw = (HelloWorld) ac.getBean("helloWorld");//根据id值从spring容器中获取Bean对象
        hw.sayHello();
    }
}
