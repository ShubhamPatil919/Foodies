package com.food.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int menu_Id;
    private String menu_Name;
    private String menu_Category;
    private Double menu_price;
    @ManyToOne
    private Order order;

}
