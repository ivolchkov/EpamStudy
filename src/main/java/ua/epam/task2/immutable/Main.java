package ua.epam.task2.immutable;

public class Main {
    public static void main(String[] args) {
        String name = "Victor";
        Address adr = new Address("Kiev", 3056);
        Address adr2 = new Address("Dnipro", 2569);
        User usr = new User(adr, name);

        System.out.println(adr);
        System.out.println(usr);

        adr = adr2;

        System.out.println(adr);
        System.out.println(usr);



    }
}
