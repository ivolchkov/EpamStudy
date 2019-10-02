package ua.epam.task5.student.service;

import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import ua.epam.task5.student.domain.PhoneNumber;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.exception.AlreadyRegisteredException;
import ua.epam.task5.student.exception.InvalidRegistrationException;
import ua.epam.task5.student.repository.StudentRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.epam.task5.student.service.encode.PasswordEncoder;
import ua.epam.task5.student.service.validator.Validator;

import javax.swing.text.html.Option;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    private StudentRepository studentRepository;
    @Mock
    private Validator<Student> validator;
    @Mock
    private PasswordEncoder encoder;

    @InjectMocks
    private StudentServiceImpl studentService;

    @After
    public void resetMock() {
        reset(studentRepository);
    }

    @Test
    public void shouldRegisterStudent() {
        Student student = Student.build().withName("Igor").
                withSurname("Volchkov").
                withSecondName("Vasilyevich").
                withPassword("Babushka3529").
                withEmail("igorik@gmail.com").
                withPhoneNumber(new PhoneNumber("+(380)", "165-35-85")).
                build();
        Optional<Student> expected = Optional.of(student);
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Optional<Student> actual = studentService.register(student);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenRegisterStudent() {
        Student student = Student.build().withName("Igor").
                build();
        exception.expect(RuntimeException.class);
        exception.expectCause((Matcher<? extends Throwable>) new AlreadyRegisteredException("Student is already registered by this e-mail"));
        exception.expectMessage("Student is already registered by this e-mail");

        when(studentRepository.findByEmail(any(String.class))).thenThrow(AlreadyRegisteredException.class);

        studentService.register(student);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenRegisterNullStudent() {
        exception.expect(RuntimeException.class);

        doThrow(RuntimeException.class).when(validator).validate(null);

        studentService.register(null);
    }

    @Test
    public void shouldLoginStudent() {
        Student student = Student.build().
                withPassword("Babushka3529").
                withEmail("igorik@gmail.com").
                build();
        Optional<Student> expected = Optional.of(student);
        when(studentRepository.findByEmail("igorik@gmail.com")).thenReturn(expected);
        when(encoder.encode("Babushka3529")).thenReturn(student.getPassword());

        Optional<Student> actual = studentService.login("igorik@gmail.com", "Babushka3529");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyStudent() {
        Optional<Student> expected = Optional.empty();
        when(studentRepository.findByEmail(any(String.class))).thenReturn(expected);
        Optional<Student> actual = studentService.login("test@email.com", "test");

        assertEquals(expected, actual);
    }

}