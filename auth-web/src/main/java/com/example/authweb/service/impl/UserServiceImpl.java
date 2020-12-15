package com.example.authweb.service.impl;

import com.example.authweb.core.mapper.BaseMapper;
import com.example.authweb.core.service.impl.BaseServiceImpl;
import com.example.authweb.domain.AdminUser;
import com.example.authweb.domain.AdminUserRole;
import com.example.authweb.mapper.AdminRoleMapper;
import com.example.authweb.mapper.AdminUserMapper;
import com.example.authweb.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<AdminUser, Long> implements AdminUserService {

    @Resource
    AdminUserMapper mapper;

    @Resource
    AdminRoleMapper roleMapper;

    @Override
    public BaseMapper<AdminUser, Long> getMapper() {
        return mapper;
    }

    @Override
    public AdminUser findByUsername(String username) {
        return mapper.findByUsername(username);
    }

    @Override
    public AdminUser findByTel(String tel) {
        return mapper.findByTel(tel);
    }

    @Override
    public List<AdminUser> findByName(String name) {
        if(name==null){
            name = "";
        }
        return mapper.findByName("%" + name + "%");
    }

    @Override
    public void addUserRole(Long userId, Set<Long> roleIds) {
        List<AdminUserRole> userRoles = new ArrayList<>();
        for(Long roleId : roleIds){
            AdminUserRole ur = new AdminUserRole();
            ur.setId((Long) idGenerator.generate());
            ur.setUserId(userId);
            ur.setRoleId(roleId);
            userRoles.add(ur);
        }
        roleMapper.insertUserRoles(userRoles);
    }

    @Override
    public void updateUserRole(Long userId, Set<Long> roleIds) {
        roleMapper.deleteUserRole(userId);
        this.addUserRole(userId, roleIds);
    }

}
