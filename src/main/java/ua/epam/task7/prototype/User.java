package ua.epam.task7.prototype;

public class User implements Prototype {
    private Address address;
    private String name;
    private String surname;

    public User(Address address, String name, String surname) {
        this.address = address;
        this.name = name;
        this.surname = surname;
    }

    private User(User user) {
        this.address = (Address) user.address.copy();
        this.name = user.name;
        this.surname = user.surname;
    }

    @Override
    public Prototype copy() {
        return new User(this);
    }
}
