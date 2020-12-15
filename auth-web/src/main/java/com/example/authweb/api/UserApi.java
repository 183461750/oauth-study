package com.example.authweb.api;

import com.example.authweb.api.commom.ApiResponse;
import com.example.authweb.api.commom.PageVo;
import com.example.authweb.api.dto.UserDto;
import com.example.authweb.api.vo.AuthUserInfoVo;
import com.example.authweb.api.vo.UserVo;
import com.example.authweb.exception.CommonException;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;

import java.security.Principal;

public interface UserApi {

    ApiResponse<AuthUserInfoVo> profile(Principal principal, Authentication auth);

}
