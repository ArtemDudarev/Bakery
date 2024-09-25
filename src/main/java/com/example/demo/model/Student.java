package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.Period;


@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private LocalDate dataOfBirth;
    @Column(unique = true)
    private String email;
    private int age;

    public int getAge() {
        return Period.between(dataOfBirth, LocalDate.now()).getYears();
    }
}
