package ua.epam.task9.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(propOrder = {"name", "surname", "email", "phone"})
public class UserToXML {
    String name;
    String surname;
    String email;
    String phone;


    public UserToXML() {
    }

    public UserToXML(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public UserToXML setName(String name) {
        this.name = name;
        return this;
    }

    public UserToXML setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserToXML setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserToXML setPhone(String phoneNumber) {
        this.phone = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "UserToXML{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phone + '\'' +
                '}';
    }
}

@XmlRootElement(name = "users")
class Users {
    List<UserToXML> users;

    public Users() {
    }

    public Users(List<UserToXML> users) {
        this.users = users;
    }

    @XmlElement(name = "user")
    public List<UserToXML> getUsers() {
        return users;
    }

    public Users setUsers(List<UserToXML> users) {
        this.users = users;
        return this;
    }
}