package ua.epam.task5.student.repository;

import org.springframework.stereotype.Repository;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.Student;

import java.time.LocalDate;
import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private Map<Long, Student> idToStudents = new HashMap<>();
    private static Long counter = 0L;

    @Override
    public Student save(Student student) {
        return idToStudents.put(++counter,student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(idToStudents.get(id));
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        Optional<Student> student = Optional.empty();

        for (Student s: idToStudents.values()) {
            if ( Objects.equals(s.getEmail(), email) ) {
                student = Optional.of(s);

                return student;
            }
        }

        return student;
    }

    @Override
    public List<Student> findByDepartment(Department department) {
        List<Student> suitableStudents = new ArrayList<Student>();

        for (Student student: idToStudents.values()) {
            if ( Objects.equals(student.getDepartment(), department) ) {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    @Override
    public List<Student> findByDepartmentAndCourse(Department department, int course) {
        List<Student> suitableStudents = new ArrayList<Student>();

        for (Student student: idToStudents.values()) {
            if ( Objects.equals(student.getDepartment(), department) && student.getCourse() == course )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    @Override
    public List<Student> findByAge(LocalDate date) {
        List<Student> suitableStudents = new ArrayList<Student>();

        for (Student student: idToStudents.values()) {
            if ( student.getDateOfBirth().compareTo(date) < 0 )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    @Override
    public List<Student> findByGroup(String group) {
        List<Student> suitableStudents = new ArrayList<Student>();

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
    public Optional<Student> deleteById(Long id) {
        return Optional.ofNullable(idToStudents.remove(id));
    }

    @Override
    public Optional<Student> deleteByEmail(String email) {
        for (Student student: idToStudents.values()) {
            if ( Objects.equals(student.getEmail(), email) )  {
                return Optional.of(idToStudents.remove(student.getId()));
            }
        }

        return Optional.empty();
    }
}
