package com.example.demo;

import org.springframework.cache.annotation.Cacheable;

/**
 * Author: hj
 * Date: 2019-05-07 18:14
 * Description: <描述>
 */
//@Repository
public class UserMapper {

    /**
     * 将用户信息添加到缓存
     *
     * @param id
     * @param name
     */
    @Cacheable("cache_name")
    public void createUser(Long id, String name) {
        System.out.println("UserMapper.createUser");
    }
}
