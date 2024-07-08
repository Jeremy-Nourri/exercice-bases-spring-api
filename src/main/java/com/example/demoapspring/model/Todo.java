package com.example.demoapspring.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean isValidate;
}
