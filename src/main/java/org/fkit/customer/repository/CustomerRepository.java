package org.fkit.customer.repository;

import org.apache.ibatis.annotations.*;
import org.fkit.customer.bean.Customer;


import java.util.List;

public interface CustomerRepository{

    @Select("select * from customer")
    public List<Customer> findAll();

    @Select("select * from customer where cust_name like concat ('%',#{cust_name},'%') " +
            "and cust_industry like concat ('%',#{cust_industry},'%')")
    public List<Customer> findNameAndIndustry(String cust_name,String cust_industry);

    @Insert("insert into customer (cust_name,cust_code,cust_sex,cust_industry,cust_phone,cust_email)"
            + "values (#{cust_name},#{cust_code},#{cust_sex},#{cust_industry},#{cust_phone},#{cust_email})")
    public int insertCustomer(Customer customer);

    @Select("select * from customer where cust_id=#{cust_id}")
    public Customer editCustomer(Integer cust_id);

    @Update("update customer set cust_name=#{cust_name},cust_code=#{cust_code},cust_sex=#{cust_sex}," +
            "cust_industry=#{cust_industry},cust_phone=#{cust_phone},cust_email=#{cust_email} where cust_id=#{cust_id}")
    public int updateCustomer(Customer customer);

    @Delete("delete from customer where cust_id=#{cust_id}")
    public int deleteCustomer(Integer cust_id);
}

