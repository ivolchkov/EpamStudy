package ua.epam.task6.userCompare;

public class Main {
    public static void main(String[] args) {
        User igor = new User("Igor", "Volchkov", 21);
        User andriy = new User("Andrii", "Reks", 22);
        User anya = new User("Anna", "Altynpara", 22);
        User ivan = new User("Ivan", "Vasilyuk", 20);
        User ivanka = new User("Ivan", "Vasilyuk", 19);
        User ivanka2 = new User("Ivanka", "Vasilyuk", 19);
        User dima = new User("Dima", "Yakimov", 24);
        User antonyuk = new User("Kuzma", "Antonyuk", 28);

        User[] students = User.getUsers();

//        for (User student : students) {
//            System.out.println(student);
//        }
//
//        int compare = "Antonyuk".compareTo("Altynpara");
//        int compareUsers = antonyuk.compareTo(anya);
//        System.out.println(compareUsers);

        CompareService.selectSort(students);;

        for (User student : students) {
            System.out.println(student);
        }
    }
}
