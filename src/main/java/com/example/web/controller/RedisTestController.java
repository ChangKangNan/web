package com.example.web.controller;

import com.example.web.util.SnowflakeUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisTestController {
    @Resource
    RedisTemplate redisTemplate;

    @RequestMapping("/setValue/{key}")
    public String setKey(@PathVariable("key") String key){
        Long add = redisTemplate.opsForSet().add("uesd_key", key);
        System.out.println("结果:"+add);
        return "success";
    }

    @RequestMapping("/exist/{key}")
    public String existKey(@PathVariable("key") String key){
        Boolean uesdKey = redisTemplate.opsForSet().isMember("uesd_key", key);
        System.out.println("结果:"+uesdKey);
        return "success";
    }


    @RequestMapping("/getSnow")
    public String getSnow(){
        SnowflakeUtil snowflake = new SnowflakeUtil(23L, 2L);
        long nextId = snowflake.nextId();

        return "success:"+nextId;
    }


}
