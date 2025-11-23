package com.jpahibernate.student_management.service;

import com.jpahibernate.student_management.model.Student;
import com.jpahibernate.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "saved" ;

    }

    public Student findStudentById(int id){
       Optional <Student> studentOptional= studentRepository.findById(id);
       return studentOptional.get();
    }

    public List <Student> findAll(){
     List <Student> studentList=studentRepository.findAll();
        return studentList;
    }
    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return id+ "deleted";

    }
    public String updateStudentByPut(int student_id,Student studentRequest){
        //find student wit id
        //if id present update id
        Student studentFromDb = findStudentById(student_id);
        if(studentFromDb!=null){
            studentRepository.save(studentRequest);
            return "updated";
        }else {
            return "no student found" ;
        }



    }
    public void updateStudentByPatch(){

    }


}
