package com.vaccine.register.controller;

import com.vaccine.register.dto.PersonDto;
import com.vaccine.register.mapper.MapStructMapper;
import com.vaccine.register.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonService personService;

    private final MapStructMapper mapStructMapper;

    @GetMapping("/persons")
    public List<PersonDto> getPersons() {
        return mapStructMapper.personToPersonDto(personService.getPersons());
    }

    @GetMapping("/person")
    public PersonDto getPerson(@PathVariable Long id) {
        return mapStructMapper.personToPersonDto(personService.getPerson(id));
    }

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto savePerson(@RequestBody PersonDto person) {
        return mapStructMapper.personToPersonDto(
                personService.savePerson(mapStructMapper.personDtoToPerson(person)));
    }

    @DeleteMapping("person")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
