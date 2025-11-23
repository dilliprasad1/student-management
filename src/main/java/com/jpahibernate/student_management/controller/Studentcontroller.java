package com.jpahibernate.student_management.controller;

import com.jpahibernate.student_management.model.Student;
import com.jpahibernate.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class Studentcontroller {


    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String savestudent(@RequestBody Student student){
        String res= studentService.addStudent(student);
        return res;

    }
    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student= studentService.findStudentById(id);
        return student;


    }
    @GetMapping("/findall")
    public List<Student> findAll(){
        List <Student> studentList = studentService.findAll();
        return studentList;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteByID(@PathVariable int id){
      String res=  studentService.deleteStudentById(id);
        return res;
    }
    @PutMapping("/update/{id}")
    public String  updateStudentByPut(@PathVariable int id,@RequestBody Student studentRequest){
    String  res= studentService.updateStudentByPut(id,studentRequest);
    return res;
    }



}
