package com.example.demo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Author: hj
 * Date: 2019-05-05 23:28
 * Description: <描述>
 */
@Data
public class User {

    @NotNull
    @Min(100)
    @Max(200)
    private Long id;

    @NotNull//不为空
    @Length(min = 2, max = 10)//字符串长度设置
    private String name;
}
