package ua.epam.task4.student;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.TreeSet;


public final class StudentHandler {
    private static HashSet<StudentOld> students = new HashSet<>();

    private StudentHandler() {
        throw new RuntimeException();
    }

    public static void addStudent(StudentOld student) {
        if(student == null ) {
            throw new IllegalArgumentException();
        }
        students.add(student);
    }

    public static TreeSet<StudentOld> getFacultyStudents(String faculty) {
        TreeSet<StudentOld> suitableStudents = new TreeSet<StudentOld>();

        for (StudentOld student: students) {
            if ( Objects.equals(student.getFaculty(), faculty) ) {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    public static TreeSet<StudentOld> getFacultyAndCourseStudents(String faculty, int course) {
        TreeSet<StudentOld> suitableStudents = new TreeSet<StudentOld>();

        for (StudentOld student: students) {
            if ( Objects.equals(student.getFaculty(), faculty) && student.getCourse() == course )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    public static TreeSet<StudentOld> getStudentsOlderThan(LocalDate date) {
        TreeSet<StudentOld> suitableStudents = new TreeSet<StudentOld>();

        for (StudentOld student: students) {
            if ( student.getDateOfBirth().compareTo(date) < 0 )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

    public static TreeSet<StudentOld> getGroup(String group) {
        TreeSet<StudentOld> suitableStudents = new TreeSet<StudentOld>();

        for (StudentOld student: students) {
            if ( Objects.equals(student.getGroup(), group) )  {
                suitableStudents.add(student);
            }
        }

        return suitableStudents;
    }

}
