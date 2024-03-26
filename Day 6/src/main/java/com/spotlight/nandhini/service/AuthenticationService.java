package com.spotlight.nandhini.service;

import com.spotlight.nandhini.dto.Request.ForgetPasswordRequest;
import com.spotlight.nandhini.dto.Request.LoginRequest;
import com.spotlight.nandhini.dto.Request.RegisterRequest;
import com.spotlight.nandhini.dto.Response.BasicResponse;
import com.spotlight.nandhini.dto.Response.LoginResponse;

public interface AuthenticationService {
    
    BasicResponse<String> register(RegisterRequest registerRequest);

    BasicResponse<LoginResponse> login(LoginRequest loginRequest);

    BasicResponse<String> forgotPassword(ForgetPasswordRequest forgetPasswordRequest);

}