package com.example.authweb.service.impl;

import com.example.authweb.domain.AdminResource;
import com.example.authweb.domain.AdminRole;
import com.example.authweb.domain.AdminUser;
import com.example.authweb.service.AdminResourceService;
import com.example.authweb.service.AdminRoleService;
import com.example.authweb.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminUserService adminUserService;

    @Autowired
    public AdminRoleService adminRoleService;

    @Autowired
    public AdminResourceService adminResourceService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminUser adminUser = adminUserService.findByUsername(username);

        adminUser = Optional.ofNullable(adminUser).orElseThrow(
                () -> new UsernameNotFoundException("用户不存在: " + username)
        );

        Set<GrantedAuthority> authorities = new HashSet<>();

        List<AdminRole> roles = adminRoleService.findByUserId(adminUser.getId());
        for (AdminRole role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        List<AdminResource> resources = adminResourceService.findByUserId(adminUser.getId());
        for (AdminResource resource : resources){
            authorities.add(new SimpleGrantedAuthority(resource.getCode()));
        }

        return new User(adminUser.getUsername(),passwordEncoder.encode(adminUser.getPassword()),authorities);
    }

}
