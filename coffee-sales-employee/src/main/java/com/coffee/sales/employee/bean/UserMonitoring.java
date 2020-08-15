package com.coffee.sales.employee.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("userMonitoring")
public class UserMonitoring {
    private Integer uId;
    private String uName;
    private String uPwd;
    private String uEmail;
    private String uPhone;
    private Integer uState;
}
