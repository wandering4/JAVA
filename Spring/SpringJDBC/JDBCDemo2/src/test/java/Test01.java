import config.SpringConfiguration;
import com.controller.GoodsController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: xuzifan
 * @Date: 2024/4/24 - 04 - 24 - 17:28
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Test01 {

    @Test
    public void TestTX(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        GoodsController bean = ac.getBean(GoodsController.class);
        bean.buyGoods(1,1);
    }

    @Test
    public void TestConfig(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        GoodsController bean = ac.getBean(GoodsController.class);
        bean.buyGoods(1,1);
    }

    @Test
    public void TestXML(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        GoodsController bean = ac.getBean(GoodsController.class);
        bean.buyGoods(1,1);
    }
}
