package com.coffee.sales.employee.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("permission")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
   private Integer id;
   private Integer pid;
   private String name;
   private String icon;
   private String url;
}
