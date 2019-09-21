package ua.epam.task4.student;

import java.util.HashSet;

public class StudentHandler {
    private static HashSet<Student> students = new HashSet<>();


    public static void addStudent(Student student) {
        students.add(student);
    }
}
