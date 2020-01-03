package com.travel.api.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.*;

public class CHttpClient {

    private String UserAgent = "";

    private String token = "";

    private String auth = "";

    private Map<String,String> headers;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getUserAgent() {
        return UserAgent;
    }

    public void setUserAgent(String userAgent) {
        UserAgent = userAgent;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String get(String url) throws Exception{
        String contentStr = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(url);
            if (headers!= null){
                for (Map.Entry<String,String> entry:headers.entrySet()){
                    httpGet.setHeader(entry.getKey(),entry.getValue());
                }
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity);
                contentStr = content;
                System.out.println(content);
            }finally {
                response.close();
            }
        }finally {
            httpClient.close();
        }
        return contentStr;
    }
    //map转xml
    public static String map2Xmlstring(Map<String,String> map){
        StringBuffer sb = new StringBuffer("");
        sb.append("<xml>");

        Set<String> set = map.keySet();
        for(Iterator<String> it=set.iterator(); it.hasNext();){
            String key = it.next();
            Object value = map.get(key);
            if("attach".equalsIgnoreCase(key)||"body".equalsIgnoreCase(key)||"sign".equalsIgnoreCase(key)){
                sb.append("<"+key+">"+"<![CDATA["+value+"]]></"+key+">");
            }else{
                sb.append("<").append(key).append(">");
                sb.append(value);
                sb.append("</").append(key).append(">");
            }

        }
        sb.append("</xml>");
        System.out.println("sb.toString()++++++++++++"+sb.toString());
        return sb.toString();
    }
    public String post(String url,Map<String,String> params) throws Exception{

        String content = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        if (headers!= null){
            for (Map.Entry<String,String> entry:headers.entrySet()){
                httpPost.setHeader(entry.getKey(),entry.getValue());
            }
        }
        if (params.size() >0 ){
            List<NameValuePair> clientParams = new ArrayList<>();
            for (Map.Entry<String,String> entry : params.entrySet()){
                clientParams.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(clientParams, HTTP.UTF_8));
        }
        CloseableHttpResponse response = client.execute(httpPost);
        try {
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity,"UTF-8");
        }catch (Exception e){
            throw e;
        }finally {
            response.close();
        }
        client.close();
        return content;

    }
    public  String payPost(String url,Map<String,String> params) throws Exception{
        String xmlParam=map2Xmlstring(params);
        StringEntity myEntity = new StringEntity(xmlParam, "UTF-8");

        String content = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        if (headers!= null){
            for (Map.Entry<String,String> entry:headers.entrySet()){
                httpPost.setHeader(entry.getKey(),entry.getValue());
            }
        }
        //List<BasicNameValuePair> parameters = new ArrayList<>();
        //parameters.add(new BasicNameValuePair("xml", xmlParam));
        httpPost.setEntity(myEntity);

        CloseableHttpResponse response = client.execute(httpPost);
        try {
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity,"UTF-8");
        }catch (Exception e){
            throw e;
        }finally {
            response.close();
        }
        client.close();
        return content;

    }

    public String put(String url,HashMap<String,Object> params){
        //TODO put 方法
        return "";

    }

    public void delete(String url,HashMap<String,Object> params){
        //TODO delete 方法
    }

}
