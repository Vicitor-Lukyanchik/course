package by.com.vicitor.course.task.second;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Integer> multipliers = calculator.findMultiplier(ConsoleReader.readNumber());
        NumbersFormatter numbersFormatter = new NumbersFormatter();
        System.out.println(numbersFormatter.formatNumbers(multipliers));
    } 
}
