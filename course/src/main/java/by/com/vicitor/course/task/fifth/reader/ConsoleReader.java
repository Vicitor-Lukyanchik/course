package by.com.vicitor.course.task.fifth.reader;

import java.util.Scanner;

public class ConsoleReader {

    public static int readSafeVolume() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input safe valume : ");
            return scanner.nextInt();
        }
    }
}
