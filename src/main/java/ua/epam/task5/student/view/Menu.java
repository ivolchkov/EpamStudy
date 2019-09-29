package ua.epam.task5.student.view;

import ua.epam.task5.student.domain.Address;
import ua.epam.task5.student.domain.Department;
import ua.epam.task5.student.domain.PhoneNumber;
import ua.epam.task5.student.domain.Student;
import ua.epam.task5.student.repository.StudentRepositoryImpl;
import ua.epam.task5.student.service.DepartmentServiceImpl;
import ua.epam.task5.student.service.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Menu {
    private static final ResourceManager manager = ResourceManager.INSTANCE;
    private static final StudentRepositoryImpl repository = new StudentRepositoryImpl();
    private static final StudentServiceImpl studentService = new StudentServiceImpl(repository);
    private static final DepartmentServiceImpl departmentService = new DepartmentServiceImpl(repository);
    private static final Scanner in = new Scanner(System.in);

    public void run(){
        autoRegistration();

        System.out.println("Select an appropriate language:\n" +
                "1)Russian\n" +
                "2)German\n" +
                "3)Default(English)");

        int language = in.nextInt();

        switch (language) {
            case 1: {
                manager.changeResourse(new Locale("ru", "RU"));
                break;
            }
            case 2: {
                manager.changeResourse(new Locale("de", "DEU"));
                break;
            }
            default: {
            }
        }

        System.out.println(manager.getString("introduction"));
        int choice = in.nextInt();

        switch (choice) {
            case 1: signUp(); break;
            case 2: signIn(); break;
            default:
                System.out.println(manager.getString("invalidChoice"));
        }
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

        System.out.println(manager.getString("registration.start"));
        name = in.next();
        System.out.println(manager.getString("registration.surname"));
        surname = in.next();
        System.out.println(manager.getString("registration.secondName"));
        secondName = in.next();
        System.out.println(manager.getString("registration.email"));
        email = in.next();
        System.out.println(manager.getString("registration.birth"));
        yearOfBirth = in.nextInt();
        monthOfBirth = in.nextInt();
        dayOfBirth = in.nextInt();
        System.out.println(manager.getString("registration.city"));
        city = in.next();
        System.out.println(manager.getString("registration.street"));
        street = in.next();
        System.out.println(manager.getString("registration.streetNumber"));
        streetNumber = in.nextInt();
        System.out.println(manager.getString("registration.flatNumber"));
        flatNumber = in.nextInt();
        System.out.println(manager.getString("registration.code"));
        code = in.next();
        System.out.println(manager.getString("registration.number"));
        number = in.next();
        System.out.println(manager.getString("registration.course"));
        course = in.nextInt();
        System.out.println(manager.getString("registration.depName"));
        departmentName = in.next();

        System.out.println(manager.getString("registration.depId"));
        id = in.nextLong();
        System.out.println(manager.getString("registration.group"));
        group = in.next();

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

        studentService.register(student);

        System.out.println(manager.getString("registration.success"));
        System.out.println(manager.getString("registration.yourId") + student.getId());
        System.out.println(manager.getString("registration.nextStep"));

        int signIn = in.nextInt();

        if ( signIn == 1 ) {
            signIn();
        } else {
            System.out.println(manager.getString("registration.goodBye"));
            System.exit(0);
        }
    }

    private void signIn() {
        Long id;
        String name;

        System.out.println(manager.getString("login.id"));
        id = in.nextLong();
        in.nextLine();
        System.out.println(manager.getString("login.name"));
        name = in.nextLine();

        Student student = departmentService.showStudent(id);
        Objects.requireNonNull(student, "Student has not been found");

        if ( student.getName().equals(name) ) {
            operationService(student);
        } else {
            System.out.println(manager.getString("login.invalidOperation"));
        }

    }

    private void operationService(Student student) {

        boolean isFinish = false;

        while (!isFinish) {
            System.out.println(manager.getString("operation.selection"));
            int choice = in.nextInt();

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
                    TreeSet<Student> students = departmentService.showGroup(student.getGroup());

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

        System.out.println(manager.getString("operation.depName"));
        departmentName = in.next();
        System.out.println(manager.getString("operation.depId"));
        id = in.nextLong();

        department = new Department(id, departmentName);
        students = departmentService.showDepartmentStudents(department);

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

        System.out.println(manager.getString("operation.depName"));
        departmentName = in.next();
        System.out.println(manager.getString("operation.depId"));
        id = in.nextLong();
        System.out.println(manager.getString("operation.course"));
        course = in.nextInt();

        department = new Department(id, departmentName);
        students = departmentService.showDepartmentAndCourseStudents(department, course);

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

        System.out.println(manager.getString("operation.date"));
        yearOfBirth = in.nextInt();
        monthOfBirth = in.nextInt();
        dayOfBirth = in.nextInt();

        date = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        students = departmentService.showStudentsOlderThan(date);

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



        studentService.register(volchkov);
        studentService.register(ilchenko);
        studentService.register(lopuha);
        studentService.register(samsonov);
        studentService.register(piznak);
        studentService.register(kovtanyuk);

    }
}

