package ua.epam.task5.student.service;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.repository.StudentRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

//    private StudentRepository studentRepository=new StudentRepository() {
//        @Override
//        public Student save(Student student) {
//            return null;
//        }
//
//        @Override
//        public Student findById(Long id) {
//            return null;
//        }
//
//        @Override
//        public void update(Student student) {
//
//        }
//
//        @Override
//        public Student deleteById(Long id) {
//            return null;
//        }
//    };
//    private StudentServiceImpl studentService = new StudentServiceImpl();

//    private StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
//    private StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @After
    public void resetMock() {
        reset(studentRepository);
    }

    @Test
    public void shouldRegisterStudent() {
        Student expected = Student.build().withName("Igor").build();
        when(studentRepository.save(any(Student.class))).thenReturn(expected);
        Student actual = studentService.register(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        Student expected = null;
        exception.expect(IllegalArgumentException.class);

        Student actual = studentService.register(expected);
    }

}