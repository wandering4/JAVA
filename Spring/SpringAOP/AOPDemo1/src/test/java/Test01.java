
import com.config.SpringConfiguration;
import com.service.CglibProxy;
import com.service.SomeProxy;
import com.service.SomeService;
import com.service.SomeServiceNoInterface;
import com.service.impl.SomeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: xuzifan
 * @Date: 2024/4/23 - 04 - 23 - 15:10
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Test01 {
    /**
     * 实现静态代理
     */
    @Test
    public void test01(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        SomeProxy bean = ac.getBean(SomeProxy.class);
        System.out.println(bean.doSome());
    }

    /**
     * 实现JDK动态代理：目标对象必须实现相关接口
     */
    @Test
    public void test02(){
        SomeService target=new SomeServiceImpl();
        SomeService proxy=(SomeService)Proxy.newProxyInstance(
                Test01.class.getClassLoader(),//获取类加载器
                target.getClass().getInterfaces(),//获取目标对象实现的相关接口
                //提供一个InvocationHandler的对象
                new InvocationHandler() {
                    /**
                     * 该方法是代理对象执行目标对象的回调方法
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理对象开启了----");
                        String mess = (String) method.invoke(target, args);
                        System.out.println("代理对象结束了----");
                        return mess.toUpperCase();
                    }
                }
        );

        //3.通过代理对象来执行
        System.out.println("代理对象执行了"+proxy.doSome());
    }

    /**
     * 如果目标对象没有实现相关接口，则只能使用CGLIB代理（添加相关依赖）
     */
    @Test
    public void test03(){
        //获取目标对象
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        CglibProxy bean = ac.getBean(CglibProxy.class);
        //获取代理对象
        SomeServiceNoInterface target = bean.createTarget();
        //测试
        System.out.println(target.doSome());
        System.out.println();
        System.out.println(target.doSomeTwo());
    }
}
