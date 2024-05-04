package pojo;

import java.io.Serializable;

/**
 * @Author: xuzifan
 * @Date: 2024/4/17 - 04 - 17 - 14:49
 * @Description: pojo
 * @version: 1.0
 */
public class User implements Serializable {
    private String username;
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + pwd + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String password) {
        this.pwd = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.pwd = password;
    }

    public User() {
    }
}
