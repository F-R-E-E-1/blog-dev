package com.jucwang.service;

import com.jucwang.entity.User;

public interface UserService {

    User checkUser(String username,String password);
}
