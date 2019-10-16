package ua.epam.task9.statistic;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class FileStatistic {

    public Map<Character, Integer> getFileStatistic(String filename) {
        Map<Character, Integer> statistic = new TreeMap<>();
        int count = 0;

        try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get(filename))) {
            ByteBuffer mBuff = ByteBuffer.allocate(64);

            do {
                count = fChan.read(mBuff);

                if (count != -1) {
                    mBuff.rewind();
                    parseChar(statistic, count, mBuff);
                }

            } while (count != -1);
        } catch (InvalidPathException e) {
            System.out.println("Invalid path exception" + e);
        } catch (IOException e) {
            System.out.println("Input/Output exception" + e);
        }

        return statistic;
    }

    private void parseChar(Map<Character, Integer> statistic, int count, ByteBuffer mBuff) {
        for (int i = 0; i < count; i++) {
            char key = (char) mBuff.get();

            if (key == ' ') {
                continue;
            }

            if (statistic.containsKey(key)) {
                statistic.put(key, statistic.get(key) + 1);
            } else {
                statistic.put(key, 1);
            }
        }
    }

    public Map<Character, Integer> getFileStatisticWithFileReader (String filename) {
        Map<Character, Integer> statistic = new TreeMap<>();
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
             while (count != -1) {
                count = reader.read();
                char key = (char) count;

                if (key != ' ' ) {
                    if (statistic.containsKey(key)) {
                        statistic.put(key, statistic.get(key) + 1);
                    } else {
                        statistic.put(key, 1);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Input/Output exception" + e);
        }

        return statistic;
    }

    public void writeStatisticToFile(Map<Character, Integer> statistic, String filename) {
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(filename)) ){
            if ( statistic == null ) {
                return;
            }

            for (Map.Entry<Character,Integer> entry: statistic.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
