package ua.epam.task9.statistic;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        FileStatistic stat = new FileStatistic();

        Map<Character,Integer> map = stat.getFileStatisticWithFileReader("/home/ivolchkov/Desktop/Epam/src/main/java/ua/epam/task9/statistic/symbols.txt");

//        for (Map.Entry<Character,Integer> entry: map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
        stat.writeStatisticToFile(map, "/home/ivolchkov/Desktop/Epam/src/main/java/ua/epam/task9/statistic/statistic.txt");
    }
}
