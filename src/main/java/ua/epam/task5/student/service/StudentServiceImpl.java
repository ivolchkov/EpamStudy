package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private Validator validator;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student register(Student student) {
        if (student == null) {
            throw new IllegalArgumentException();
        }
        return studentRepository.save(student);
    }
}
