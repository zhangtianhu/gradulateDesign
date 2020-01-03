package com.travel.api.util;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by Administrator on 2018-05-16.
 */
public class ClassInitUtil {

    public static void createInit(Object object, String userId){
        Class<?> claxx = object.getClass();
        try {
            Field field = claxx.getDeclaredField("createDate");
            field.setAccessible(true);
            field.set(object, new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Field field = claxx.getDeclaredField("id");
            field.setAccessible(true);
            field.set(object, CommonUtil.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Field field = claxx.getDeclaredField("createBy");
            field.setAccessible(true);
            field.set(object, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateInit(Object object, String userId){
        Class<?> claxx = object.getClass();
        try {
            Field field = claxx.getDeclaredField("updateDate");
            field.setAccessible(true);
            field.set(object, new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Field field = claxx.getDeclaredField("updateBy");
            field.setAccessible(true);
            field.set(object, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
