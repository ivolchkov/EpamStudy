package ua.epam.task5.student.service.validator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Component;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.exception.InvalidRegistrationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StudentValidator implements Validator<Student> {
    private static final Logger LOGGER = Logger.getLogger("file");

    @Override
    public void validate(Student student) {
        try {
            if (student == null) {
                throw new InvalidRegistrationException("Student is not valid");
            }
        } catch (InvalidRegistrationException e) {
            LOGGER.error("Student is not valid", e);
            throw new RuntimeException(e);
        }
        validateName(student.getName());
        validateSurname(student.getSurname());
        validateSecondName(student.getSecondName());
        validateEmail(student.getEmail());
        validatePassword(student.getPassword());
        validatePhoneNumber(student.getPhoneNumber().getCode(), student.getPhoneNumber().getNumber());
    }

    private void validatePassword(String password) {
        String regex = "[A-Z]\\w{4,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        try {
            if (!matcher.find()) {
                throw new InvalidRegistrationException("Incorrect password");
            }
        } catch (InvalidRegistrationException e) {
            LOGGER.error("Incorrect password", e);
            throw new RuntimeException(e);
        }
    }

    private void validateEmail(String email) {
        String regex = "(\\w{2,})@(\\w+\\p{Punct})([a-z]{2,5})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        try {
            if (!matcher.find()) {
                throw new InvalidRegistrationException("Incorrect e-mail");
            }
        } catch (InvalidRegistrationException e) {
            LOGGER.error("Incorrect e-mail", e);
            throw new RuntimeException(e);
        }
    }

    private void validateName(String name) {
        String regex = "([A-Z])([a-z]{2,12})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        try {
            if (!matcher.find()) {
                throw new InvalidRegistrationException("Incorrect name");
            }
        } catch (InvalidRegistrationException e) {
            LOGGER.error("Incorrect name", e);
            throw new RuntimeException(e);
        }
    }

    private void validateSurname(String surname) {
        String regex = "([A-Z])([a-z]{2,12})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(surname);

        try {
            if (!matcher.find()) {
                throw new InvalidRegistrationException("Incorrect surname");
            }
        } catch (InvalidRegistrationException e) {
            LOGGER.error("Incorrect surname", e);
            throw new RuntimeException(e);
        }
    }

    private void validateSecondName(String secondName) {
        String regex = "([A-Z])([a-z]{2,12})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(secondName);

        try {
            if (!matcher.find()) {
                throw new InvalidRegistrationException("Incorrect second name");
            }
        } catch (InvalidRegistrationException e) {
            LOGGER.error("Incorrect second name", e);
            throw new RuntimeException(e);
        }
    }

    private void validatePhoneNumber(String code, String number) {
        String regexCode = "\\+\\(\\d{3}\\)";
        String regexNumber = "\\d{3}-\\d{2}-\\d{2}";
        Pattern patternCode = Pattern.compile(regexCode);
        Matcher matcherCode = patternCode.matcher(code);
        Pattern patternNumber = Pattern.compile(regexNumber);
        Matcher matcherNumber = patternNumber.matcher(number);

        try {
            if (!matcherCode.find() || !matcherNumber.find()) {
                throw new InvalidRegistrationException("Incorrect phone number");
            }
        } catch (InvalidRegistrationException e) {
            LOGGER.error("Incorrect phone number", e);
            throw new RuntimeException(e);
        }
    }

}
