package ua.epam.task5.student.exception;

public class AlreadyRegisteredException extends RuntimeException {
    public AlreadyRegisteredException() {
    }

    public AlreadyRegisteredException(String s) {
        super(s);
    }

    public AlreadyRegisteredException(Throwable throwable) {
        super(throwable);
    }
}
