package ua.epam.task5.student;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.epam.task5.student.configuration.DIConfiguration;
import ua.epam.task5.student.view.Menu;

public class ConsoleApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
        Menu menu = context.getBean(Menu.class);
        menu.run();
    }
}
