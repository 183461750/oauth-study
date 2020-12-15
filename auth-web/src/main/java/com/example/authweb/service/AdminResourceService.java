package com.example.authweb.service;

import com.example.authweb.core.service.BaseService;
import com.example.authweb.domain.AdminResource;

import java.util.List;

public interface AdminResourceService extends BaseService<AdminResource, Long> {

    List<AdminResource> findByUserId(Long userId);

    List<AdminResource> findByRoleId(Long roleId);

}
