package com.example.JPA.controller;

import com.example.JPA.Dto.StudentDto;
import com.example.JPA.model.Student;
import com.example.JPA.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentContoller {

    @Autowired
    StudentService s;

//    @GetMapping("students")
//    public List<Student>  getStudent(){
//        return s.getAllStudents();
//    }
//
//    @PostMapping("students")
//    public String addStudents(@Valid @RequestBody Student std)
//    {
//        s.addStudent(std);
//        return "Successfully added student";
//    }

//    @GetMapping("students/{rno}")
//    public Student getStudentById(@PathVariable("rno") int roll)
//    {
//        return s.getStudentById(roll);
//    }

    @PutMapping("students")
    public String updateStudent(@RequestBody Student std)
    {
        s.updateStudent(std);
        return "Successfully updated student";
    }

    @DeleteMapping("students")
    public String deleteAllStudents()
    {
        s.deleteAllStudents();
        return "Successfully deleted students";
    }

    @DeleteMapping("students/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno)
    {
        s.deleteStudentById(rno);
        return "Successfully deleted student";
    }

//    @GetMapping("students/custom")
//    public List<Student> getStudentByGenderAndTech(
//            @RequestParam("gender") String gender,
//            @RequestParam("tech") String tech
//    ){
//        return s.getAllStudentsByGenderAndTech(gender,tech);
//    }

    @GetMapping("/student/name")
    public List<Student> getStudentByName(@Param("name") String name){
        return s.getStudentByName(name);
    }

    @GetMapping("/student/tech/{tech}")
    public List<Student> getStudentByTechnology(@PathVariable String tech){
        return s.getStudentByTech(tech);
    }

    //Native Query
    @GetMapping("/student/filter")
    public List<Student> getStudentByFilter(
            @Param("gender") String gender
            , @Param("tech") String tech){
        return s.getStudentByfilter(gender,tech);
    }

    @GetMapping("/students/findPriya")
    public List<Student> getStudentBynameQuery( ){
        return s.getStudentByNameQuery();
    }

    //We validate the user's response before sending it to the controller. the values are checked for
    //missing values or invalid values and validated before storing in the db, i.e sending to controller


    @GetMapping("students/{rno}")
    public StudentDto getAllStudentByRollNo(@PathVariable("rno") int rno){
        return s.getAllStudentById(rno);
    }

    @PostMapping("students")
    public StudentDto addStudent(@Valid @RequestBody Student std)
    {
        return s.addStudent(s.convertToDto(std));
    }

    @GetMapping("students")
    public Page<Student> getAllStudent(@RequestParam int page,@RequestParam int size)
    {
        return s.getAllStudent(page,size);
    }



}
