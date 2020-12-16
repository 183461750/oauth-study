package com.example.authweb.config;

import com.alibaba.fastjson.JSON;
import com.example.authweb.api.commom.ApiResponse;
import com.example.authweb.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;
import java.io.IOException;

@Slf4j
@Configuration
@EnableResourceServer
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private TokenStore tokenStore;

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        return defaultTokenServices;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer config) {
        config.tokenServices(tokenServices());
        config.accessDeniedHandler((request, response, accessDeniedException) -> {
            response.setStatus(HttpStatus.OK.value());
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            try {
                CommonException ce = new CommonException(50003, accessDeniedException.getMessage());
                log.debug(accessDeniedException.getMessage(), accessDeniedException);
                response.getWriter().write(JSON.toJSONString(ApiResponse.fail(ce)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        config.authenticationEntryPoint((request, response, authException) -> {
            response.setStatus(HttpStatus.OK.value());
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            try {
                CommonException ce = new CommonException(50003, authException.getMessage());
                log.debug(authException.getMessage(), authException);
                response.getWriter().write(
                        JSON.toJSONString(ApiResponse.fail(ce))
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/api/**").and()
                .authorizeRequests()
                .antMatchers("/api/user/profile").authenticated()
//                .antMatchers(HttpMethod.DELETE, "/oauth/revoke_token").authenticated()
                .antMatchers("/api/**").access("#oauth2.hasScope('AUTH')");
    }

}