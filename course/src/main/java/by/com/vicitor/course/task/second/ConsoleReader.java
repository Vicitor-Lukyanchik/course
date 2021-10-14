package by.com.vicitor.course.task.second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {

    public static int readNumber() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input number to find multipliers: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("Number should be integer");
        }
    }
}
