package com.travel.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Redis工具类
 * @Author liguangyao
 * @Date 2018/5/22 下午6:10
 * @Version 1.0
 **/
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate template;
    private static StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    private static RedisTemplate redisTemplate1;

    @PostConstruct
    private void init(){
        stringRedisTemplate = template;
        redisTemplate1 = redisTemplate;
    }

    public static void put(String k, Object object) {
        if (isEmpty(object))
            return;
        String v = new String(SerializeUtil.serialize(object));
        stringRedisTemplate.opsForValue().set(k, v);
    }

    public static void put(String k, Object object, long time) {
        if (isEmpty(object))
            return;
        String v = new String(SerializeUtil.serialize(object));
        stringRedisTemplate.opsForValue().set(k, v, time);
    }

    public static String get(String k) {
        String v = stringRedisTemplate.opsForValue().get(k);
        if (isEmpty(v))
            return null;
        return v;
    }

    public static boolean deleteKey(String key) {
        return stringRedisTemplate.delete(key);
    }

    public static <T> T get(String k, Class<T> clazz) {
        String v = stringRedisTemplate.opsForValue().get(k);
        if (isEmpty(v))
            return null;
        return StringUtils.isEmpty(v) ? null : SerializeUtil.deserialize(v.getBytes(), clazz);
    }

    public static Set<String> getKeys(String k) {
        return stringRedisTemplate.keys(k);
    }

    public static List getValues(Set<String> keys, Class clazz) {
        List<String> list = stringRedisTemplate.opsForValue().multiGet(keys);
        List res = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++){
            String s = list.get(i);
            res.add(SerializeUtil.deserialize(s.getBytes(), clazz));
        }
        return res;
    }

    private static boolean isEmpty(Object obj){
        if (obj == null)
            return true;
        String typeName = obj.getClass().getTypeName();
        if (typeName.contains("String")){
            String str = (String) obj;
            return StringUtils.isEmpty(str);
        }
        return false;
    }

    /**
     * 向redis存入数据并设置缓存时间以秒为单位
     * @param key
     * @param value
     * @param times
     */
    public static void setValue(String key, String value, int times){
        stringRedisTemplate.opsForValue().set(key,value,times,TimeUnit.SECONDS);
    }

    /**
     * 根据key获取对应的值
     * @param key
     */
    public static Object getValue(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

}
