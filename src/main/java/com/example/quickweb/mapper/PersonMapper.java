package com.example.quickweb.mapper;

import com.example.quickweb.model.Person;
import com.example.quickweb.service.CreatePersonDTO;
import com.example.quickweb.service.Mapper;
import com.example.quickweb.service.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements Mapper<PersonDTO, Person, CreatePersonDTO> {

    @Override
    public PersonDTO toDto(Person person) {
        return   PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .gender(person.getGender())
                .age(person.getAge())
                .email(person.getEmail())
                .nationality(person.getNationality())
                .build();
    }

    @Override
    public Person toEntity(PersonDTO personDTO) {
        return   Person.builder()
                .id(personDTO.getId())
                .name(personDTO.getName())
                .gender(personDTO.getGender())
                .age(personDTO.getAge())
                .email(personDTO.getEmail())
                .nationality(personDTO.getNationality())
                .build();
    }

    @Override
    public Person toEntityFromCreateDto(CreatePersonDTO createDto) {
        Person person = new Person();
        person.setName(createDto.getName());
        person.setGender(createDto.getGender());
        person.setAge(createDto.getAge());
        person.setEmail(createDto.getEmail());
        person.setNationality(createDto.getNationality());
        return person;
    }
}
