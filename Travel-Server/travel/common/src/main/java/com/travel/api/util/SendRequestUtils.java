package com.travel.api.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

/**
 * @ClassName 请求操作工具类
 * @Author liguangyao
 * @Date 2018/5/21 下午3:07
 * @Version 1.0
 **/
public class SendRequestUtils {

    // 公共请求体
    private static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    private static final String CONTENT_TYPR_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
    private static final String ACCEPT = "*/*";
    private static final String CONNECTION = "Keep-Alive";
    private static final String USER_AGENT = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";
    private static final String CHARSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    /**
     * HttpClient POST 请求方式
     * @param url
     * @param param
     * @return
     */
    public static String sendPostHttpClient(String url, String param){
        String result = "";
        BufferedReader in = null;
        try {
            HttpClient client = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost();
            httpPost.setURI(new URI(url));
            httpPost.addHeader("content-type",CONTENT_TYPE_APPLICATION_JSON);
            httpPost.addHeader("accept", ACCEPT);
            httpPost.addHeader("connection", CONNECTION);
            httpPost.addHeader("user-agent",USER_AGENT);
            httpPost.addHeader("charset", CHARSET);
            httpPost.setEntity(new StringEntity(param,CHARSET));
            HttpResponse httpResponse = client.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, CHARSET);
            JSONObject jsonObject = JSONObject.parseObject(result);
            result = jsonObject.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeIOFlow(null,in);
        }
        return result;
    }

    /**
     * HttpClient GET 请求方式
     * @param url
     * @return
     */
    public static String sendGetHttpClient(String url){
        String result = "";
        BufferedReader in = null;
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet();
            httpGet.setURI(new URI(url));
            httpGet.setHeader("content-type",CONTENT_TYPE_APPLICATION_JSON);
            httpGet.setHeader("accept", ACCEPT);
            httpGet.setHeader("connection", CONNECTION);
            httpGet.setHeader("user-agent",USER_AGENT);
            httpGet.setHeader("charset", CHARSET);
            HttpResponse httpResponse = client.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            result = EntityUtils.toString(entity, CHARSET);
            JSONObject jsonObject = JSONObject.parseObject(result);
            result = jsonObject.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeIOFlow(null,in);
        }
        return result;
    }

    private static void closeIOFlow(PrintWriter printWriter,BufferedReader bufferedReader){
        try {
            if(printWriter != null){
                printWriter.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 原生请求
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  网络请求字符串
     * @throws Exception
     */
    public static String net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET");
            }else{
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, CHARSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
