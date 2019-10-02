package ua.epam.task7.prototype;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Kiev", 044);
        User user = new User(address, "Oleg", "Vasilchuk");

        User user1 = (User) user.copy();
    }
}
