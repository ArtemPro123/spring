package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Need to add this to instantiate the class to be able to inject it
//Adding "fakeDAO" allows you to have multiple implementations
@Repository("fakeDAO")
public class FakePersonDataAccessService implements PersonDAO {

    //List of Persons
    private static List<Person> DB = new ArrayList<>();

    //Following methods are implemented from the PersonDAO
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));//Adding new person to the database
        return 1;//returning 1 to check that te insertion worked
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()//using java streams to push the data
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    //To delete, first need to get person by id
    //if person exists then remove from DB
    @Override
    public int deletePersonById(UUID id) {
        Optional<Person>personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    //Update person using Java streams
    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id)
                .map(person -> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if(indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
