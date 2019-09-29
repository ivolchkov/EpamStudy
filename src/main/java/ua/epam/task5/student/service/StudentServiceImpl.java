package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.repository.StudentRepository;
import ua.epam.task5.student.service.validator.StudentValidator;
import ua.epam.task5.student.service.validator.Validator;

import java.util.Objects;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final Validator<Student> validator;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.validator = new StudentValidator();
    }

    @Override
    public Student register(Student student) {
        Objects.requireNonNull(student, "Invalid registration!");
        this.validator.validate(student);

        return studentRepository.save(student);
    }
}
