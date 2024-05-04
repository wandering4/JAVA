import Bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xuzifan
 * @Date: 2024/4/21 - 04 - 21 - 16:08
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class StudentTestDi {
    @Test
    public void Test1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student bean = ac.getBean(Student.class);
        if(bean.getAge()==null){
            System.out.println("111");
        }
        System.out.println(bean);
    }
}
