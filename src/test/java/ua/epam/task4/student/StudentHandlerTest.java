package ua.epam.task4.student;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class StudentHandlerTest {
    private static StudentOld[] students;

    @BeforeClass
    public static void initStudents() {
        students = new StudentOld[6];


        StudentOld first = StudentOld.build().
                withFaculty("FEA").
                withCourse(3).
                withGroup("EK-41").
                withDateOfBirth(LocalDate.of(1997,11,12)).
                build();


        StudentOld second = StudentOld.build().
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91").
                withDateOfBirth(LocalDate.of(1996,3,14)).
                build();

        StudentOld third = StudentOld.build().
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91").
                withDateOfBirth(LocalDate.of(1998,5,23)).
                build();

        StudentOld fourth = StudentOld.build().
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91").
                withDateOfBirth(LocalDate.of(1999,1,11)).
                build();

        StudentOld fifth = StudentOld.build().
                withFaculty("FIOT").
                withCourse(3).
                withGroup("IT-71").
                withDateOfBirth(LocalDate.of(1995,2,12)).
                build();

        StudentOld sixth = StudentOld.build().
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
        TreeSet<StudentOld> expected = new TreeSet<>();
        expected.add(students[0]);
        expected.add(students[1]);
        expected.add(students[2]);
        expected.add(students[3]);
        TreeSet<StudentOld> actual = StudentHandler.getFacultyStudents("FEA");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightFacultyAndCourseStudents() {
        TreeSet<StudentOld> expected = new TreeSet<>();
        expected.add(students[1]);
        expected.add(students[2]);
        expected.add(students[3]);
        TreeSet<StudentOld> actual = StudentHandler.getFacultyAndCourseStudents("FEA", 5);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightStudentsOlderThan() {
        TreeSet<StudentOld> expected = new TreeSet<>();
        expected.add(students[0]);
        expected.add(students[1]);
        expected.add(students[4]);
        TreeSet<StudentOld> actual = StudentHandler.getStudentsOlderThan(LocalDate.of(1998, 1, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRightGroupOfStudents() {
        TreeSet<StudentOld> expected = new TreeSet<>();
        expected.add(students[4]);
        expected.add(students[5]);
        TreeSet<StudentOld> actual = StudentHandler.getGroup("IT-71");

        assertEquals(expected, actual);
    }


}