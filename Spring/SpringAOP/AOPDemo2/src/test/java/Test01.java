

import com.service.Calculate;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 16:20
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Test01 {

    @Test
    public void test01(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Calculate bean = (Calculate)ac.getBean(Calculate.class);
        System.out.println(bean.add(4, 7));
        System.out.println(bean.div(4, 7));
        System.out.println(bean.sub(4, 7));
        System.out.println(bean.mul(4, 7));

    }
}
