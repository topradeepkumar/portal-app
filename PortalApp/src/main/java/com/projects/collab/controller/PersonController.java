package com.projects.collab.controller;

import com.projects.collab.dal.PersonRepository;
import com.projects.collab.entity.Person;
import com.projects.collab.pojo.PersonData;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping(path="/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestBody PersonData data) {

        Person person = new Person();
        if(Objects.nonNull(data.getPersonId()) && data.getPersonId() > 0){
            person.setPersonid(data.getPersonId());
        }
        person.setFirstname(data.getFirstname());
        person.setLastname(data.getLastname());
        person.setCity(data.getCity());
        person.setPincode(data.getPincode());
        personRepository.save(person);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Person> getAllUsers() {
        // This returns a JSON or XML with the users
        return personRepository.findAll();
    }
}
