package com.course.amigoscourse.service;

import com.course.amigoscourse.dao.studentdao;
import com.course.amigoscourse.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final studentdao studentDao;

    @Autowired //links with @Repository
    public StudentService(@Qualifier("fakeDAO") studentdao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID studentID, Student student){
        UUID studentUid = studentID == null ? UUID.randomUUID() : studentID;//if id not present then we generate our own
        return studentDao.insertNewStudent(studentID, student);
    }

    public Student getStudentById(UUID studentId){
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID studentId, Student studentUpdate){
        return studentDao.updateStudentById(studentId, studentUpdate);
    }

    public int deleteStudentById(UUID studentId){
        Student student = getStudentById(studentId);
        return studentDao.deleteStudentById(studentId);
    }

}
