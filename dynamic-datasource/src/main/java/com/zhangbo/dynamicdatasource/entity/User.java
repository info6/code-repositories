package com.zhangbo.dynamicdatasource.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Copyright:Copyright(c) 2017
 * Company:北京通付盾数据科技有限公司
 *
 * @author:zhangbo
 * @Date:Created in 9:31 2018/10/23
 * route:
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String address;
}
