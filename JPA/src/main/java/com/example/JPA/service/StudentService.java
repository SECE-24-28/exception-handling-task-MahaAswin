package com.example.JPA.service;

import com.example.JPA.Dto.StudentDto;
import com.example.JPA.model.Student;
import com.example.JPA.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    Repo r;
//    public List<Student> getAllStudents() {
//        return r.findAll();
//    }
//
//    public void addStudent(Student std)
//    {
//        r.save(std);
//    }
//
//    public Student getStudentById(int roll) {
//        return r.findById(roll).orElse(new Student());
//    }


    public void updateStudent(Student std) {
        r.save(std); //checks if std is exist in db. if so,it updates. else, it creates a new object
    }

    public void deleteAllStudents() {
        r.deleteAll();
    }

    public void deleteStudentById(int rno) {
        r.deleteById(rno);
    }

//    public List<Student> getAllStudentsByGenderAndTech(String gender, String tech) {
//        return r.getCustom(gender,tech);
//
//    }

    public List<Student> getStudentByName(String name) {
        return r.findByName(name);
    }

    public List<Student> getStudentByTech(String tech) {
        return r.findByTech(tech);
    }

    public List<Student> getStudentByfilter(String gender, String tech) {
        return r.findByFilterStudent(gender,tech);
    }

    public List<Student> getStudentByNameQuery() {
        return r.findByPriya();
    }

    public StudentDto getAllStudentById(int rno)
    {
        Student s1=r.findById(rno).orElseThrow();
        return convertToDto(s1);
    }
    //we need a method to convert s1 to dto
    public StudentDto convertToDto(Student s1)
    {
        StudentDto std=new StudentDto();
        std.setRno(s1.getRno());
        std.setName(s1.getName());
        std.setTech(s1.getTech());
        std.setEmail(s1.getEmail());
        return std;
    }

    public StudentDto addStudent(StudentDto std)
    {
        Student student= r.save(convertDtoToStudent(std));
        return convertToDto(student);
    }
    public Student convertDtoToStudent(StudentDto std)
    {
        Student s2=new Student();
        s2.setRno(std.getRno());
        s2.setName(std.getName());
        s2.setGender(std.getGender());
        s2.setTech(std.getTech());
        s2.setEmail(std.getEmail());
        return s2;
    }

    public Page<Student> getAllStudent(int page, int size)
    {
        return r.findAll(PageRequest.of(page,size));
    }

}
