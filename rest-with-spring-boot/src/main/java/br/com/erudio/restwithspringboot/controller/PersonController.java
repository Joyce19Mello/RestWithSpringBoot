package br.com.erudio.restwithspringboot.controller;

import br.com.erudio.restwithspringboot.model.Person;
import br.com.erudio.restwithspringboot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll()  {
        return service.findAll();
    }

    @RequestMapping(value="/{id}",
            method=RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id)  {
        return service.findById(id);
    }

    @PostMapping()
    public Person create(@RequestBody Person person)  {
        return service.create(person);
    }

}