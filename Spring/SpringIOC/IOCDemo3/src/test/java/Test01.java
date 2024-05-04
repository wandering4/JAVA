import com.config.SpringConfiguration;
import com.controller.UserController;
import com.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 14:25
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Test01 {

    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserController bean = ac.getBean(UserController.class);
        List<User> list=bean.list();
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //基于JAVA配置类的方式使用
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        UserController bean = ac.getBean(UserController.class);
        List<User> list=bean.list();
        list.forEach(System.out::println);
    }
}
