package com.coffee.sales.employee.security;

import com.coffee.sales.employee.bean.Permission;
import com.coffee.sales.employee.dao.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author 863
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    private final PermissionMapper permissionMapper;

    @Autowired
    public MyInvocationSecurityMetadataSourceService(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    /**
     * 加载需要拦截的路径
     */
    private void loadResourceDefine() {
        map = new HashMap<>(15);
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<Permission> permissionURL = permissionMapper.findPermissionURL();
        for (Permission permission : permissionURL) {
            array = new ArrayList<>();
            cfg = new SecurityConfig(permission.getName());

            array.add(cfg);
            map.put(permission.getUrl(), array);
        }

    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation filterInvocation = (FilterInvocation) object;
        String fullRequestUrl = filterInvocation.getFullRequestUrl();
        if (isMatcherAllowedRequest(filterInvocation)) {
            return null;
        }
        if (map == null) {
            loadResourceDefine();
        }
        HttpServletRequest request = filterInvocation.getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    /**
     * 判断当前请求是否在允许请求的范围内
     *
     * @param fi 当前请求
     * @return 是否在范围中
     */
    private boolean isMatcherAllowedRequest(FilterInvocation fi) {
        return allowedRequest().stream().map(AntPathRequestMatcher::new)
                .filter(requestMatcher -> requestMatcher.matches(fi.getHttpRequest()))
                .toArray().length > 0;
    }

    /**
     * 不需要拦截的静态资源
     *
     * @return 定义允许请求的列表
     */
    private List<String> allowedRequest() {
        return Arrays.asList("/login", "/css/**", "/fonts/**", "/js/**", "/scss/**", "/img/**");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
