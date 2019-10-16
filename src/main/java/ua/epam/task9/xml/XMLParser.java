package ua.epam.task9.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        XMLHandler handler = new XMLHandler();
        reader.setContentHandler(handler);
        reader.parse("/home/ivolchkov/Desktop/Epam/src/main/java/ua/epam/task9/xml/Users.xml");

        handler.getUsers().forEach(System.out::println);
    }

    private static class XMLHandler extends DefaultHandler {
        private static final String USER_TAG = "user";

        private static final String NAME_TAG = "name";
        private static final String SURNAME_TAG = "surname";
        private static final String EMAIL_TAG = "email";
        private static final String PHONE_TAG = "phone";

        private List<User> users;
        private User currentUser;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (currentElement != null && currentElement.equals(USER_TAG)) {
                currentUser = new User();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String text = new String(ch, start, length);

            text = text.replace("\n", "").trim();

            if ( !text.isEmpty() ) {
                switch (currentElement) {
                    case NAME_TAG: {
                        currentUser.name = text;
                    }
                    break;
                    case SURNAME_TAG: {
                        currentUser.surname = text;
                    }
                    break;
                    case EMAIL_TAG: {
                        currentUser.email = text;
                    }
                    break;
                    case PHONE_TAG: {
                        currentUser.phoneNumber = text;
                    }
                    break;
                    default: {
                    }
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName != null && qName.equals(USER_TAG)) {
                if (users == null) {
                    users = new ArrayList<>();
                }
                users.add(currentUser);
                currentUser = null;
            }
        }

        public List<User> getUsers() {
            return users;
        }
    }
}

class User {
    String name;
    String surname;
    String email;
    String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
