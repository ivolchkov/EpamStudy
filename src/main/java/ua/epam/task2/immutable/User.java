package ua.epam.task2.immutable;

public final class User {
    private final Address address;
    private final String name;

    public User(Address address, String name) {
        if ( address == null ) {
            this.address = null;
        } else {
            this.address = new Address(address.getCity(), address.getCode());
        }
        this.name = name;
    }

    public Address getAddress() {
        return new Address(this.address.getCity(), this.address.getCode());
    }

    public String getName() {
        return name;
    }

    public User setAddress(Address newAddress) {
        return new User(newAddress, this.name);
    }

    public User setName(String newName) {
        return new User(this.address, newName);
    }

    @Override
    public String toString() {
        return "User{" +
                "address=" + address +
                ", name='" + name + '\'' +
                '}';
    }
}
