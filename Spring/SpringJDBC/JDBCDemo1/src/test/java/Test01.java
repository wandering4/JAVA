import com.dao.IStudentDao;
import com.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 16:29
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Test01 {

    //查询
    @Test
    public void TestQuery() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        IStudentDao bean = ac.getBean(IStudentDao.class);
        List<Student> students = bean.AllStu();
        students.forEach(System.out::println);
    }

    //添加
    @Test
    public void TestInsert() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        IStudentDao bean = ac.getBean(IStudentDao.class);
        Student student = new Student();
        student.setAge(18);
        student.setName("boge");
        student.setSex("男");
        int insert = bean.insert(student);
        System.out.println(insert);
    }

    //更新
    @Test
    public void TestUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        IStudentDao bean = ac.getBean(IStudentDao.class);
        Student student = new Student(1, "ve", 20, "女");
        System.out.println(bean.update(student));
    }

    //删除
    @Test
    public void TestDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        IStudentDao bean = ac.getBean(IStudentDao.class);
        System.out.println(bean.delById(3));
    }
}
