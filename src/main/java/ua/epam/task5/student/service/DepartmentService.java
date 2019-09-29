package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.domain.Department;

import java.time.LocalDate;
import java.util.TreeSet;

public interface DepartmentService {
    Student showStudent(Long id);

    TreeSet<Student> showDepartmentStudents(Department department);

    TreeSet<Student> showDepartmentAndCourseStudents(Department department, int course);

    TreeSet<Student> showStudentsOlderThan(LocalDate date);

    TreeSet<Student> showGroup(String group);
}
