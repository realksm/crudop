package com.lect09.crudop;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

public class Employee {
    /*
    * To have constraints on different attributes
    * we can either manually code it or use annotations like..
    * @NotNull, @Min(), @Max(), @Email
    * */

    @NotNull
    private Integer id;
    private String name;
    private String designation;
    @Min(20)
    private Integer age;
    @Email
    private String email;
    private String gender;

    public Employee() {

    }

    public Employee(Integer id, String name, String designation, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}