package com.travel.api.service.fallBack;

import com.travel.api.beans.request.message.EmailRequest;
import com.travel.api.beans.request.message.SMSRequest;
import com.travel.api.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName MessageFallBack
 * @Author liguangyao
 * @Date 24/8/18 下午7:49
 * @Version 1.0
 **/
@Service("messageService")
public class MessageFallBack implements MessageService {

    @Override
    public Map<String, Object> sendSMS(String mobile) {
        return null;
    }

    @Override
    public Map<String, Object> validationSMS(SMSRequest request) {
        return null;
    }

    @Override
    public Map<String, Object> sendEmail(String email) {
        return null;
    }

    @Override
    public Map<String, Object> validationEmail(EmailRequest request) {
        return null;
    }
}
