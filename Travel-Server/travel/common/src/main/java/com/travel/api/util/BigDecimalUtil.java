package com.travel.api.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Administrator on 2018-03-09.
 */
public class BigDecimalUtil {
    /**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static String add(String value1, String value2) throws NullPointerException{
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.add(b2).toString();
    }

    /**
     * 提供精确减法运算的sub方法
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static String sub(String value1, String value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.subtract(b2).toString();
    }

    /**
     * 提供精确乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static String mul(String value1, String value2){
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).toString();
    }

    /**
     * 提供精确的除法运算方法div
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static String div(String value1, String value2, int scale) throws IllegalAccessException{
            if ("0".equals(value2)){
                return "0";
            }
            //如果精确范围小于0，抛出异常信息
            if (scale < 0){
                throw new IllegalAccessException("精确度不能小于0");
            }
            BigDecimal b1 = new BigDecimal(value1).setScale(scale, RoundingMode.HALF_DOWN);
            BigDecimal b2 = new BigDecimal(value2).setScale(scale, RoundingMode.HALF_DOWN);
            return b1.divide(b2, scale).toString();
    }

    /**
     * 提供精确的除法运算方法div返回绝对值
     * @param value1
     * @param value2
     * @param scale
     * @return
     * @throws IllegalAccessException
     */
    public static String divAbs(String value1, String value2, int scale) throws IllegalAccessException{
        try{
            if ("0".equals(value2)){
                return "0";
            }
            //如果精确范围小于0，抛出异常信息
            if (scale < 0){
                throw new IllegalAccessException("精确度不能小于0");
            }
            BigDecimal b1 = new BigDecimal(value1);
            BigDecimal b2 = new BigDecimal(value2);
            return b1.divide(b2, scale).abs().toString();
        }catch (Exception e){
            return "0";
        }
    }


    /**
     * 比较两个数的大小
     * @param num1
     * @param num2
     * @return
     */
    public static int isBig(String num1, String num2){
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        return b1.compareTo(b2);
    }

//    public static void main(String[] args) throws IllegalAccessException {
//        System.out.println(div("12.115", "1", 2));
//    }

}
