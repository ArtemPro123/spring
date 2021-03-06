package com.course.amigoscourse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

//Model of a Student
public class Student {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String course;
    private final Integer age;

    public Student(
            @JsonProperty("id") UUID id,
            @JsonProperty("firstname") String firstName,
            @JsonProperty("lastname") String lastName,
            @JsonProperty("course") String course,
            @JsonProperty("age") Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public Integer getAge() {
        return age;
    }
}
