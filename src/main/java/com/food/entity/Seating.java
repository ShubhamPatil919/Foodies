package com.food.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int table_Id;
    private String table_Name;
    private Boolean status;
    @ManyToOne
    private Admin admin;
    @OneToOne
    private Order order;
}
