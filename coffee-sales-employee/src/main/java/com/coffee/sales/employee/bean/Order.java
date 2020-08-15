package com.coffee.sales.employee.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderNumber;
    private String orderCreateTime;
    private String orderGold;
    private String orderConsignee;
    private String orderArea;
    private String orderUserName;
}
