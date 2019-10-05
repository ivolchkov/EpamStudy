package ua.epam.task5.student.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.service.encode.PasswordEncoder;
import ua.epam.task5.student.service.validator.StudentValidator;
import ua.epam.task5.student.view.domainFront.StudentFront;


@Component
public class StudentMapper {
    private final StudentValidator validator;
    private final PasswordEncoder encoder;

    @Autowired
    public StudentMapper( PasswordEncoder encoder, StudentValidator validator) {
        this.encoder = encoder;
        this.validator = validator;
    }

    public Student convertFrontToBack(StudentFront front) {
        if ( front == null ) {
            throw new IllegalArgumentException();
        }
        validator.validate(front);
        String password = encoder.encode(front.getPassword());

        return Student.build().
                withName(front.getName()).
                withSurname(front.getSurname()).
                withSecondName(front.getSecondName()).
                withEmail(front.getEmail()).
                withPassword(password).
                withAddress(front.getAddress()).
                withDateOfBirth(front.getDateOfBirth()).
                withPhoneNumber(front.getPhoneNumber()).
                withDepartment(front.getDepartment()).
                withCourse(front.getCourse()).
                withGroup(front.getGroup()).
                build();
    }


}
