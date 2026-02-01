package com.suhail.learn_spring.Ai.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="users_testing")
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull

    private String name;
    private double salary;
    private int age;
    private String phNo;
    private boolean isActive;
    private String designation;
}
