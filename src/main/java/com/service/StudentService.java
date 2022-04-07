package com.service;

import com.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService {

    List list = new ArrayList<Student>();

    public void add(Student student) {
        list.add(student);
    }

    public List<Student> getall() {
        return list;
    }

    public List<Student> get(String stuId) {
        List list1 = new ArrayList<Student>();
        for (int i = 0; i < list.size(); i++) {
            Student student = (Student) list.get(i);
            String string = student.getStudentId();
            if (stuId.equals(string)) {
                list1.add(student);
            }
        }
        return list1;
    }

    public void delete(String studentId) {
        for (int i = 0; i < list.size(); i++) {
            Student student = (Student) list.get(i);
            String string = student.getStudentId();
            if (studentId.equals(string)) {
                list.remove(student);
            }
        }
    }

    public void update(Student newStudent, String studentId) {
        for (int i = 0; i < list.size(); i++) {
            Student oldStudent = (Student) list.get(i);
            String string = oldStudent.getStudentId();
            if (studentId.equals(string)) {
                list.remove(oldStudent);
                list.add(newStudent);
            }
        }
    }

    public void alter(String StudentId, Student newStudent) {
        for (int i = 0; i < list.size(); i++) {
            Student oldStudent = (Student) list.get(i);
            String string = oldStudent.getStudentId();
            if (StudentId.equals(string)) {
                String studentId,studentName,studentAddress;
                if ( newStudent.getStudentId().equals("") ) {
                    studentId= oldStudent.getStudentId();
                } else {
                    studentId= newStudent.getStudentId();
                }
                if ( newStudent.getStudentName().equals("")) {
                    studentName=oldStudent.getStudentName();
                } else {
                    studentName=newStudent.getStudentName();
                }
                if ( newStudent.getStudentAddress().equals("")) {
                    studentAddress=oldStudent.getStudentAddress();
                } else {
                    studentAddress=newStudent.getStudentAddress();
                }
                Student student= new Student(studentId,studentName,studentAddress);
                list.remove(oldStudent);
                list.add(student);
            }
        }
    }
}
