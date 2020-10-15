package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Identifying that its a Service
@Service
public class PersonService {

    private final PersonDAO personDAO;

    //Injecting into the actual constructor
    //Use Qualifier to differentiate
    //to simply change the data source from postgres to local just change the qualifier
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    //Implementing the services available
    public int addPerson(Person person){
        return personDAO.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDAO.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDAO.selectPersonById(id);
    }

    //calling the personDAO methods
    public int deletePerson(UUID id){
        return personDAO.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDAO.updatePersonById(id, newPerson);
    }

}
