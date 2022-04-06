package com.controller;

import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/controller")
public class StudentController {
    List list= new ArrayList<Student>();
    StudentService studentservice= new StudentService();

    @GetMapping("/all")
    public List<Student> getall(){
        List list=studentservice.getall();
        return list;
    }
    @GetMapping("/get")
    public List<Student> get(@RequestParam("studentId") String studentId){
       List list= studentservice.get(studentId);
       return list;
    }

   @PostMapping("/add")
   public void add(@RequestBody Student student){
        list.add(student);
    //studentservice.add(student);
   }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam ("studentId") String studentId){
        studentservice.delete(studentId);
    }

}
