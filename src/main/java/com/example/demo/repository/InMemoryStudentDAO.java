package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryStudentDAO {
    private final List<Student> STUDENTS = new ArrayList<>();


    public List<Student> findAllStudent() {
        return STUDENTS;
    }

    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student findBiEmail(String email) {
        return STUDENTS.stream()
                .filter(x -> x.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        STUDENTS.stream()
                .filter(student1 -> student1.getEmail().equals(student.getEmail()))
                .findFirst()
                .ifPresent(x -> {
                    x.setName(student.getName());
                    x.setLastname(student.getLastname());
                    x.setDataOfBirth(student.getDataOfBirth());
                    x.setEmail(student.getEmail());
                    x.setAge(student.getAge());
                });

        return student;
    }

    public void deleteStudent(String email) {
        var student = findBiEmail(email);
        if(student != null){
            STUDENTS.remove(student);
        }
    }
}
