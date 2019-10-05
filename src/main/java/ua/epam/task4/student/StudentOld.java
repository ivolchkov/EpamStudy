package ua.epam.task4.student;

import java.time.LocalDate;

public class StudentOld implements Comparable {
    private final int id;
    private final String surname;
    private final String name;
    private final String secondName;
    private final LocalDate dateOfBirth;
    private final AddressOld address;
    private final String phoneNumber;
    private final String faculty;
    private final int course;
    private final String group;

    private StudentOld(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.surname = studentBuilder.surname;
        this.name = studentBuilder.name;
        this.secondName = studentBuilder.secondName;
        this.dateOfBirth = studentBuilder.dateOfBirth;
        this.address = studentBuilder.address;
        this.phoneNumber = studentBuilder.phoneNumber;
        this.faculty = studentBuilder.faculty;
        this.course = studentBuilder.course;
        this.group = studentBuilder.group;

        StudentHandler.addStudent(this);
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public AddressOld getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }

        if ( obj == null || this.getClass() != obj.getClass() ) {
            return false;
        }

        StudentOld other = (StudentOld) obj;

        return this.id == other.id &&
                this.course == other.course &&
                (this.name == other.name) || ( this.name != null && this.name.equals(other.name) ) &&
                (this.surname == other.surname) || ( this.surname != null && this.surname.equals(other.surname) ) &&
                (this.secondName == other.secondName) || ( this.secondName != null && this.secondName.equals(other.secondName) ) &&
                (this.faculty == other.faculty) || ( this.  faculty != null && this. faculty.equals(other.faculty) ) &&
                (this.phoneNumber == other.phoneNumber) || ( this.phoneNumber != null && this.phoneNumber.equals(other.phoneNumber) ) &&
                (this.group == other.group) || ( this.group != null && this.group.equals(other.group) ) &&
                (this.dateOfBirth == other.dateOfBirth) || ( this.dateOfBirth != null && this.dateOfBirth.equals(other.dateOfBirth) ) &&
                (this.address == other.address) || ( this.address != null && this.address.equals(other.address) );

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + id;
        result = prime * result + course;
        result = prime * result + (this.name == null ? 0 : this.name.hashCode());
        result = prime * result + (this.surname == null ? 0 : this.surname.hashCode());
        result = prime * result + (this.secondName == null ? 0 : this.secondName.hashCode());
        result = prime * result + (this.faculty == null ? 0 : this.faculty.hashCode());
        result = prime * result + (this.phoneNumber == null ? 0 : this.phoneNumber.hashCode());
        result = prime * result + (this.group == null ? 0 : this.group.hashCode());
        result = prime * result + (this.dateOfBirth == null ? 0 : this.dateOfBirth.hashCode());
        result = prime * result + (this.address == null ? 0 : this.address.hashCode());

        return result;

    }

    @Override
    public String toString() {
        StringBuilder student = new StringBuilder();

        student.append("Student №").append(id).append("\n");
        student.append("Name: ").append(name).append("\n");
        student.append("Surname: ").append(surname).append("\n");
        student.append("Second name: ").append(secondName).append("\n");
        student.append("Date of birth: ").append(dateOfBirth).append("\n");
        student.append("Address: ").append("\n").append(address).append("\n");
        student.append("Phone number: ").append(phoneNumber).append("\n");
        student.append("Faculty: ").append(faculty).append("\n");
        student.append("Course: ").append(course).append("\n");
        student.append("Group: ").append(group);

        return student.toString();
    }

    @Override
    public int compareTo(Object obj) {
        if ( obj.getClass() == this.getClass() ) {
            StudentOld other = (StudentOld) obj;

            return this.id - other.id;
        }

        throw new IllegalArgumentException();
    }

    public static StudentBuilder build() {
        return new StudentBuilder();
    }


    public static class StudentBuilder {
        private int id;
        private String surname;
        private String name;
        private String secondName;
        private LocalDate dateOfBirth;
        private AddressOld address;
        private String phoneNumber;
        private String faculty;
        private int course;
        private String group;

        private StudentBuilder() {}

        public StudentBuilder withId(int id) {
            this.id = id;

            return this;
        }

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;

            return this;
        }

        public StudentBuilder withName(String name) {
            this.name = name;

            return this;
        }

        public StudentBuilder withSecondName(String secondName) {
            this.secondName = secondName;

            return this;
        }

        public StudentBuilder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;

            return this;
        }

        public StudentBuilder withAddress(AddressOld address) {
            this.address = address;

            return this;
        }

        public StudentBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;

            return this;
        }

        public StudentBuilder withFaculty(String faculty) {
            this.faculty = faculty;

            return this;
        }

        public StudentBuilder withCourse(int course) {
            this.course = course;

            return this;
        }

        public StudentBuilder withGroup(String group) {
            this.group = group;

            return this;
        }

        public StudentOld build() {
            return new StudentOld(this);
        }
    }
}
