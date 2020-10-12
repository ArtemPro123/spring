package com.course.amigoscourse.dao;

import com.course.amigoscourse.model.Student;

import java.util.List;
import java.util.UUID;

public interface studentdao {

    //Database Operations Methods
    //using int to return 1 or 0
    int insertNewStudent(UUID studentID, Student student);

    Student selectStudentById(UUID studentId);

    List<Student> selectAllStudents();

    int updateStudentById(UUID studentId, Student studentUpdate);

    int deleteStudentById(UUID studentId);
}
