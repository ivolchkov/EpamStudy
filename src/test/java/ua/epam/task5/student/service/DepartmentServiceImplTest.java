package ua.epam.task5.student.service;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.repository.StudentRepository;
import ua.epam.task6.myJUnit.BeforeClass;

import java.time.LocalDate;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceImplTest {
    private static TreeSet<Student> expected;
    private static Department department = new Department(1L, "FEA");;
    private static String group = "EC-91p";

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private DepartmentServiceImpl implementation;

    @BeforeClass
    public static void initStudents() {
        LocalDate firstDate = LocalDate.of(1997, 12, 25);
        LocalDate secondDate = LocalDate.of(1998, 11, 12);
        Student first = Student.build().withDepartment(department).withCourse(1).withDateOfBirth(firstDate).withGroup(group).build();
        Student second = Student.build().withDepartment(department).withCourse(1).withDateOfBirth(secondDate).withGroup(group).build();
        expected = new TreeSet<>();
        expected.add(first);
        expected.add(second);
    }

    @After
    public void resetMock() {
        reset(studentRepository);
    }

    @Test
    public void shouldReturnValidSearchByDepartment() {
        when(studentRepository.findByDepartment(department)).thenReturn(expected);
        TreeSet<Student> actual = implementation.showDepartmentStudents(department);

        verify(studentRepository, times(1)).findByDepartment(department);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValidSearchByDepartmentAndCourse() {
        when(studentRepository.findByDepartmentAndCourse(department, 1)).thenReturn(expected);
        TreeSet<Student> actual = implementation.showDepartmentAndCourseStudents(department, 1);

        verify(studentRepository, times(1)).findByDepartmentAndCourse(department, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValidSearchByAge() {
        LocalDate testDate = LocalDate.of(1999, 1, 1);
        when(studentRepository.findByAge(testDate)).thenReturn(expected);
        TreeSet<Student> actual = implementation.showStudentsOlderThan(testDate);

        verify(studentRepository, times(1)).findByAge(testDate);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValidSearchByGroup() {
        when(studentRepository.findByGroup(DepartmentServiceImplTest.group)).thenReturn(expected);
        TreeSet<Student> actual = implementation.showGroup(group);

        verify(studentRepository, times(1)).findByGroup(group);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenSearchingByDep() {
        exception.expect(NullPointerException.class);

        implementation.showDepartmentStudents(null);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenSearchingByDepAndCourse() {
        exception.expect(NullPointerException.class);

        implementation.showDepartmentAndCourseStudents(null, 1);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenSearchingByAge() {
        exception.expect(NullPointerException.class);

        implementation.showStudentsOlderThan(null);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenSearchingByGroup() {
        exception.expect(NullPointerException.class);

        implementation.showGroup(null);
    }

}