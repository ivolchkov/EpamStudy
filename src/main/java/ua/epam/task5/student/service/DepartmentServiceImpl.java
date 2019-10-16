package ua.epam.task5.student.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.repository.StudentRepository;


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;



@Service
public class DepartmentServiceImpl implements DepartmentService {
    private static final Logger LOGGER = Logger.getLogger("file");

    private final StudentRepository studentRepository;


    @Autowired
    public DepartmentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }

    @Override
    public Student showStudent(Long id) {
        try {
            Objects.requireNonNull(id, "Invalid identification");
            return studentRepository.findById(id).get();
        } catch(NullPointerException e) {
            LOGGER.error("Invalid identification", e);
        }

        return null;
    }

    @Override
    public Student showStudentByEmail(String email) {
        try {
            Objects.requireNonNull(email, "Invalid e-mail");
            return studentRepository.findByEmail(email).get();
        } catch(NullPointerException e) {
            LOGGER.error("Invalid e-mail", e);
        }

        return null;
    }

    @Override
    public List<Student> showDepartmentStudents(Department department) {
        try {
            Objects.requireNonNull(department, "Invalid department");
            return studentRepository.findByDepartment(department);
        } catch(NullPointerException e) {
            LOGGER.error("Invalid department", e);
        }

        return Collections.emptyList();
    }

    @Override
    public List<Student> showDepartmentAndCourseStudents(Department department, int course) {
        try {
            Objects.requireNonNull(department, "Invalid department");
            return studentRepository.findByDepartmentAndCourse(department, course);

        } catch(NullPointerException e) {
            LOGGER.error("Invalid department", e);
        }

        return Collections.emptyList();
    }

    @Override
    public List<Student> showStudentsOlderThan(LocalDate date) {
        try {
            Objects.requireNonNull(date, "Invalid date");
            return studentRepository.findByAge(date);
        } catch(NullPointerException e) {
            LOGGER.error("Invalid date", e);
        }

        return Collections.emptyList();
    }

    @Override
    public List<Student> showGroup(String group) {
        try {
            Objects.requireNonNull(group, "Invalid group");
            return studentRepository.findByGroup(group);
        } catch(NullPointerException e) {
            LOGGER.error("Invalid group", e);
        }

        return Collections.emptyList();
    }
}
