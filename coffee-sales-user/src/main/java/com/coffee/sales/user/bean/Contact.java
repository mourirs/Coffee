package com.coffee.sales.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("contact")
public class Contact {
    private Integer conId;
    private String conName;
    private String conEmail;
    private String conPhone;
    private String conMessage;
}
