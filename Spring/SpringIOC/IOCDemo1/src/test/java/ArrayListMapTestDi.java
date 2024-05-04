import Bean.ArrayListMap;
import Bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 21:33
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class ArrayListMapTestDi {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        ArrayListMap bean = ac.getBean(ArrayListMap.class);
        System.out.println(bean);
    }
}
