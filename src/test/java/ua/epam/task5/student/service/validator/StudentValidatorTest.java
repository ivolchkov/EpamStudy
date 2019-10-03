package ua.epam.task5.student.service.validator;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.epam.task5.student.domain.PhoneNumber;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.exception.InvalidRegistrationException;

public class StudentValidatorTest {
    private static StudentValidator validator;
//    private static Student student;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void initStudent() {
        validator = new StudentValidator();
//        student = Student.build().withEmail("igorik@gmail.com").
//                withPassword("Vfkmddfhgdf2565").
//                withPhoneNumber(new PhoneNumber("(+380)", "169-85-47")).
//                withName("Andrew").
//                withSurname("Popovich").
//                withSecondName("Illich").build();
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingNullStudent() {
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Student is not valid"));
        exception.expectMessage("Student is not valid");

        validator.validate(null);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidName() {
        Student student = Student.build().withName("zhorik").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect name"));
        exception.expectMessage("Incorrect name");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidSurname() {
        Student student = Student.build().withSurname("anabolik").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect surname"));
        exception.expectMessage("Incorrect surname");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidSecondName() {
        Student student = Student.build().withSecondName("batkovich").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect second name"));
        exception.expectMessage("Incorrect second name");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidEmail() {
        Student student = Student.build().withEmail("test.oshibka.com").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect e-mail"));
        exception.expectMessage("Incorrect e-mail");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidPassword() {
        Student student = Student.build().withPassword("plohoyparol").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect password"));
        exception.expectMessage("Incorrect password");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidPhoneNumber() {
        Student student = Student.build().withPhoneNumber(new PhoneNumber("255", "1458598")).build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect phone number"));
        exception.expectMessage("Incorrect phone number");

        validator.validate(student);
    }

}