package com.coffee.sales.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("address")
public class Address {
    private Integer aId;
    private Integer uId;
    private String area;
    private String detailedArea;
    private String postalCode;
    private String consignee;
    private String consigneePhone;
}
