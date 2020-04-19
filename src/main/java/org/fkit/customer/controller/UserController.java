package org.fkit.customer.controller;

import org.fkit.customer.bean.User;
import org.fkit.customer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/insertUser")
    public String insertUser(String loginName, String username, String password){

        userService.insertUser(loginName,username,password);
        return "login";
    }

    @RequestMapping("/findUser")
    public String findUser(String username, String password, Model model, HttpSession session){

        User user= userService.findUser(username,password);
        if (user.getUsername().equals(username)&&user.getPassword().equals(password)){
            session.setAttribute("loginName",user.getLoginName());
            session.setAttribute("user",user);
        }else{
            return "login";
        }
        return "redirect:/customer/findAll";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}

