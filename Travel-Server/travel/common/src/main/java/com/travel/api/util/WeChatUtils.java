package com.travel.api.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.net.URI;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.*;

public class WeChatUtils {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 微信登录是从小程序或者相关页面获取code，然后将code发送到后端
     * 后端通过固定的接口访问微信服务器，再通过微信服务器返回的数据来获取openid来进行定位的。
     */

    // 微信appid
    private String appid;
    // 微信appsecret
    private String appSecret;

    public WeChatUtils() {
        // 空构造方法
    }

    // 如果你需要获取微信的openid等，你需要使用这个构建类来构建。
    public WeChatUtils(String appid, String appSecret) {
        // 带参数的构造方法 ，最好建议使用该方法构造，因为下面的都需要用到APPID和APPKEY
        this.appid = appid;
        this.appSecret = appSecret;
    }


    /**
     * 获取微信的Session_key
     *
     * @param code
     * @return
     */
    public String getWxUserSessionKey(String code) {
        String result = "";
        BufferedReader in = null;
        if (code.contains("code=")) {
            code = code.replace("code=", "");
        }
        String DestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=" + this.appid + "&secret=" + this.appSecret + "&js_code=" + code + "&grant_type=authorization_code";
        try {
            CHttpClient cHttpClient = new CHttpClient();
            result = cHttpClient.get(DestUrl);
        } catch (Exception e) {
            logger.error("微信登录接口失败");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取微信access_token
     *
     * @return
     */
    public Map<String, Object> getWxAccessToken() {
        Map<String, Object> ans = new HashMap<>();
        String DestUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + this.appid + "&secret=" + this.appSecret;
        try {
            CHttpClient cHttpClient = new CHttpClient();
            String result = cHttpClient.get(DestUrl);
            ans = JSON.parseObject(result, Map.class);
        } catch (Exception e) {
            logger.error("获取微信access_token失败");
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return ans;
    }

    public static String getQRCodeScanUrl(String redirectUrl, String appid) throws Exception {
        String encodedTargetUrl = URLEncoder.encode(redirectUrl, "UTF-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + encodedTargetUrl + "&response_type=code&scope=snsapi_base&state=1&connect_redirect=1#wechat_redirect";
        return URLEncoder.encode(url, "UTF-8");
    }


    /**
     * 微信服务器验证方法
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param token
     * @return
     */
    public static boolean checkFromWxServer(String signature, String timestamp, String nonce, String token) {
        String[] arr = new String[]{token, timestamp, nonce};
        // 将token、timestamp、nonce三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        content = null;
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }


    /**
     * post请求HttpClient方式
     *
     * @param url
     * @param param
     * @return
     */
    private static String sendPostHttpClient(String url, Map<String, String> param) throws Exception {
        String result = "";
        BufferedReader in = null;
        List<BasicNameValuePair> req = new ArrayList<>(param.size());
        for (Map.Entry<String, String> map : param.entrySet()) {
            String key = map.getKey();
            String value = map.getValue();
            BasicNameValuePair valuePair = new BasicNameValuePair(key, value);
            req.add(valuePair);
        }
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost();
            httpPost.setURI(new URI(url));

            // 打开和URL之间的连接
//            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            //httpPost.addHeader("authorization" ,tokenType + " " + token);
            httpPost.addHeader("content-type", "application/json");
            httpPost.addHeader("accept", "*/*");
            httpPost.addHeader("connection", "Keep-Alive");
            httpPost.addHeader("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            httpPost.addHeader("charset", "utf-8");
            httpPost.setEntity(new UrlEncodedFormEntity(req, HTTP.UTF_8));
            // 建立实际的连接
            HttpResponse httpResponse = client.execute(httpPost);
            // 获取返回的数据
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            JSONObject jsonObject = JSONObject.parseObject(result);
            result = jsonObject.toJSONString();
        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            throw e;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static String praseXml(Document doc, String name) {

        Element root = doc.getRootElement();
        Element returnData = root.element(name);//获取子节点
        return returnData.getText();
    }

    public static Map xMLParse(String strxml) throws Exception {
        if (null == strxml || "".equals(strxml)) {
            return null;
        }
        Map map = new HashMap();
        Document document = (Document) DocumentHelper.parseText(strxml);
        List list = document.getRootElement().elements();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Element elememt = (Element) it.next();
            String key = elememt.getName();
            String value = "";
            List children = elememt.elements();
            if (children.isEmpty()) {
                value = elememt.getText();
            } else {

            }

            map.put(key, value);
        }
        //关闭流
        return map;
    }
}
