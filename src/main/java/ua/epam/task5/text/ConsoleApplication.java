package ua.epam.task5.text;

import ua.epam.task5.text.domain.Text;
import ua.epam.task5.text.service.TextServiceImpl;

public class ConsoleApplication {
    public static void main(String[] args) {
        String head = "Fairytale about Red Hat";
        String text = "Данный подход позволяет создавать абстракцию представления. Для этого необходимо выделить интерфейс представления с определенным набором свойств и методов. Презентер, в свою очередь, получает ссылку на реализацию интерфейса, подписывается на события представления и по запросу изменяет модель.";

        TextServiceImpl service = new TextServiceImpl();

        Text result = service.convertStringToText(head, text);
        String textToString = service.convertTextToString(result);

        System.out.println(textToString);
    }
}
