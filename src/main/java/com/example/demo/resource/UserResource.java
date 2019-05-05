package com.example.demo.resource;

import com.example.demo.User;
import com.example.demo.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Author: hj
 * Date: 2019-05-05 23:20
 * Description: <描述>
 */
@RestController
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    /**
     * 新增
     */
    @PostMapping(value = "/users", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public void createUser(@RequestBody User user) {
        userService.he();
        System.out.println(user);
    }
}
