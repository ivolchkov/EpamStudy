package ua.epam.task5.student.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.exception.AlreadyRegisteredException;
import ua.epam.task5.student.exception.StudentNotFoundException;
import ua.epam.task5.student.repository.StudentRepository;
import ua.epam.task5.student.service.encode.PasswordEncoder;
import ua.epam.task5.student.service.mapper.StudentMapper;
import ua.epam.task5.student.view.domainFront.StudentFront;

import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = Logger.getLogger("file");

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;
    private final PasswordEncoder encoder;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper mapper, PasswordEncoder encoder) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public Student register(StudentFront studentFront) {
        Student student = mapper.convertFrontToBack(studentFront);

        try {
            if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
                throw new AlreadyRegisteredException("Student is already registered by this e-mail");
            }
        } catch (AlreadyRegisteredException e) {
            LOGGER.warn("Student is already registered by this e-mail", e);
            return null;
        }

        return studentRepository.save(student);
    }

    @Override
    public Student login(String email, String password) {
        String encodedPassword = encoder.encode(password);
        final Optional<Student> user = studentRepository.findByEmail(email);

        try {
            if (!user.isPresent()) {
                throw new StudentNotFoundException("There is no student with this e-mail");
            } else {
                try {
                    if (user.get().getPassword().equals(encodedPassword)) {
                        return user.get();
                    } else {
                        throw new StudentNotFoundException("Incorrect password");
                    }
                } catch (StudentNotFoundException e) {
                    LOGGER.warn("Incorrect password", e);
                }
            }
        } catch (StudentNotFoundException e) {
            LOGGER.warn("There is no student with this e-mail", e);
        }

        return null;
    }
}
