package ua.epam.task7.prototype;

public class Address implements Prototype{
    private String city;
    private int code;

    public Address(String city, int code) {
        this.city = city;
        this.code = code;
    }

    private Address(Address address) {
        this.city = address.city;
        this.code = address.code;
    }

    @Override
    public Prototype copy() {
        return new Address(this);
    }
}
