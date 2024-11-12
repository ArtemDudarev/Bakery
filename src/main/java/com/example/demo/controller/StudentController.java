package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final StudentService service;


//    @RequestMapping
//    public List<Student> findAllStudent(Model model){
//        return service.findAllStudent();
//    }

    @GetMapping
    public String findAllStudent(Model model) {
        List<Student> students = service.findAllStudent();
        model.addAttribute("students", students);
        return "index";
    }


    @PostMapping("save_student")
    public Student saveStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void  deleteStudent(@PathVariable String email){
        service.deleteStudent(email);
    }
}
