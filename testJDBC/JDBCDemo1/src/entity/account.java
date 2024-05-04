package entity;

import java.io.Serializable;

/**
 * @Author: xuzifan
 * @Date: 2024/1/26 - 01 - 26 - 18:10
 * @Description: entity
 * @version: 1.0
 */
public class account implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String password;
    private Double balance;

    public account(Integer id, String username, String password, Double balance) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public account() {
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
