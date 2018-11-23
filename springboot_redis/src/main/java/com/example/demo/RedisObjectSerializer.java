package com.example.demo;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

/**
 * Created by hongjian.chen on 2018/11/22.
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {
    @Override
    public byte[] serialize(@Nullable Object o) throws SerializationException {
        return new byte[0];
    }

    @Override
    public Object deserialize(@Nullable byte[] bytes) throws SerializationException {
        return null;
    }
}
