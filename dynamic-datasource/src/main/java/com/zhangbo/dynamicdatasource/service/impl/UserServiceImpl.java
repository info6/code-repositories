package com.zhangbo.dynamicdatasource.service.impl;

import com.zhangbo.dynamicdatasource.dao.UserRepository;
import com.zhangbo.dynamicdatasource.annotation.ReadOnly;
import com.zhangbo.dynamicdatasource.entity.User;
import com.zhangbo.dynamicdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author: zhangbo
 * @Date: 2018/10/23 23:02
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        Objects.requireNonNull(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    @ReadOnly
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
