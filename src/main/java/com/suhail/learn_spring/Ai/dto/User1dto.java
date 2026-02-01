package com.suhail.learn_spring.Ai.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class User1dto {
    private Long id;
    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")

    private String name;
//    @DecimalMax(value = "84848848.99")
//    @DecimalMin(value = "100000.22")
@DecimalMin(value = "10000.00", message = "Salary must be at least 10000")
@DecimalMax(value = "1000000.00", message = "Salary must not exceed 1000000")

    private double salary;
//    @Max(value = 80,message = "value cant be more than :{80}")
@Min(value = 18, message = "Age must be at least 18")
@Max(value = 60, message = "Age must not exceed 60")
    private int age;
    @NotBlank(message = "Phone number is required")
    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Phone number must be a valid 10-digit Indian number")
    private String phNo;


    private boolean isActive;
    @NotBlank(message = "Designation is required")
    private String designation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhNo() {
        return phNo;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public User1dto(Long id, String name, double salary, int age, String phNo, boolean isActive, String designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.phNo = phNo;
        this.isActive = isActive;
        this.designation = designation;
    }

    public User1dto() {
    }
}
