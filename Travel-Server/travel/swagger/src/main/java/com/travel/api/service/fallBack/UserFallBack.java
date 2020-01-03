package com.travel.api.service.fallBack;

import com.travel.api.beans.request.BaseRequest;
import com.travel.api.beans.request.user.LoginRequest;
import com.travel.api.beans.request.user.RegisterRequest;
import com.travel.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("userService")
public class UserFallBack implements UserService {

    @Override
    public Object list(BaseRequest request) {
        return null;
    }

    @Override
    public Map<String, Object> register(RegisterRequest request) {
        return null;
    }

    @Override
    public Map<String, Object> login(LoginRequest request) {
        return null;
    }

    @Override
    public boolean judgeToken(String token) {
        return false;
    }
}
