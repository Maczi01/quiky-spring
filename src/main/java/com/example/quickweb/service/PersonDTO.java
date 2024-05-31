package com.example.quickweb.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    private String email;
    private String nationality;
}
