package com.example.authweb.controller;

import com.example.authweb.api.UserApi;
import com.example.authweb.api.commom.ApiResponse;
import com.example.authweb.api.vo.AuthUserInfoVo;
import com.example.authweb.domain.AdminUser;
import com.example.authweb.exception.CommonException;
import com.example.authweb.exception.UserNotExistException;
import com.example.authweb.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Fa
 * @description AdminUserController
 * @date 2020/12/15 0015 下午 04:51
 */
@RestController
@RequestMapping("/api/user")
public class AdminUserController implements UserApi {

    @Autowired
    private AdminUserService adminUserService;


    @Override
    @GetMapping("/profile")
    public ApiResponse<AuthUserInfoVo> profile(Principal principal, Authentication auth) {

        AuthUserInfoVo authUserInfoVo = new AuthUserInfoVo();

        AdminUser user = adminUserService.findByUsername(principal.getName());

        user = Optional.ofNullable(user).orElseThrow(() -> new UserNotExistException(principal.getName()));

        authUserInfoVo.setUserId(user.getId());
        authUserInfoVo.setName(user.getName());
        authUserInfoVo.setUsername(principal.getName());
        authUserInfoVo.setTel(user.getTel());
        authUserInfoVo.setLastLoginTime(user.getLastLoginTime());
        authUserInfoVo.setAvatar("https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png");
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
        Set<String> roles = new HashSet<>();
        for(GrantedAuthority grantedAuthority : authorities){
            roles.add(grantedAuthority.getAuthority());
        }
        authUserInfoVo.setRoles(roles);
        authUserInfoVo.setIntroduction("我是" + user.getName());

        return ApiResponse.sucess(authUserInfoVo);
    }

}
