package com.example.demoapspring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDtoPost {
    private String title;
    private String description;
    private String date;
    private boolean isValidate;
}
