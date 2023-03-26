package com.example.fullspringsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private  Integer studentId;
    private String studentName;
    private String studentLastName;
    private int studentAge;
}
