package org.fkit.customer.bean;

import java.io.Serializable;

public class Customer implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer cust_id;
    private String cust_name;
    private String cust_code;
    private int cust_sex;
    private String cust_industry;
    private String cust_phone;
    private String cust_email;

    public Customer(Integer cust_id, String cust_name, String cust_code, int cust_sex,
                    String cust_industry, String cust_phone, String cust_email) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_code = cust_code;
        this.cust_sex = cust_sex;
        this.cust_industry = cust_industry;
        this.cust_phone = cust_phone;
        this.cust_email = cust_email;
    }

    public Customer() {
    }

    public Integer getCust_id() {
        return cust_id;
    }

    public void setCust_id(Integer cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_code() {
        return cust_code;
    }

    public void setCust_code(String cust_code) {
        this.cust_code = cust_code;
    }

    public int getCust_sex() {
        return cust_sex;
    }

    public void setCust_sex(int cust_sex) {
        this.cust_sex = cust_sex;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }
}
