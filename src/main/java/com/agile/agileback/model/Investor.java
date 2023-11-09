package com.agile.agileback.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "investors")
@Getter
@Setter
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "age")
    private String age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "capital")
    private Double capital;

}