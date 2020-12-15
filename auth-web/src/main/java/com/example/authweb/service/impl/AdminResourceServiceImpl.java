package com.example.authweb.service.impl;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.core.service.impl.BaseServiceImpl;
import com.example.authweb.domain.AdminResource;
import com.example.authweb.mapper.AdminResourceMapper;
import com.example.authweb.service.AdminResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminResourceServiceImpl extends BaseServiceImpl<AdminResource, Long> implements AdminResourceService {

    @Autowired
    AdminResourceMapper mapper;

    @Override
    public BaseMapper<AdminResource, Long> getMapper() {
        return mapper;
    }

    @Override
    public List<AdminResource> findByUserId(Long userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public List<AdminResource> findByRoleId(Long roleId) {
        return mapper.findByRoleId(roleId);
    }

}
