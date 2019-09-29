package ua.epam.task5.student.service.validator;

public interface Validator<T> {
    void validate(T object);
}
