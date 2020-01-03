package com.travel.api.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.travel.api.service.MessageService;
import com.travel.api.util.JuheInterfaceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.travel.api.util.SendRequestUtils.net;

/**
 * @ClassName MessageServiceImpl
 * @Author liguangyao
 * @Date 23/8/18 下午2:49
 * @Version 1.0
 **/
@Service
public class MessageServiceImpl implements MessageService {
    private Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Value("${JUHE_APPKEY}")
    private String JUHE_APPKEY;

    @Value("${JUHE_SMS_TEMPLATE_ID}")
    private String JUHE_SMS_TEMPLATE_ID;

    @Value("${spring.mail.username}")
    private String SENDER;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    @Async
    public String sendSMS(String mobile, String code) {
        String result =null;
        Map params = new HashMap(); //请求参数
        params.put("mobile",mobile); //接收短信的手机号码
        params.put("tpl_id",JUHE_SMS_TEMPLATE_ID); //短信模板ID，请参考个人中心短信模板设置
        params.put("tpl_value","#code#=" + code); //变量名和变量值对
        params.put("key",JUHE_APPKEY); //应用APPKEY(应用详细页查询)
        params.put("dtype",""); //返回数据的格式,xml或json，默认json
        try {
            result =net(JuheInterfaceUrl.SMS_URL, params, "GET");
            JSONObject object = JSONObject.parseObject(result);
            if(object.getInteger("error_code")==0){
                logger.info("[短信发送] 信息:{}", object.get("result"));
            }else{
                logger.info("[短信发送] 信息:{}:{}",object.get("error_code"), object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Async
    public void sendEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER); //寄件人
        message.setTo(email); //收件人
        message.setSubject("Travel"); //主题
        message.setText("您的验证码是: " + code); //内容
        try {
            mailSender.send(message);
        } catch (MailException e) {
            logger.error(e.getMessage());
        }
        logger.info("[邮箱发送] 收件人:{}, 验证码:{}", email, code);
    }
}
