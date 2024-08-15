package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    private final HashMap<String, Student> studentMap = new HashMap<>();
    private final HashMap<String, Teacher> teacherMap = new HashMap<>();
    private final HashMap<String, List<String>> teacherStudentMapping = new HashMap<>();

    public void saveStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String student, String teacher) {
        if (studentMap.containsKey(student) && teacherMap.containsKey(teacher)) {
            teacherStudentMapping.computeIfAbsent(teacher, k -> new ArrayList<>()).add(student);
        }
    }

    public Student findStudent(String name) {
        return studentMap.get(name);
    }

    public Teacher findTeacher(String teacher) {
        return teacherMap.get(teacher);
    }

    public List<String> findStudentsFromTeacher(String teacher) {
        return teacherStudentMapping.getOrDefault(teacher, Collections.emptyList());
    }

    public List<String> findAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher) {
        teacherStudentMapping.remove(teacher);
        teacherMap.remove(teacher);
    }

    public void deleteAllTeachers() {
        teacherStudentMapping.clear();
        teacherMap.clear();
    }
}
