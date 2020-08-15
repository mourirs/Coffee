package com.coffee.sales.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("commodityType")
public class CommodityType {
    private Integer yTId;
    private String yType;
}
