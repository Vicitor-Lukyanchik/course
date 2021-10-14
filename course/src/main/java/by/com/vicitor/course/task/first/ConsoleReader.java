package by.com.vicitor.course.task.first;

import java.util.Scanner;

public class ConsoleReader {

    public static String readLine() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input string to find sum of digits : ");
            return scanner.nextLine();
        }
    }
}
