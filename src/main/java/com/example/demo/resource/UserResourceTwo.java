package com.example.demo.resource;

import com.example.demo.User;
import com.example.demo.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Author: hj
 * Date: 2019-05-05 23:20
 * Description: @RequiredArgsConstructor将final修饰的变量添加到构造方法参数中
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class UserResourceTwo {

    //private final UserMapper userMapper;

    /**
     * 新增用户（使用POST）
     * consumes属性指定处理请求的提交内容类型（Content-Type）
     * produces指定返回给前端内容类型
     */
    @PostMapping(value = "/users", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void createUser(@RequestBody @Valid User user) {
        //将用户加入缓存
        new UserMapper().createUser(user.getId(),user.getName());
    }
}
