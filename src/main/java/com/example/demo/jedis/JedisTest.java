package com.example.demo.jedis;

import redis.clients.jedis.Jedis;

/**
 * Author: hj
 * Date: 2019-05-07 17:35
 * Description: 使用jedis操作redis
 */
public class JedisTest {

    public static void main(String[] args) {
        //获取jedis的连接
        Jedis jedis=new Jedis("59.110.213.155",6379);
        //验证
        //jedis.auth("");
        //操作redis
        jedis.set("age","20");
        System.out.println("从redis缓存中取值:"+jedis.get("name"));

    }
}
