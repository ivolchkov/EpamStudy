package ua.epam.task5.text.service;

import ua.epam.task5.text.domain.Text;

public interface TextService {
    Text convertStringToText(String header, String text);
    void addSentenceToText(Text target, String sentence);
    void setTextHead(Text target, String header);
    String convertTextToString(Text text);
}
