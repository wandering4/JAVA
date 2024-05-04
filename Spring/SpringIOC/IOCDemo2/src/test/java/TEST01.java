import com.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pojo.User;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 21:42
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class TEST01 {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserController bean = ac.getBean(UserController.class);
        bean.queryList();
    }

    @Test
    public void test02(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User bean = ac.getBean(User.class);
        System.out.println(bean);
    }
}
