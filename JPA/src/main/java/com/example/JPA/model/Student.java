package com.example.JPA.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
//    @GeneratedValue  //used to auto-generate values
    private int rno;
    @NotBlank(message="Name not valid")
    private String name;
    private String course;
    private String gender;
    private String tech;
    private String email;
    private String password;
}
