package com.course.amigoscourse.dao;

import com.course.amigoscourse.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

//Methods from Interface Auto implemented
@Repository("fakeDAO") //creates an instance of this class to be able to inject data into it, () lets you distinguish between them
public class FakeStudentDaoImpl implements studentdao {

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {
        database = new HashMap<>();
        //manually inputting a student
        UUID studentId = UUID.randomUUID();
        database.put(studentId, new Student(studentId,"Alex","Montana", "Computer Science", 23));
    }

    @Override
    public int insertNewStudent(UUID studentID, Student student) {
        database.put(studentID, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());//values returns a collection so we need to pass it back as an arraylist
    }

    @Override
    public int updateStudentById(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
