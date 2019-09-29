package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.repository.StudentRepository;

import java.time.LocalDate;
import java.util.Objects;
import java.util.TreeSet;

public class DepartmentServiceImpl implements DepartmentService {
    private final StudentRepository studentRepository;

    public DepartmentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student showStudent(Long id) {
        Objects.requireNonNull(id, "Invalid identification");
        return studentRepository.findById(id);
    }

    @Override
    public TreeSet<Student> showDepartmentStudents(Department department) {
        Objects.requireNonNull(department, "Invalid department");
        return studentRepository.findByDepartment(department);
    }

    @Override
    public TreeSet<Student> showDepartmentAndCourseStudents(Department department, int course) {
        Objects.requireNonNull(department, "Invalid department");
        return studentRepository.findByDepartmentAndCourse(department, course);
    }

    @Override
    public TreeSet<Student> showStudentsOlderThan(LocalDate date) {
        Objects.requireNonNull(date, "Invalid date");
        return studentRepository.findByAge(date);
    }

    @Override
    public TreeSet<Student> showGroup(String group) {
        Objects.requireNonNull(group, "Invalid group");
        return studentRepository.findByGroup(group);
    }
}
