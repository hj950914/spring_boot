package com.example.demo.resource;

import com.example.demo.User;
import com.example.demo.UserService;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Author: hj
 * Date: 2019-05-05 23:20
 * Description: @RequiredArgsConstructor将final修饰的变量添加到构造方法参数中
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(produces = APPLICATION_JSON_UTF8_VALUE)
public class UserResource {

    private final UserService userService;

    //设置缓存120秒失效（k:id--v:用户）
    private Cache<Long, User> userCache = Caffeine.newBuilder()
            .expireAfterWrite(120, TimeUnit.SECONDS).build();


    /**
     * 新增用户（使用POST）
     * consumes属性指定处理请求的提交内容类型（Content-Type）
     * produces指定返回给前端内容类型
     */

    @PostMapping(value = "/users", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void createUser(@RequestBody @Valid User user) {
        userService.he();
        //将用户加入缓存
        userCache.put(user.getId(), user);
    }

    /**
     * 查找所有用户,将数据以json格式返回前端 (使用GET)
     */

    @GetMapping(value = "/users")
    public List<User> findUsers() {
        //从缓存查找用户
        return Lists.newArrayList(userCache.asMap().values());
    }

    /**
     * 查找单个用户,将数据以json格式返回前端 (使用GET)
     * 注解@PathVariable表示请求链接中参数自动赋值
     */

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return userCache.getIfPresent(id);
    }

    /**
     * 更新用户(使用PUT)
     */

    @PutMapping("users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
        //判断缓存中是否存在即将更新的用户
        if (userCache.getIfPresent(id) != null) {
            userCache.put(id, user);
        }
    }

    /**
     * 删除用户(使用DELETE)
     */

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userCache.invalidate(id);
    }
}
