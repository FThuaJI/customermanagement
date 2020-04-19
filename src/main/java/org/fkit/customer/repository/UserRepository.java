package org.fkit.customer.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.customer.bean.User;

import java.util.List;


public interface UserRepository {

    @Insert("insert into tb_user(loginName,username,password)"
            + "values (#{loginName},#{username},#{password})")
    public void insertUser(String loginName, String username, String password);

    @Select("select * from tb_user where username = #{username}")
    public User findUser(String username, String password);

    @Select("select * from tb_user")
    public List<User> findAllUser();

    @Select("select * from tb_user where id=#{id}")
    public User editUser(Integer id);

    @Update("update tb_user set loginName=#{loginName},username=#{username},password=#{password} where id=#{id}")
    public int updateUser(User user);

    @Delete("delete from tb_user where id=#{id}")
    public int deleteUser(Integer id);
}
