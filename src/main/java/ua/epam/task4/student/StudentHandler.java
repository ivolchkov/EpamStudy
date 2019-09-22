package ua.epam.task4.student;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;


public final class StudentHandler {
    private static HashSet<Student> students = new HashSet<>();

    private StudentHandler() {
        throw new RuntimeException();
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static TreeSet<Student> getFacultyStudents(String faculty) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: students) {
            if ( Objects.equals(student.getFaculty(), faculty) ) {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    public static TreeSet<Student> getFacultyAndCourseStudents(String faculty, int course) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: students) {
            if ( Objects.equals(student.getFaculty(), faculty) && student.getCourse() == course )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    public static TreeSet<Student> getStudentsOlderThan(LocalDate date) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: students) {
            if ( student.getDateOfBirth().compareTo(date) < 0 )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    public static TreeSet<Student> getGroup(String group) {
        TreeSet<Student> suitableStudents = new TreeSet<Student>();

        for (Student student: students) {
            if ( Objects.equals(student.getGroup(), group) )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

}
