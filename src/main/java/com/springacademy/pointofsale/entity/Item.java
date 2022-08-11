package com.springacademy.pointofsale.entity;

import com.springacademy.pointofsale.entity.enums.MeasuringUnits;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "item")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", length = 45)
    private int itemId;

    @Column(name = "item_name", length = 100 , nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_units", length = 100 , nullable = false)
    private MeasuringUnits measuringUnits;

    @Column(name = "balance_qty", length = 100 , nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", length = 100 , nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 100 , nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;


}
