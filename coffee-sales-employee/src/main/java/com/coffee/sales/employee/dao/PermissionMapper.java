package com.coffee.sales.employee.dao;

import java.util.List;

import com.coffee.sales.employee.bean.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PermissionMapper {
   @Select({"SELECT * FROM t_permission tp WHERE tp.url = #{url}"})
   Permission findPermissionByUrl(String url);

   @Select({"select * from t_permission where url is not null and length(url) > 0"})
   List<Permission> findPermissionURL();
}
