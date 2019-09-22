package ua.epam.task4.text;

public class Main {
    public static void main(String[] args) {
        Word word1 = new Word("Hello");
        Sign sign1 = new Sign(',');
        Word[] words = {new Word("I"), new Word("am"), new Word("student"), new Word("of"), new Word("EPAM"), new Word("courses")};
        Sign dot = new Sign('.');

        Sentence first = new Sentence();
        first.addWords(word1);
        first.addSign(sign1);
        first.addSign(new Sign(' '));
        first.addWords(words);
        first.addSign(dot);

        Word[] secWords = {new Word("I"), new Word("have"), new Word("been"), new Word("studying"), new Word("for"), new Word("two"),
                new Word("weeks"), new Word("and"), new Word("now"),new Word("I"), new Word("have"), new Word("this"), new Word("task") };

        Sentence second = new Sentence();
        second.addWords(secWords);
        second.addSign(dot);

        Text study = new Text();

        study.setTextHead("Epam study");
        study.addSentence(first);
        study.addSentence(second);
        study.addSentence(second);
        study.addSentence(second);study.addSentence(second);study.addSentence(second);study.addSentence(second);study.addSentence(second);
        study.addSentence(second);study.addSentence(second);study.addSentence(second);study.addSentence(second);study.addSentence(second);




        System.out.println(study);
//        System.out.println(first);
    }
}
