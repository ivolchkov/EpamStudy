package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;

import java.util.Optional;

public interface StudentService {
    Optional<Student> register(Student student);
    Optional<Student> login(String email, String password);
}
