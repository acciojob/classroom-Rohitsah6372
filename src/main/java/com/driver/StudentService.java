package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.saveTeacher(teacher);
    }

    public void createStudentTeacherPair(String student, String teacher) {
        studentRepository.saveStudentTeacherPair(student, teacher);
    }

    public Student findStudent(String student) {
        return studentRepository.findStudent(student);
    }

    public Teacher findTeacher(String teacher) {
        return studentRepository.findTeacher(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher) {
        return studentRepository.findStudentsFromTeacher(teacher);
    }

    public List<String> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public void deleteTeacher(String teacher) {
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
