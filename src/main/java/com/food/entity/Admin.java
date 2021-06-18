package com.food.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String password;
    private String email;
    private long phone;
    private String role;
    @OneToMany(cascade =CascadeType.ALL,mappedBy = "admin",targetEntity = Seating.class)
    private List<Seating> seatings = new ArrayList<>();





}
