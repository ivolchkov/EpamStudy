package ua.epam.task5.student.view;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.epam.task5.student.configuration.DIConfiguration;
import ua.epam.task5.student.domain.Address;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.PhoneNumber;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.repository.StudentRepositoryImpl;
import ua.epam.task5.student.service.DepartmentServiceImpl;
import ua.epam.task5.student.service.StudentServiceImpl;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    public static final AnnotationConfigApplicationContext CONTEXT = new AnnotationConfigApplicationContext(DIConfiguration.class);
    private static final ResourceManager MANAGER = ResourceManager.INSTANCE;
    private static final StudentRepositoryImpl REPOSITORY = CONTEXT.getBean(StudentRepositoryImpl.class);
    private static final StudentServiceImpl STUDENT_SERVICE = CONTEXT.getBean(StudentServiceImpl.class);
    private static final DepartmentServiceImpl DEPARTMENT_SERVICE = CONTEXT.getBean(DepartmentServiceImpl.class);
    private static final Scanner IN = new Scanner(System.in);
    public static final String LANGUAGE = "Select an appropriate language:\n" + "1)Russian\n" + "2)German\n" + "3)Default(English)";

    public void run(){
        autoRegistration();
        int language = 0;
        int choice = 0;

        System.out.println(LANGUAGE);

        language = IN.nextInt();
        selectLanguage(language);

        System.out.println(MANAGER.getString("introduction"));
        choice = IN.nextInt();

        switch (choice) {
            case 1: signUp(); break;
            case 2: signIn(); break;
            default:
                System.out.println(MANAGER.getString("invalidChoice"));
        }
    }

    private void selectLanguage(int language) {
        String country, languageLocale;
        switch (language) {
            case 1: {
                country = "ru";
                languageLocale = "RU";
                break;
            }
            case 2: {
                country = "de";
                languageLocale = "DEU";
                break;
            }
            default: {
                country = "en";
                languageLocale = "US";
            }
        }
        Locale locale = new Locale(country, languageLocale);
        MANAGER.changeResourse(locale);
    }

    private void signUp() {
        String name;
        String surname;
        String secondName;
        String email;
        int yearOfBirth;
        int monthOfBirth;
        int dayOfBirth;
        String city;
        String street;
        int streetNumber;
        int flatNumber;
        String code;
        String number;
        Long id;
        String departmentName;
        int course;
        String group;

        System.out.println(MANAGER.getString("registration.start"));
        name = IN.next();
        System.out.println(MANAGER.getString("registration.surname"));
        surname = IN.next();
        System.out.println(MANAGER.getString("registration.secondName"));
        secondName = IN.next();
        System.out.println(MANAGER.getString("registration.email"));
        email = IN.next();
        System.out.println(MANAGER.getString("registration.birth"));
        yearOfBirth = IN.nextInt();
        monthOfBirth = IN.nextInt();
        dayOfBirth = IN.nextInt();
        System.out.println(MANAGER.getString("registration.city"));
        city = IN.next();
        System.out.println(MANAGER.getString("registration.street"));
        street = IN.next();
        System.out.println(MANAGER.getString("registration.streetNumber"));
        streetNumber = IN.nextInt();
        System.out.println(MANAGER.getString("registration.flatNumber"));
        flatNumber = IN.nextInt();
        System.out.println(MANAGER.getString("registration.code"));
        code = IN.next();
        System.out.println(MANAGER.getString("registration.number"));
        number = IN.next();
        System.out.println(MANAGER.getString("registration.course"));
        course = IN.nextInt();
        System.out.println(MANAGER.getString("registration.depName"));
        departmentName = IN.next();

        System.out.println(MANAGER.getString("registration.depId"));
        id = IN.nextLong();
        System.out.println(MANAGER.getString("registration.group"));
        group = IN.next();

        LocalDate date = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        Address address = Address.build().
                withCity(city).
                withStreet(street).
                withStreetNumber(streetNumber).
                withFlatNumber(flatNumber).
                build();

        Department department = new Department(id, departmentName);
        PhoneNumber phoneNumber = new PhoneNumber(code, number);

        Student student = Student.build().
                withName(name).
                withSurname(surname).
                withSecondName(secondName).
                withEmail(email).
                withDateOfBirth(date).
                withAddress(address).
                withPhoneNumber(phoneNumber).
                withDepartment(department).
                withCourse(course).
                withGroup(group).
                build();

        STUDENT_SERVICE.register(student);

        System.out.println(MANAGER.getString("registration.success"));
        System.out.println(MANAGER.getString("registration.yourId") + student.getId());
        System.out.println(MANAGER.getString("registration.nextStep"));

        int signIn = IN.nextInt();

        if ( signIn == 1 ) {
            signIn();
        } else {
            System.out.println(MANAGER.getString("registration.goodBye"));
            System.exit(0);
        }
    }

    private void signIn() {
        Long id;
        String name;

        System.out.println(MANAGER.getString("login.id"));
        id = IN.nextLong();
        IN.nextLine();
        System.out.println(MANAGER.getString("login.name"));
        name = IN.nextLine();

        Student student = DEPARTMENT_SERVICE.showStudent(id);
        Objects.requireNonNull(student, "Student has not been found");

        if ( student.getName().equals(name) ) {
            operationService(student);
        } else {
            System.out.println(MANAGER.getString("login.invalidOperation"));
        }

    }

    private void operationService(Student student) {
        boolean isFinish = false;

        while (!isFinish) {
            System.out.println(MANAGER.getString("operation.selection"));
            int choice = IN.nextInt();

            switch (choice) {
                case 1 : {
                    operationFindByDep();
                    break;
                }
                case 2 : {
                    operationFindByDepAndCourse();
                    break;
                }
                case 3 : {
                    operationFindByAge();
                    break;
                }
                case 4 : {
                    TreeSet<Student> students = DEPARTMENT_SERVICE.showGroup(student.getGroup());

                    for (Student s: students) {
                        System.out.println(s);
                    }

                    break;
                }
                case 5 : {
                    isFinish = true;
                }
            }
        }
    }

    private void operationFindByDep() {
        TreeSet<Student> students;
        Long id;
        String departmentName;
        Department department;

        System.out.println(MANAGER.getString("operation.depName"));
        departmentName = IN.next();
        System.out.println(MANAGER.getString("operation.depId"));
        id = IN.nextLong();

        department = new Department(id, departmentName);
        students = DEPARTMENT_SERVICE.showDepartmentStudents(department);

        Objects.requireNonNull(students, "There are no students in this department");

        for (Student s: students) {
            System.out.println(s);
        }
    }

    private void operationFindByDepAndCourse() {
        TreeSet<Student> students;
        Long id;
        String departmentName;
        int course;
        Department department;

        System.out.println(MANAGER.getString("operation.depName"));
        departmentName = IN.next();
        System.out.println(MANAGER.getString("operation.depId"));
        id = IN.nextLong();
        System.out.println(MANAGER.getString("operation.course"));
        course = IN.nextInt();

        department = new Department(id, departmentName);
        students = DEPARTMENT_SERVICE.showDepartmentAndCourseStudents(department, course);

        Objects.requireNonNull(students, "There are no students in this department and on this year of study");

        for (Student s: students) {
            System.out.println(s);
        }
    }

    private void operationFindByAge() {
        TreeSet<Student> students;
        int yearOfBirth;
        int monthOfBirth;
        int dayOfBirth;
        LocalDate date;

        System.out.println(MANAGER.getString("operation.date"));
        yearOfBirth = IN.nextInt();
        monthOfBirth = IN.nextInt();
        dayOfBirth = IN.nextInt();

        date = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        students = DEPARTMENT_SERVICE.showStudentsOlderThan(date);

        Objects.requireNonNull(students, "There are no students older than you chose");

        for (Student s: students) {
            System.out.println(s);
        }
    }

    private void autoRegistration() {
        Department dep = new Department(1L, "FEA");
        PhoneNumber number = new PhoneNumber("+(380)", "165-85-74");
        Address address1 = Address.build().
                withCity("Kiev").
                withStreet("Khreshatik").
                withStreetNumber(25).
                withFlatNumber(75).
                build();
        Address address2 = Address.build().
                withCity("Kiev").
                withStreet("Peremohy").
                withStreetNumber(31).
                withFlatNumber(24).
                build();
        Address address3 = Address.build().
                withCity("Kiev").
                withStreet("Borshahovskaya").
                withStreetNumber(148).
                withFlatNumber(12).
                build();
        Address address4 = Address.build().
                withCity("Kiev").
                withStreet("Borshahovskaya").
                withStreetNumber(148).
                withFlatNumber(77).
                build();
        Address address5 = Address.build().
                withCity("Kiev").
                withStreet("Voskresenskaya").
                withStreetNumber(23).
                withFlatNumber(48).
                build();
        Address address6 = Address.build().
                withCity("Kiev").
                withStreet("Druzhby Narodov").
                withStreetNumber(55).
                withFlatNumber(78).
                build();

        Student volchkov = Student.build().
                withName("Ihor").
                withSurname("Volchkov").
                withSecondName("Vasilyevich").
                withEmail("igorik@ua.fm").
                withAddress(address1).
                withDateOfBirth(LocalDate.of(1997, 11, 12)).
                withPhoneNumber(number).
                withDepartment(dep).
                withCourse(5).
                withGroup("EC-91m").
                build();

        Student ilchenko = Student.build().
                withName("Dmitrii").
                withSurname("Ilchenko").
                withSecondName("Vasilyevich").
                withEmail("dimachka@gmail.com").
                withAddress(address2).
                withDateOfBirth(LocalDate.of(1997, 12, 21)).
                withPhoneNumber(number).
                withDepartment(dep).
                withCourse(5).
                withGroup("EC-91m").
                build();

        Student kovtanyuk = Student.build().
                withName("Marta").
                withSurname("Kovtanyuk").
                withSecondName("Olegovna").
                withEmail("marthakovtanyuk@gmail.com").
                withAddress(address3).
                withDateOfBirth(LocalDate.of(1998, 7, 31)).
                withPhoneNumber(number).
                withDepartment(dep).
                withCourse(5).
                withGroup("UM-91m").
                build();

        Student lopuha = Student.build().
                withName("Valentyn").
                withSurname("Lopuha").
                withSecondName("Viktorovich").
                withEmail("valentynych@gmail.com").
                withAddress(address4).
                withDateOfBirth(LocalDate.of(1999, 1, 23)).
                withPhoneNumber(number).
                withDepartment(dep).
                withCourse(5).
                withGroup("UM-91m").
                build();

        Student piznak = Student.build().
                withName("Vasiliy").
                withSurname("Piznak").
                withSecondName("Vasilyovich").
                withEmail("044roseclan@gmail.com").
                withAddress(address5).
                withDateOfBirth(LocalDate.of(1998, 9, 19)).
                withPhoneNumber(number).
                withDepartment(dep).
                withCourse(5).
                withGroup("IC-91m").
                build();
        Student samsonov = Student.build().
                withName("Denys").
                withSurname("Samsonov").
                withSecondName("Andreevich").
                withEmail("computerMining@gmail.com").
                withAddress(address6).
                withDateOfBirth(LocalDate.of(1998, 2, 23)).
                withPhoneNumber(number).
                withDepartment(dep).
                withCourse(4).
                withGroup("EP-41").
                build();



        STUDENT_SERVICE.register(volchkov);
        STUDENT_SERVICE.register(ilchenko);
        STUDENT_SERVICE.register(lopuha);
        STUDENT_SERVICE.register(samsonov);
        STUDENT_SERVICE.register(piznak);
        STUDENT_SERVICE.register(kovtanyuk);

    }
}

