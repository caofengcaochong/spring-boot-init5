package com.mengxuegu.springboot.mapper;


import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.entities.User;

import java.util.List;

public interface UserMapper {
//    List<Provider> getProviders(String providerName);
    User getUserByUsername(String username);
    List<User> getUsers(User user);
    User getUserById(Integer id);
    int addUser(User user);
    int UpdateUser(User user);
    int deleteUserById(Integer id);
}
