package ua.epam.task5.student.domain;

import java.time.LocalDate;

public class Student {
    private Long id;
    private String surname;
    private String name;
    private String secondName;
    private String email;
    private LocalDate dateOfBirth;
    private Address address;
    private PhoneNumber phoneNumber;
    private Department department;
    private int course;
    private String group;
    private String password;

    private Student(StudentBuilder studentBuilder) {
        this.surname = studentBuilder.surname;
        this.name = studentBuilder.name;
        this.secondName = studentBuilder.secondName;
        this.email = studentBuilder.email;
        this.dateOfBirth = studentBuilder.dateOfBirth;
        this.address = studentBuilder.address;
        this.phoneNumber = studentBuilder.phoneNumber;
        this.department = studentBuilder.department;
        this.course = studentBuilder.course;
        this.group = studentBuilder.group;
        this.password = studentBuilder.password;

        BuilderSetId.setId(this);
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
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

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }

        if ( obj == null || this.getClass() != obj.getClass() ) {
            return false;
        }

        Student other = (Student) obj;

        return this.id == other.id &&
                this.course == other.course &&
                (this.name == other.name) || ( this.name != null && this.name.equals(other.name) ) &&
                (this.surname == other.surname) || ( this.surname != null && this.surname.equals(other.surname) ) &&
                (this.secondName == other.secondName) || ( this.secondName != null && this.secondName.equals(other.secondName) ) &&
                (this.email == other.email) || ( this.email != null && this.email.equals(other.email) ) &&
                (this.department == other.department) || ( this.  department != null && this. department.equals(other.department) ) &&
                (this.phoneNumber == other.phoneNumber) || ( this.phoneNumber != null && this.phoneNumber.equals(other.phoneNumber) ) &&
                (this.group == other.group) || ( this.group != null && this.group.equals(other.group) ) &&
                (this.dateOfBirth == other.dateOfBirth) || ( this.dateOfBirth != null && this.dateOfBirth.equals(other.dateOfBirth) ) &&
                (this.address == other.address) || ( this.address != null && this.address.equals(other.address) );

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = (int) (prime * result + id);
        result = prime * result + course;
        result = prime * result + (this.name == null ? 0 : this.name.hashCode());
        result = prime * result + (this.surname == null ? 0 : this.surname.hashCode());
        result = prime * result + (this.secondName == null ? 0 : this.secondName.hashCode());
        result = prime * result + (this.department == null ? 0 : this.department.hashCode());
        result = prime * result + (this.email == null ? 0 : this.email.hashCode());
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
        student.append("Email:").append(email).append("\n");
        student.append("Date of birth: ").append(dateOfBirth).append("\n");
        student.append("Address: ").append("\n").append(address).append("\n");
        student.append("Phone number: ").append(phoneNumber).append("\n");
        student.append("Faculty: ").append(department).append("\n");
        student.append("Course: ").append(course).append("\n");
        student.append("Group: ").append(group);

        return student.toString();
    }

    public static StudentBuilder build() {
        return new StudentBuilder();
    }

    public static BuilderSetPassword buildPassword() {
        return new BuilderSetPassword();
    }

    public static class StudentBuilder {
        private Long id = null;
        private String surname;
        private String name;
        private String secondName;
        private String email;
        private LocalDate dateOfBirth;
        private Address address;
        private PhoneNumber phoneNumber;
        private Department department;
        private int course;
        private String group;
        private String password;

        private StudentBuilder() {}
        

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

        public StudentBuilder withEmail(String email) {
            this.email = email;

            return this;
        }


        public StudentBuilder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;

            return this;
        }

        public StudentBuilder withAddress(Address address) {
            this.address = address;

            return this;
        }

        public StudentBuilder withPhoneNumber(PhoneNumber phoneNumber) {
            this.phoneNumber = phoneNumber;

            return this;
        }

        public StudentBuilder withDepartment(Department department) {
            this.department = department;

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

        public StudentBuilder withPassword(String password) {
            this.password = password;

            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
    
    public static class BuilderSetId {
        private static Long counter = 0L;

        private BuilderSetId() {
            throw new RuntimeException();
        }
        
        private static void setId(Student student) {
            student.id = ++counter;
        }
    }

    public static class BuilderSetPassword {
        private BuilderSetPassword() {
        }

        public void setPassword(Student student, String password) {
            student.password = password;
        }
    }
}
