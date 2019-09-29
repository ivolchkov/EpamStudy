package ua.epam.task5.student.repository;

import org.springframework.stereotype.Repository;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.Student;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private Map<Long, Student> idToStudents = new HashMap<>();
    private static Long counter = 0L;

    @Override
    public Student save(Student student) {
        return idToStudents.put(++counter,student);
    }

    @Override
    public Student findById(Long id) {
        return idToStudents.get(id);
    }

    @Override
    public TreeSet<Student> findByDepartment(Department department) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: idToStudents.values()) {
            if ( Objects.equals(student.getDepartment(), department) ) {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    @Override
    public TreeSet<Student> findByDepartmentAndCourse(Department department, int course) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: idToStudents.values()) {
            if ( Objects.equals(student.getDepartment(), department) && student.getCourse() == course )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    @Override
    public TreeSet<Student> findByAge(LocalDate date) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: idToStudents.values()) {
            if ( student.getDateOfBirth().compareTo(date) < 0 )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    @Override
    public TreeSet<Student> findByGroup(String group) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: idToStudents.values()) {
            if ( Objects.equals(student.getGroup(), group) )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    @Override
    public void update(Student student) {
        idToStudents.put(student.getId(), student);
    }

    @Override
    public Student deleteById(Long id) {
        return idToStudents.remove(id);
    }
}
