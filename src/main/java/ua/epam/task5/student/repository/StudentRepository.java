package ua.epam.task5.student.repository;

import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//CRUD
//C - create
//R - read
//U - update
//D - delete
public interface StudentRepository {
    // C
    Student save(Student student);

    //R
    Optional<Student> findById(Long id);
    Optional<Student> findByEmail(String email);
    List<Student> findByDepartment(Department department);
    List<Student> findByDepartmentAndCourse(Department department, int course);
    List<Student> findByAge(LocalDate date);
    List<Student> findByGroup(String group);

    //U
    void update(Student student);

    //D
    Optional<Student> deleteById(Long id);
    Optional<Student> deleteByEmail(String email);
}
