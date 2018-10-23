package com.zhangbo.dynamicdatasource.service;

import com.zhangbo.dynamicdatasource.entity.User;

import java.util.List;

/**
 * @Description
 * @Author: zhangbo
 * @Date: 2018/10/23 23:02
 */
public interface UserService {

    List<User> findAll();

    User save(User user);

    void delete(User user);

}
