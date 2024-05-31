package com.example.quickweb.service;

//import com.example.quickweb.model.MainRepository;

import com.example.quickweb.mapper.PersonMapper;
import com.example.quickweb.model.MainRepository;
import com.example.quickweb.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MainService {

    private final MainRepository repository;
    private final PersonMapper personMapper;

    public MainService(MainRepository repository, PersonMapper personMapper) {
        this.repository = repository;
        this.personMapper = personMapper;
    }

    private final String URL = "https://randomuser.me/api/?page=3&results=2";

    @PostConstruct
    public void fetchData() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.getForEntity(URL, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) response.getBody().get("results");
        results.stream().forEach(result -> {
            Map<String, String> name = (Map<String, String>) result.get("name");
            Map<String, Object> dob = (Map<String, Object>) result.get("dob");

            Person person = new Person();
            person.setName(name.get("first") + " " + name.get("last"));
            person.setGender(result.get("gender").toString());
            person.setAge((Integer) dob.get("age"));
            person.setEmail(result.get("email").toString());
            person.setNationality(result.get("nat").toString());

            repository.save(person);
        });
    }

    public List<PersonDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PersonDTO> findById(Long id) {
        return repository.findById(id).map(personMapper::toDto);
    }

    public PersonDTO createPerson(CreatePersonDTO createPersonDTO) {
        Person person = personMapper.toEntityFromCreateDto(createPersonDTO);
        Person savedPerson = repository.save(person);
        return personMapper.toDto(savedPerson);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
