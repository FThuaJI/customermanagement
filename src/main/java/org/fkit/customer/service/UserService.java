package org.fkit.customer.service;

import org.fkit.customer.bean.User;
import org.fkit.customer.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public void insertUser(String loginName, String username, String password){
        userRepository.insertUser(loginName,username,password);
    }

    public User findUser(String username, String password){
        return userRepository.findUser(username,password);
    }

    public List<User> findAllUser(){
        return userRepository.findAllUser();
    }

    public User editUser(Integer id){
        return userRepository.editUser(id);
    }

    public int updateUser(User user){
        return userRepository.updateUser(user);
    }

    public int deleteUser(Integer id){
        return userRepository.deleteUser(id);
    }
}

