package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.view.domainFront.StudentFront;

import java.util.Optional;

public interface StudentService {
    Student register(StudentFront student);
    Student login(String email, String password);
}
