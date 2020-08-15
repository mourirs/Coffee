package com.coffee.sales.employee.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailServiceImpl userDetailService;

    @Autowired
    public MyAuthenticationProvider(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean flag = bCryptPasswordEncoder.matches(password, userDetails.getPassword());
        if (flag){
            return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
