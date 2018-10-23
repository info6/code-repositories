package com.zhangbo.dynamicdatasource;

import com.zhangbo.dynamicdatasource.dao.UserRepository;
import com.zhangbo.dynamicdatasource.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDatasourceApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        List<User> list = userRepository.findAll();
        System.out.println(list);
    }


}
