package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.InMemoryStudentDAO;
import com.example.demo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImp implements StudentService{

    private  final StudentRepository studentRepository;
    private final InMemoryStudentDAO repository;

    @Override
    public List<Student> findAllStudent() {
            return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String email) {
        Student student = studentRepository.findByEmail(email);
        studentRepository.delete(student);
    }
}
