package Bean;

import java.io.Serializable;

/**
 * @Author: xuzifan
 * @Date: 2024/4/21 - 04 - 21 - 16:08
 * @Description: Bean
 * @version: 1.0
 */
public class Student implements Serializable {
    //IoC容器是依靠name值找对应的set方法赋值，因此必须有set方法
    private String id;
    private String name;
    private Integer age;
    private Clazz clazz;

    public Student(String id, String name, Integer age, Clazz clazz) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.clazz = clazz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", clazz=" + clazz +
                '}';
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Student() {
    }
}
