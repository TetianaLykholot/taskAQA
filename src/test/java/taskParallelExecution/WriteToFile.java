package taskParallelExecution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class WriteToFile extends BaseTest{
    public static ThreadLocal<String> threadLocalForUsers = new ThreadLocal<>();

    public static AtomicInteger uniqueIdGenerator = new AtomicInteger(1);

    private static final String FILE_PATH = "output.txt";

    public static synchronized void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


