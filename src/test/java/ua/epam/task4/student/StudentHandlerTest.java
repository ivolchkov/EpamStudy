package ua.epam.task4.student;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class StudentHandlerTest {
    private static Student[] students;

    @BeforeClass
    public static void initStudents() {
        students = new Student[6];


        Student first = Student.build().
                withFaculty("FEA").
                withCourse(3).
                withGroup("EK-41").
                withDateOfBirth(LocalDate.of(1997,11,12)).
                build();


        Student second = Student.build().
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91").
                withDateOfBirth(LocalDate.of(1996,3,14)).
                build();

        Student third = Student.build().
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91").
                withDateOfBirth(LocalDate.of(1998,5,23)).
                build();

        Student fourth = Student.build().
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91").
                withDateOfBirth(LocalDate.of(1999,1,11)).
                build();

        Student fifth = Student.build().
                withFaculty("FIOT").
                withCourse(3).
                withGroup("IT-71").
                withDateOfBirth(LocalDate.of(1995,2,12)).
                build();

        Student sixth = Student.build().
                withFaculty("FIOT").
                withCourse(3).
                withGroup("IT-71").
                withDateOfBirth(LocalDate.of(1998,10,12)).
                build();

        students[0] = first;
        students[1] = second;
        students[2] = third;
        students[3] = fourth;
        students[4] = fifth;
        students[5] = sixth;
    }

    @Test
    public void shouldReturnRightFacultyStudents() {
        TreeSet<Student> expected = new TreeSet<>();
        expected.add(students[0]);
        expected.add(students[1]);
        expected.add(students[2]);
        expected.add(students[3]);
        TreeSet<Student> actual = StudentHandler.getFacultyStudents("FEA");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightFacultyAndCourseStudents() {
        TreeSet<Student> expected = new TreeSet<>();
        expected.add(students[1]);
        expected.add(students[2]);
        expected.add(students[3]);
        TreeSet<Student> actual = StudentHandler.getFacultyAndCourseStudents("FEA", 5);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightStudentsOlderThan() {
        TreeSet<Student> expected = new TreeSet<>();
        expected.add(students[0]);
        expected.add(students[1]);
        expected.add(students[4]);
        TreeSet<Student> actual = StudentHandler.getStudentsOlderThan(LocalDate.of(1998, 1, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightGroupOfStudents() {
        TreeSet<Student> expected = new TreeSet<>();
        expected.add(students[4]);
        expected.add(students[5]);
        TreeSet<Student> actual = StudentHandler.getGroup("IT-71");

        assertEquals(expected, actual);
    }


}