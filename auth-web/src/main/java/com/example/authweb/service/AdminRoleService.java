package com.example.authweb.service;

import com.example.authweb.core.service.BaseService;
import com.example.authweb.domain.AdminRole;

import java.util.List;

public interface AdminRoleService extends BaseService<AdminRole, Long> {

    List<AdminRole> findByUserId(Long userId);

    void addRoleResources(Long roleId, List<Long> resourcesIds);

    void removeRoleResources(Long roleId, List<Long> resourcesIds);

}
