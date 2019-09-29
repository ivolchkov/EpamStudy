package ua.epam.task5.student.service.validator;

import ua.epam.task5.student.domain.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidator implements Validator<Student> {
    @Override
    public void validate(Student student) {
        validateName(student.getName());
        validateSurname(student.getSurname());
        validateSecondName(student.getSecondName());
        validateEmail(student.getEmail());
        validatePhoneNumber(student.getPhoneNumber().getCode(), student.getPhoneNumber().getNumber());
    }

    private void validateEmail(String email) {
        String regex = "(\\w{2,})@(\\w+\\p{Punct})([a-z]{2,5})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Incorrect e-mail");
        }
    }

    private void validateName(String name) {
        String regex = "([A-Z])([a-z]{2,12})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Incorrect name");
        }
    }

    private void validateSurname(String surname) {
        String regex = "([A-Z])([a-z]{2,12})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(surname);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Incorrect surname");
        }
    }

    private void validateSecondName(String secondName) {
        String regex = "([A-Z])([a-z]{2,12})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(secondName);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Incorrect second name");
        }
    }

    private void validatePhoneNumber(String code, String number) {
        String regexCode = "\\+\\(\\d{3}\\)";
        String regexNumber = "\\d{3}-\\d{2}-\\d{2}";
        Pattern patternCode = Pattern.compile(regexCode);
        Matcher matcherCode = patternCode.matcher(code);
        Pattern patternNumber = Pattern.compile(regexNumber);
        Matcher matcherNumber = patternNumber.matcher(number);

        if (!matcherCode.find() || !matcherNumber.find() ) {
            throw new IllegalArgumentException("Incorrect phone number");
        }
    }

}
