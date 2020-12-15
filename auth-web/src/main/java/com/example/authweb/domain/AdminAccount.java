package com.example.authweb.domain;

import com.example.authweb.core.entity.BaseEntity;
import com.example.authweb.domain.enums.AccountType;

import java.util.Date;

public class AdminAccount extends BaseEntity<Long> {

    private Long id;
    private AdminUser adminUser;
    private AccountType type;
    private String openid;
    private String accessToken;
    private String refreshToken;
    private Date expireTime;
    private Date createTime;
    private Date lastLoginTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public AdminUser getUser() {
        return adminUser;
    }

    public void setUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }
}
