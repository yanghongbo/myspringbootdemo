package com.example.demo.core.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, String > redisTemplate;

    @Autowired
    public void setRedis(RedisTemplate<String, String  > redisTemplate) {
        this.redisTemplate = redisTemplate;
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        this.redisTemplate.setKeySerializer(stringSerializer);
        this.redisTemplate.setValueSerializer(stringSerializer);
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String  value) {
        boolean result = false;
        try {
            ValueOperations<String , String > operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value, Long expireTime ,TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<String , String > operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
