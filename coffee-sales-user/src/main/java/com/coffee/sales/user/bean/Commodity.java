package com.coffee.sales.user.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("commodity")
public class Commodity {
    private Integer yId;
    private String yName;
    private Integer yPrice;
    private Integer yGrounding;
    private Integer yNum;
    private Integer yTId;
    private String yimage;
}
