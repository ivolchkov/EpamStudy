package ua.epam.task5.student.repository;

import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.Student;

import java.time.LocalDate;
import java.util.TreeSet;

//CRUD
//C - create
//R - read
//U - update
//D - delete
public interface StudentRepository {
    // C
    Student save(Student student);

    //R
    Student findById(Long id);
    TreeSet<Student> findByDepartment(Department department);
    TreeSet<Student> findByDepartmentAndCourse(Department department, int course);
    TreeSet<Student> findByAge(LocalDate date);
    TreeSet<Student> findByGroup(String group);

    //U
    void update(Student student);

    //D
    Student deleteById(Long id);
}
