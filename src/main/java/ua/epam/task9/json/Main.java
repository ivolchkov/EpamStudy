package ua.epam.task9.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().
                registerTypeAdapter(User.class, new UserConverter()).
                create();
        try (FileReader reader = new FileReader("/home/ivolchkov/Desktop/Epam/src/main/java/ua/epam/task9/json/user.json") ) {
            User fromJson = gson.fromJson(reader, User.class);
            System.out.println(fromJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User("Andrew", "Mickevic", "andrew@gmail.com", "+380654589874", new User.Address("Kiev", 4052));

        try (FileWriter fileWriter = new FileWriter("/home/ivolchkov/Desktop/Epam/src/main/java/ua/epam/task9/json/userToJson.json");){
            fileWriter.write(gson.toJson(user));

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
