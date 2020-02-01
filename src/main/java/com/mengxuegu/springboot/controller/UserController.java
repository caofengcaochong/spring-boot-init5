package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import com.mengxuegu.springboot.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProviderMapper providerMapper;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/users")
    public String list(Map<String,Object> map,User user){
        logger.info("users has searched:"+user.getUsername());
//        Collection<Provider> providers = providerDao.getAll(providerName);
        List<User> users = userMapper.getUsers(user);
        map.put("users",users);
        map.put("username",user.getUsername());
        return "user/list";
    }

    @GetMapping("/user/{id}")
    public String view(@PathVariable("id") Integer id,@RequestParam(value = "type",defaultValue = "view")String type, Map<String,Object> map){
//        Provider provider = providerDao.getProvider(pid);
        User user = userMapper.getUserById(id);
        map.put("user",user);
       // return "provider/view";
        return "user/"+type;
    }

    @PutMapping("/user")
    public String update(User user){
        logger.info("修改信息");
//        providerDao.save(provider);
        userMapper.UpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user")
    public String toAddPage() {
        return "user/add";
    }

    @PostMapping("/user")
    public String add(User user) {
        logger.info("新增");
        System.out.println("nihao");
        userMapper.addUser(user);
        return "redirect:/users";
    }


    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id")Integer id){
        logger.info("删除:id"+id);
        userMapper.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/user/pwd")
    public String modifyPasswd(){
        return "main/password";
    }

    @ResponseBody
    @GetMapping("/user/pwd/{oldPwd}")
    public boolean checkPasswd(HttpSession session,@PathVariable("oldPwd") String oldPwd){
        logger.info("旧密码:"+oldPwd);
        User user = (User) session.getAttribute("loginUser");
        if(user.getPassword().equals(oldPwd)){
            return true;
        }
        return false;
    }

    @PostMapping("/user/pwd")
    public String updatePasswd(HttpSession session,String password){
        User user = (User) session.getAttribute("loginUser");
        user.setPassword(password);
        userMapper.UpdateUser(user);

        return "redirect:/logout";
    }


}
