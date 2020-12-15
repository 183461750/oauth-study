package com.example.authweb.domain;


import com.example.authweb.core.entity.BaseEntity;
import com.example.authweb.domain.enums.ResourceDomainType;
import com.example.authweb.domain.enums.ResourceOperate;

public class AdminResource extends BaseEntity<Long> {

    private Long id;
    private String name;
    private ResourceDomainType domain;
    private ResourceOperate operate;
    private String code;

    public ResourceDomainType getDomain() {
        return domain;
    }

    public void setDomain(ResourceDomainType domain) {
        this.domain = domain;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public ResourceOperate getOperate() {
        return operate;
    }

    public void setOperate(ResourceOperate operate) {
        this.operate = operate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
