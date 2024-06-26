package pojo;

import java.io.Serializable;

/**
 * @Author: xuzifan
 * @Date: 2024/4/16 - 04 - 16 - 16:24
 * @Description: pojo
 * @version: 1.0
 */
public class User implements Serializable {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
