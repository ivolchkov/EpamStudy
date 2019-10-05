package ua.epam.task5.student.service.validator;

import org.hamcrest.Matcher;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.epam.task5.student.domain.PhoneNumber;
import ua.epam.task5.student.exception.InvalidRegistrationException;
import ua.epam.task5.student.view.domainFront.StudentFront;


public class StudentValidatorTest {
    private static StudentValidator validator;
//    private static StudentFront student;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @BeforeClass
    public static void initStudentFront() {
        validator = new StudentValidator();
//        student = StudentFront.build().withEmail("igorik@gmail.com").
//                withPassword("Vfkmddfhgdf2565").
//                withPhoneNumber(new PhoneNumber("(+380)", "169-85-47")).
//                withName("Andrew").
//                withSurname("Popovich").
//                withSecondName("Illich").build();
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingNullStudentFront() {
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("StudentFront is not valid"));
        exception.expectMessage("StudentFront is not valid");

        validator.validate(null);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidName() {
        StudentFront student = StudentFront.build().withName("zhorik").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect name"));
        exception.expectMessage("Incorrect name");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidSurname() {
        StudentFront student = StudentFront.build().withSurname("anabolik").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect surname"));
        exception.expectMessage("Incorrect surname");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidSecondName() {
        StudentFront student = StudentFront.build().withSecondName("batkovich").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect second name"));
        exception.expectMessage("Incorrect second name");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidEmail() {
        StudentFront student = StudentFront.build().withEmail("test.oshibka.com").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect e-mail"));
        exception.expectMessage("Incorrect e-mail");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidPassword() {
        StudentFront student = StudentFront.build().withPassword("plohoyparol").build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect password"));
        exception.expectMessage("Incorrect password");

        validator.validate(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionValidatingInvalidPhoneNumber() {
        StudentFront student = StudentFront.build().withPhoneNumber(new PhoneNumber("255", "1458598")).build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new InvalidRegistrationException("Incorrect phone number"));
        exception.expectMessage("Incorrect phone number");

        validator.validate(student);
    }

}