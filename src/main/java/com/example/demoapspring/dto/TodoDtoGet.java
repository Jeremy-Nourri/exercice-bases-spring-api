package com.example.demoapspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDtoGet {
    private int id;
    private String title;
    private String description;
    private LocalDate date;
    private boolean isValidate;



}
