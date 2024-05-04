package Bean;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 20:13
 * @Description: Bean
 * @version: 1.0
 */
public class Clazz {
    private Integer cno;
    private String name;

    @Override
    public String toString() {
        return "Clazz{" +
                "cno=" + cno +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz(Integer cno, String name) {
        this.cno = cno;
        this.name = name;
    }

    public Clazz() {
    }
}
