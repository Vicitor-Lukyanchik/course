package by.com.vicitor.course.task.fourth.reader;

import java.util.Scanner;

public class ConsoleReader {

    public static String readLine() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input number to format: ");
            return scanner.nextLine();
        }
    }
}
