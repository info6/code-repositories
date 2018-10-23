package com.zhangbo.dynamicdatasource.dao;

import com.zhangbo.dynamicdatasource.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright:Copyright(c) 2017
 * Company:北京通付盾数据科技有限公司
 *
 * @author:zhangbo
 * @Date:Created in 9:33 2018/10/23
 * route:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
