package com.coffee.sales.employee.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

@Alias("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   private Integer id;
   private String loginAcct;
   private String userPassword;
   private String userName;
   private String email;
   @DateTimeFormat(
      pattern = "yyyy-MM-dd"
   )
   @JsonFormat(
      pattern = "yyyy-MM-dd"
   )
   private String createTime;
   private List<Role> roleList;
}
