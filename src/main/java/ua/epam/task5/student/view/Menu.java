package ua.epam.task5.student.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.task5.student.domain.Address;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.PhoneNumber;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.exception.StudentNotFoundException;
import ua.epam.task5.student.service.DepartmentServiceImpl;
import ua.epam.task5.student.service.StudentServiceImpl;

import java.time.LocalDate;
import java.util.*;

@Component
public class Menu {
    private static final ResourceManager MANAGER = ResourceManager.INSTANCE;
    private static final Scanner IN = new Scanner(System.in);
    public static final String LANGUAGE = "Select an appropriate language:\n" + "1)Russian\n" + "2)German\n" + "3)Default(English)";

    private final StudentServiceImpl studentService;
    private final DepartmentServiceImpl departmentService;

    @Autowired
    public Menu(StudentServiceImpl studentService, DepartmentServiceImpl departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    public void run() {
        autoRegistration();
        int language;
        int choice;

        System.out.println(LANGUAGE);

        language = IN.nextInt();
        selectLanguage(language);

        System.out.println(MANAGER.getString("introduction"));
        choice = IN.nextInt();

        switch (choice) {
            case 1:
                signUp();
                break;
            case 2:
                signIn();
                break;
            default:
                System.out.println(MANAGER.getString("invalidChoice"));
        }
    }

    private void selectLanguage(int language) {
        String country;
        String languageLocale;

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
        String password;
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
        System.out.println(MANAGER.getString("registration.password"));
        password = IN.next();
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
                withPassword(password).
                withDateOfBirth(date).
                withAddress(address).
                withPhoneNumber(phoneNumber).
                withDepartment(department).
                withCourse(course).
                withGroup(group).
                build();

        studentService.register(student);

        System.out.println(MANAGER.getString("registration.success"));
        System.out.println(MANAGER.getString("registration.yourId") + student.getId());
        System.out.println(MANAGER.getString("registration.nextStep"));

        int signIn = IN.nextInt();

        if (signIn == 1) {
            signIn();
        } else {
            System.out.println(MANAGER.getString("registration.goodBye"));
            System.exit(0);
        }
    }

    private void signIn() {
        String email;
        String password;

        System.out.println(MANAGER.getString("login.email"));
        email = IN.next();
        System.out.println(MANAGER.getString("login.password"));
        password = IN.next();

        Optional<Student> student = studentService.login(email, password);

        student.ifPresent(this::operationService);

        System.out.println(MANAGER.getString("login.invalidOperation"));
    }

    private void operationService(Student student) {
        boolean isFinish = false;

        while (!isFinish) {
            System.out.println(MANAGER.getString("operation.selection"));
            int choice = IN.nextInt();

            switch (choice) {
                case 1: {
                    operationFindByDep();
                    break;
                }
                case 2: {
                    operationFindByDepAndCourse();
                    break;
                }
                case 3: {
                    operationFindByAge();
                    break;
                }
                case 4: {
                    List<Student> students = departmentService.showGroup(student.getGroup());

                    for (Student s : students) {
                        System.out.println(s);
                    }

                    break;
                }
                case 5: {
                    isFinish = true;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid operation");
                }
            }
        }
    }

    private void operationFindByDep() {
        List<Student> students;
        Long id;
        String departmentName;
        Department department;

        System.out.println(MANAGER.getString("operation.depName"));
        departmentName = IN.next();
        System.out.println(MANAGER.getString("operation.depId"));
        id = IN.nextLong();

        department = new Department(id, departmentName);
        students = departmentService.showDepartmentStudents(department);

        Objects.requireNonNull(students, "There are no students in this department");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void operationFindByDepAndCourse() {
        List<Student> students;
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
        students = departmentService.showDepartmentAndCourseStudents(department, course);

        Objects.requireNonNull(students, "There are no students in this department and on this year of study");

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void operationFindByAge() {
        List<Student> students;
        int yearOfBirth;
        int monthOfBirth;
        int dayOfBirth;
        LocalDate date;

        System.out.println(MANAGER.getString("operation.date"));
        yearOfBirth = IN.nextInt();
        monthOfBirth = IN.nextInt();
        dayOfBirth = IN.nextInt();

        date = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        students = departmentService.showStudentsOlderThan(date);

        Objects.requireNonNull(students, "There are no students older than you chose");

        for (Student s : students) {
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
                withPassword("Vfkmdbyf1997").
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
                withPassword("Lbvfbkmxtyrj1997").
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
                withPassword("Lbvfbkmxtyrj1997").
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
                withPassword("Lbvfbkmxtyrj1997").
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
                withPassword("Lbvfbkmxtyrj1997").
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
                withPassword("Lbvfbkmxtyrj1997").
                withAddress(address6).
                withDateOfBirth(LocalDate.of(1998, 2, 23)).
                withPhoneNumber(number).
                withDepartment(dep).
                withCourse(4).
                withGroup("EP-41").
                build();


        studentService.register(volchkov);
        studentService.register(ilchenko);
        studentService.register(lopuha);
        studentService.register(samsonov);
        studentService.register(piznak);
        studentService.register(kovtanyuk);

    }
}

