package ua.epam.task5.student.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.exception.AlreadyRegisteredException;
import ua.epam.task5.student.exception.StudentNotFoundException;
import ua.epam.task5.student.repository.StudentRepository;
import ua.epam.task5.student.service.encode.PasswordEncoder;
import ua.epam.task5.student.service.validator.Validator;

import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = Logger.getLogger("file");

    private final StudentRepository studentRepository;
    private final Validator<Student> validator;
    private final PasswordEncoder encoder;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, Validator<Student> validator, PasswordEncoder encoder) {
        this.studentRepository = studentRepository;
        this.validator = validator;
        this.encoder = encoder;
    }

    @Override
    public Optional<Student> register(Student student) {
        this.validator.validate(student);

        try {
            if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
                throw new AlreadyRegisteredException("Student is already registered by this e-mail");
            }
        } catch (AlreadyRegisteredException e) {
            LOGGER.error("Student is already registered by this e-mail", e);
            throw new RuntimeException(e);
        }

        String encodedPassword = encoder.encode(student.getPassword());
        Student.buildPassword().setPassword(student, encodedPassword);

        return Optional.ofNullable(studentRepository.save(student));
    }

    @Override
    public Optional<Student> login(String email, String password) {
        String encodedPassword = encoder.encode(password);
        final Optional<Student> user = studentRepository.findByEmail(email);

        try {
            if (!user.isPresent()) {
                throw new StudentNotFoundException("There is no student with this e-mail");
            } else {
                try {
                    if (user.get().getPassword().equals(encodedPassword)) {
                        return user;
                    } else {
                        throw new StudentNotFoundException("Incorrect password");
                    }
                } catch (StudentNotFoundException e) {
                    LOGGER.error("Incorrect password", e);
                }
            }
        } catch (StudentNotFoundException e) {
            LOGGER.error("There is no student with this e-mail", e);
        }

        return Optional.empty();
    }
}
