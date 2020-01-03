package com.travel.api.util;

import com.travel.api.entity.ResultConstant;
import com.travel.api.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtil {
    static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * 请求成功后的返回
     * @return
     */
    public static Map<String, Object> getSuccessResult(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ResultConstant.SUCCESS_RESULT_CODE);
        map.put("message", "操作成功");
        return map;
    }

    /**
     * 请求成功后的返回
     * @return
     */
    public static Map<String, Object> getSuccessResult(String message, Object data){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ResultConstant.SUCCESS_RESULT_CODE);
        map.put("message", StringUtils.isEmpty(message) ? "操作成功" : message);
        map.put("data", data);
        return map;
    }

    /**
     * 请求失败后的返回
     * @return
     */
    public static Map<String, Object> getFailResult(String message){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", ResultConstant.FAIL_RESULT_CODE);
        map.put("message", StringUtils.isEmpty(message) ? "操作失败" : message);
        return map;
    }

    public static Map<String, Object> getFailResult(int code, String message){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", code);
        map.put("message", StringUtils.isEmpty(message) ? "操作失败" : message);
        return map;
    }

    public static Map<String,Object> getFailResultWithCodeMsg(Integer code,String message){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code == null ? ResultConstant.FAIL_RESULT_CODE:code);
        map.put("message",StringUtils.isEmpty(message)?"操作失败":message);
        return map;
    }

    /**
     * 降级处理后的返回
     * @return
     */
    public static Map<String, Object> getFallBackResult(String msg){
        return getFailResult(msg);
    }

    /**
     * 生成主键
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }


    /**
     * mysql like 格式化
     * @param keyword
     * @return
     */
    public static String likeFormat(String keyword){
        return "%" + keyword + "%";
    }

    /**
     * 生成一个N位的随机数
     */
    public static int randomNo(int size){
        double d = Math.pow(10, size);
        int num = (int) (Math.random() * d);
        int a = (int) Math.pow(10, size - 1);
        if (num < a){
            num += a;
        }
        return num;
    }

    /**
     * 获取当前时间的数字形式
     * @return
     */
    public static String getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    public static  String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 时间毫秒值相减  date - date1
     * @param date
     * @param date1
     * @return
     */
    public static long cutDate(long date, long date1){
        return (date - date1) / (1000 * 3600 * 24);
    }

    /**
     * 当前时间，时间格式为yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static List<String> split(String ids){
        return Arrays.asList(ids.split(","));
    }

    public static List<String> splitWithOutBlankAndNull(String ids){
        List<String> array = new ArrayList<>();
        String[] theIds = ids.split(",");
        for (String id:theIds){
            if (!id.equals("null")&&!id.equals("")){
                array.add(id);
            }
        }
        return array;
    }

    /**
     * 将o1边对象的非null值复制到o2
     * @param o1
     * @param o2
     */
    public static void copyValue(Object o1, Object o2){
        Class c1 = o1.getClass();
        Class c2 = o2.getClass();
        Field[] fields = c2.getDeclaredFields();
        for (Field f2 : fields) {
            f2.setAccessible(true);
            String name = f2.getName();
            try {
                Field f1 = c1.getDeclaredField(name);
                f1.setAccessible(true);
                if (f2.getType().equals(f1.getType())) {
                    Object obj = f1.get(o1);
                    if (obj != null && !"".equals(obj.toString())){
                        f2.set(o2, obj);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * 将o1对象字段复制到o2为空的字段,o2对象字段不为空则不复制
     * @param o1
     * @param o2
     */
    public static void copyIsNullValue(Object o1, Object o2){
        Class c1 = o1.getClass();
        Class c2 = o2.getClass();
        Field[] fields = c2.getDeclaredFields();
        for (Field f2 : fields) {
            f2.setAccessible(true);
            String name = f2.getName();
            try {
                Field f1 = c1.getDeclaredField(name);
                f1.setAccessible(true);
                if (f2.getType().equals(f1.getType())) {
                    Object o = f2.get(o2);
                    if(o !=null && !"".equals(o.toString())){//如果o2对象属性值不为空则跳过
                        continue;
                    }
                    Object obj = f1.get(o1);
                    if (obj != null && !"".equals(obj.toString())){
                        f2.set(o2, obj);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * 判断对象里面有没有空的属性
     * @param object
     * @return
     */
    public static boolean hasEmpty(Object object) throws IllegalAccessException {
        Class claxx = object.getClass();
        Field[] fields = claxx.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            Object value = field.get(object);
            if (value == null || "".equals(value)){
                log.info("==================:字段" + field.getName() + "为空=======================");
                return true;
            }
        }
        return false;
    }

    /**
     * md5加密
     * @param plainText
     * @return
     */
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    /**
     * 数字转大写
     * @param num
     * @return
     */
    public static String numberReturnUp(int num){
        String mark[] = new String[] {"","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟","万"};
        String numCn[] = new String[] {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

        char[] numArrRev = String.valueOf(num).toCharArray();

        StringBuffer container = new StringBuffer();
        for (int i = 0; i < numArrRev.length; i++) {
            Integer val = Integer.valueOf(String.valueOf(numArrRev[i]));
            String number = numCn[ val ];
            int x  = numArrRev.length -i -1;
            String sign =  mark[x];

            if( val == 0) {
                if( x % 4 !=0){// 删除单位
                    sign = "";
                }
                if(i < numArrRev.length-1){
                    Integer val1 = Integer.parseInt(String.valueOf(numArrRev[i+1]));
                    if( val==0 && val==val1 ){
                        number = "";
                    }else if ( val == 0 && ("万".equals(sign) || "亿".equals(sign))) {
                        number = "";
                    }
                }else if(i == numArrRev.length-1){
                    number = "";
                }
            }

            container.append(number + sign);
        }
        return container.toString() + "元";
    }

    /**
     *
     * @param index 是第几个文件
     * @param applicationFormId 订单ID
     * @param attachCategoryId  附件种类的ID
     * @return
     */
    public static String getImgId(String index, String applicationFormId, String attachCategoryId, String customerLenderId){
        if (StringUtils.isEmpty(index)) {
            index = "1";
        }
        String key = "";
        if (!StringUtils.isEmpty(applicationFormId))
            key += applicationFormId;
        if (!StringUtils.isEmpty(attachCategoryId))
            key += attachCategoryId;
        if (!StringUtils.isEmpty(customerLenderId))
            key += customerLenderId;
        return CommonUtil.md5(key + index);
    }

    public static String getImgId(String index, String key){
        if (StringUtils.isEmpty(index)) {
            index = "1";
        }
        return CommonUtil.md5(key + index);
    }

    /**
     * 生成随机字符串
     * @param length
     * @return
     */
    public static String randStr(Integer length){
        String Chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            buf.append(Chars.charAt(num));
        }
        return buf.toString();
    }

    /**
     * 通过随机值加密密码
     * @param pwd
     * @return
     * @throws Exception
     */
    public static String encryptPwd(String pwd) throws BaseException {
        try {

            String salt = randStr(4);
            String strToEncrypt = pwd + salt;
            String encryptedStr = md5(strToEncrypt);
            return encryptedStr+salt;
        }catch (Exception e){
            throw new BaseException(e);
        }
    }

    /**
     * 通过字符串和盐值加密密码
     * @param pwd
     * @param salt
     * @return
     * @throws Exception
     */
    public static String encryptPwd(String pwd,String salt) throws Exception {
        try {
            String strToEncrypt = pwd + salt;
            String encryptedStr = md5(strToEncrypt);
            return encryptedStr + salt;
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    /**
     * 获取当天
     * @return
     */
    public static String today(){
        String temp_str="";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        temp_str=sdf.format(dt);
        return temp_str;
    }


    public static Integer getPageNumBy(Long total,Integer pagesize){
        if (pagesize == 0 ){
            return -1;
        }
        Integer totalNum = total.intValue();
        Integer page = totalNum / pagesize;
        if ((totalNum%pagesize)>0){
            page += 1;
        }
        return page;
    }
}
