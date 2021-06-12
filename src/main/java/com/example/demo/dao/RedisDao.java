package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by hongjian.chen on 2018/6/26.
 */

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value);
    }

    public void setKeyOfExpire(String key, String value, long exprie, TimeUnit unit) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value, exprie, unit);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return Optional.ofNullable(ops.get(key)).orElse("0");
    }

    public Long getExpire(String key, TimeUnit unit) {
        return redisTemplate.getExpire(key, unit);
    }

    public boolean setIfAbsent(String key, String expire, long expireTime) {
        Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, expire, expireTime, TimeUnit.MILLISECONDS);
        return flag;
    }
}

