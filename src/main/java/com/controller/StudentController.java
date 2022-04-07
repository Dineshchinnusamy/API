package com.controller;

import com.model.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class StudentController {

    @Autowired
    StudentService studentservice;

    @GetMapping("/all")
    public List<Student> getall() {
        List list = studentservice.getall();
        return list;
    }

    @GetMapping("/get")
    public List<Student> getStudent(@RequestParam("studentId") String studentId) {
        List list = studentservice.get(studentId);
        return list;
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student) {
        studentservice.add(student);
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam("studentId") String studentId) {
        studentservice.delete(studentId);
    }

    @PutMapping("/update")
    public void update(@RequestParam("studentId") String studentId,@RequestBody Student student){
        studentservice.update(student,studentId);
    }
}
