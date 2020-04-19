package org.fkit.customer.bean;

import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id ;
    private String loginName ;
    private String username ;
    private String password;
    private int user_sex;
    private String user_industry;
    private String user_phone;
    private String user_email;

    public User() {
        super();
    }

    public User(int id, String loginName, String username, String password,
                int user_sex, String user_industry, String user_phone, String user_email) {
        this.id = id;
        this.loginName = loginName;
        this.username = username;
        this.password = password;
        this.user_sex = user_sex;
        this.user_industry = user_industry;
        this.user_phone = user_phone;
        this.user_email = user_email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public String getUser_industry() {
        return user_industry;
    }

    public void setUser_industry(String user_industry) {
        this.user_industry = user_industry;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}


