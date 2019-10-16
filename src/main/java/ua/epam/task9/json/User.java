package ua.epam.task9.json;

public class User {
    String name;
    String surname;
    String email;
    String phone;
    Address address;

    public User(String name, String surname, String email, String phone, Address address) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    static class Address {
        String city;
        Integer postcode;

        public Address(String city, Integer postcode) {
            this.city = city;
            this.postcode = postcode;
        }

        @Override
        public String toString() {
            return
                    "city='" + city + '\'' +
                    ", postcode=" + postcode;
        }
    }
}
