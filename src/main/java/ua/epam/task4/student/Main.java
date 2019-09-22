package ua.epam.task4.student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
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
                withId(1).
                withName("Ihor").
                withSurname("Volchkov").
                withSecondName("Vasilyevich").
                withAddress(address1).
                withDateOfBirth(LocalDate.of(1997, 11, 12)).
                withPhoneNumber("+(380)-67-165-45-49").
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91m").
                build();

        Student ilchenko = Student.build().
                withId(2).
                withName("Dmitrii").
                withSurname("Ilchenko").
                withSecondName("Vasilyevich").
                withAddress(address2).
                withDateOfBirth(LocalDate.of(1997, 12, 21)).
                withPhoneNumber("+(380)-99-235-25-11").
                withFaculty("FEA").
                withCourse(5).
                withGroup("EC-91m").
                build();

        Student kovtanyuk = Student.build().
                withId(3).
                withName("Marta").
                withSurname("Kovtanyuk").
                withSecondName("Olegovna").
                withAddress(address3).
                withDateOfBirth(LocalDate.of(1998, 7, 31)).
                withPhoneNumber("+(380)-95-147-23-48").
                withFaculty("FMM").
                withCourse(5).
                withGroup("UM-91m").
                build();

        Student lopuha = Student.build().
                withId(4).
                withName("Valentyn").
                withSurname("Lopuha").
                withSecondName("Viktorovich").
                withAddress(address4).
                withDateOfBirth(LocalDate.of(1999, 1, 23)).
                withPhoneNumber("+(380)-95-122-25-66").
                withFaculty("FMM").
                withCourse(5).
                withGroup("UM-91m").
                build();

        Student piznak = Student.build().
                withId(5).
                withName("Vasiliy").
                withSurname("Piznak").
                withSecondName("Vasilyovich").
                withAddress(address5).
                withDateOfBirth(LocalDate.of(1998, 9, 19)).
                withPhoneNumber("+(380)-97-365-23-88").
                withFaculty("FIOT").
                withCourse(5).
                withGroup("IC-91m").
                build();
        Student samsonov = Student.build().
                withId(6).
                withName("Denys").
                withSurname("Samsonov").
                withSecondName("Andreevich").
                withAddress(address6).
                withDateOfBirth(LocalDate.of(1998, 2, 23)).
                withPhoneNumber("+(380)-55-223-12-28").
                withFaculty("FEA").
                withCourse(4).
                withGroup("EP-41").
                build();

//        System.out.println(volchkov);
//        System.out.println("---------------------------");
//        System.out.println(ilchenko);
//        System.out.println("---------------------------");
//        System.out.println(kovtanyuk);
//        System.out.println("---------------------------");
//        System.out.println(lopuha);
//        System.out.println("---------------------------");
//        System.out.println(piznak);

//        TreeSet<Student> fac = new TreeSet<>();
//
//        fac = StudentHandler.getFacultyStudents("FEA");
//
//        for ( Student student : fac) {
//            System.out.println(student);
//        }

//        TreeSet<Student> fac = new TreeSet<>();
//
//        fac = StudentHandler.getStudentsOlderThan(LocalDate.of(1998, 9, 20));
//
//        for ( Student student : fac) {
//            System.out.println(student);
//        }

//        TreeSet<Student> fac = new TreeSet<>();
//
//        fac = StudentHandler.getFacultyAndCourseStudents("FEA", 5);
//
//        for ( Student student : fac) {
//            System.out.println(student);
//        }

        TreeSet<Student> fac = new TreeSet<>();

        fac = StudentHandler.getGroup("EP-41");

        for ( Student student : fac) {
            System.out.println(student);
        }
    }
}
