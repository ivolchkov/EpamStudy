package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.domain.Department;


import java.time.LocalDate;
import java.util.List;


public interface DepartmentService {
    Student showStudent(Long id);

    Student showStudentByEmail(String email);

    List<Student> showDepartmentStudents(Department department);

    List<Student> showDepartmentAndCourseStudents(Department department, int course);

    List<Student> showStudentsOlderThan(LocalDate date);

    List<Student> showGroup(String group);
}
