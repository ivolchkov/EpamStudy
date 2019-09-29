package ua.epam.task5.student.service;

import ua.epam.task5.student.domain.Student;

public class Validator {

    public  void validate(Student user){
        if (user.getEmail() == null ) {
            throw new IllegalArgumentException("Student without email");
        }

    }
}
