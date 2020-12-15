package com.example.authweb.service;

import com.example.authweb.core.service.BaseService;
import com.example.authweb.domain.AdminUser;

import java.util.List;
import java.util.Set;

/**
 * @author Fa
 * @description UserService
 * @date 2020/12/15 0015 上午 11:41
 */
public interface AdminUserService extends BaseService<AdminUser, Long> {

    AdminUser findByUsername(String username);

    List<AdminUser> findByName(String name);

    AdminUser findByTel(String tel);

    void addUserRole(Long userId, Set<Long> roleIds);

    void updateUserRole(Long userId, Set<Long> roleIds);

}
