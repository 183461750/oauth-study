package com.example.authweb.service.impl;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.core.service.impl.BaseServiceImpl;
import com.example.authweb.domain.AdminRole;
import com.example.authweb.domain.AdminRoleResource;
import com.example.authweb.mapper.AdminRoleMapper;
import com.example.authweb.service.AdminRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminRoleServiceImpl extends BaseServiceImpl<AdminRole, Long> implements AdminRoleService {

    @Resource
    AdminRoleMapper mapper;

    @Override
    public BaseMapper<AdminRole, Long> getMapper() {
        return mapper;
    }

    @Override
    public List<AdminRole> findByUserId(Long userId) {
        return mapper.findByUserId(userId);
    }

    @Override
    public void addRoleResources(Long roleId, List<Long> resourcesIds) {
        List<AdminRoleResource> rrs = new ArrayList<>();
        for(Long resourcesId : resourcesIds){
            AdminRoleResource rr = new AdminRoleResource();
            rr.setId((Long) idGenerator.generate());
            rr.setRoleId(roleId);
            rr.setResourceId(resourcesId);
            rrs.add(rr);
        }
        mapper.insertRoleResources(rrs);
    }

    @Override
    public void removeRoleResources(Long roleId, List<Long> resourcesIds) {
        mapper.deleteRoleResources(roleId, resourcesIds);
    }

}
