package com.example.demo.Controller;

import com.example.demo.Model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    public List<Student> findAllStudent(){
        return List.of(
                Student.builder().
        );
    }
}
