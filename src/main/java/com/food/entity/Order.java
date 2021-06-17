package com.food.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String customer_Name;
    private String order_Type;
    private int order_Quantity;
    private Date order_CheckIn;
    private Date order_CheckOut;
    @OneToOne
    private Seating seating;
    @OneToMany(cascade =CascadeType.ALL,
            mappedBy = "order",targetEntity = Menu.class)
    private List<Menu> menus;

}
