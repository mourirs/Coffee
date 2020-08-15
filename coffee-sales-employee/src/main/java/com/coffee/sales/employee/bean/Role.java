package com.coffee.sales.employee.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
   private Integer id;
   private String name;
   private List<Permission> permissionList;
}
