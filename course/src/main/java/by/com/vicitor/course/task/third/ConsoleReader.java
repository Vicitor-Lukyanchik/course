package by.com.vicitor.course.task.third;

import java.util.Scanner;

public class ConsoleReader {

    public static String readLine() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input string to do some operations: ");
            return scanner.nextLine();
        }
    }
}
