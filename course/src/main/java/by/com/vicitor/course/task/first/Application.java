package by.com.vicitor.course.task.first;

public class Application {

    public static void main(String[] args) {
        String text = ConsoleReader.readLine();
        Calculator calculator = new Calculator();
        System.out.println("The sum of the digits in this string : " + calculator.calculateSumDigitInText(text));
    } 
}
