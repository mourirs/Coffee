package com.coffee.sales.employee.security;

import com.coffee.sales.employee.bean.Permission;
import com.coffee.sales.employee.bean.Role;
import com.coffee.sales.employee.bean.User;
import com.coffee.sales.employee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userRoleInfo = userService.getUserRoleInfo(s);
        org.springframework.security.core.userdetails.User user;
        if (userRoleInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        } else {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role : userRoleInfo.getRoleList()) {
                for (Permission permission : userService.findRolePermissionById(role.getId()).getPermissionList()) {
                    authorities.add(new SimpleGrantedAuthority(permission.getName()));
                }
            }
            user = new org.springframework.security.core.userdetails.User(userRoleInfo.getLoginAcct(), userRoleInfo.getUserPassword(), authorities);
        }
        return user;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
