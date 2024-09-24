package com.example.demo.Model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class Student {
    private String name;
    private String lastname;
    private LocalDate dataOfBirth;
    @NonNull
    private String email;
    private int age;

}
