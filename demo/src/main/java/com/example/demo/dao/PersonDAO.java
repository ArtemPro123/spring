package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//This shows the operations allowed
//here use database injection to switch between operations
public interface PersonDAO {

    int insertPerson(UUID id, Person person);//Inserting ID manually

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();//randomly generated ID
        return insertPerson(id, person);
    }

    //Methods for interacting with the data
    List<Person> selectAllPeople();

    Optional<Person>selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
