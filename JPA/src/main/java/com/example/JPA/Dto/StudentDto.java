package com.example.JPA.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private int rno;
    private String name;
    private String course;
    private String gender;
    private String tech;
    private String email;


}
