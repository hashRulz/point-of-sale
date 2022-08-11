package com.springacademy.pointofsale.dto;

import com.springacademy.pointofsale.entity.enums.MeasuringUnits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private int itemId;
    private String itemName;
    private MeasuringUnits measuringUnits;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
