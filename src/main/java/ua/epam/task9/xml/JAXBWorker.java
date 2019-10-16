package ua.epam.task9.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JAXBWorker {
    public static void main(String[] args) {
        String filename = "/home/ivolchkov/Desktop/Epam/src/main/java/ua/epam/task9/xml/UserToXML.xml";

        UserToXML user = new UserToXML("Ihor", "Volchkov", "igoril@gmail.com", "+380501635233");
        UserToXML user2 = new UserToXML("Andrew", "Monah", "monah@gmail.com", "+380645893514");
        List<UserToXML> userList = Arrays.asList(user, user2);
        Users users = new Users(userList);
        convertObjectToXML(users, filename);

        Users unmarshedUsers = fromXMLToObject(filename);

        if ( unmarshedUsers != null ) {
            unmarshedUsers.getUsers().forEach(System.out::println);
        }
    }

    private static Users fromXMLToObject(String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserToXML.class, Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (Users) unmarshaller.unmarshal(new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void convertObjectToXML(Users users, String filename) {
        try {
            JAXBContext context = JAXBContext.newInstance(UserToXML.class, Users.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(users, new File(filename));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
