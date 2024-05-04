package Bean;

/**
 * @Author: xuzifan
 * @Date: 2024/4/22 - 04 - 22 - 20:06
 * @Description: Bean
 * @version: 1.0
 */
public class number {
    int real;
    int fic;

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getFic() {
        return fic;
    }

    public void setFic(int fic) {
        this.fic = fic;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public number() {
    }

    public number(int real, int fic, String expression) {
        this.real = real;
        this.fic = fic;
        this.expression = expression;
    }

    String expression;
}
