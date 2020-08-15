package com.coffee.sales.user.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("order")
public class Order {
    private Integer oId;
    private Integer uId;
    private String oNumber;
    private String oCrateTime;
    private Integer oGold;
    private Integer oTransaction;
    private Integer aId;
    private String oName;
    private Integer oPrice;
    private Integer oNUm;
    private Address address;

    public Order(Integer uId, String oNumber, String oCrateTime, Integer oGold, Integer oTransaction, Integer aId, String oName, Integer oPrice, Integer oNUm) {
        this.uId = uId;
        this.oNumber = oNumber;
        this.oCrateTime = oCrateTime;
        this.oGold = oGold;
        this.oTransaction = oTransaction;
        this.aId = aId;
        this.oName = oName;
        this.oPrice = oPrice;
        this.oNUm = oNUm;
    }
}
