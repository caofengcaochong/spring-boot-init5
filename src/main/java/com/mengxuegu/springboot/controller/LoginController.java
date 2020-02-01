package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Map<String, String> map) {
        if (!StringUtils.isEmpty(username) || "".equals(username)) {
            User user = userMapper.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                session.setAttribute("loginUser", user);
                return "redirect:main.html";
            }
        }
        map.put("msg", "用户名或者密码错误");
        return "main/login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.invalidate();
        return "redirect:index.html";
    }

}
