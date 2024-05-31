package com.example.quickweb.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonDTO {
        private String name;
        private String gender;
        private Integer age;
        private String email;
        private String nationality;
}
