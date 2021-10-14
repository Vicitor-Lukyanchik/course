package by.com.vicitor.course.task.fourth;

import by.com.vicitor.course.task.fourth.formatter.NumberFormatter;
import by.com.vicitor.course.task.fourth.formatter.NumberFormatterImpl;
import by.com.vicitor.course.task.fourth.parser.NumberParser;
import by.com.vicitor.course.task.fourth.parser.NumberParserImpl;
import by.com.vicitor.course.task.fourth.reader.ConsoleReader;

public class Application {

    public static void main(String[] args) {
        String text = ConsoleReader.readLine();
        NumberParser numberParser = new NumberParserImpl();
        NumberFormatter numberFormatter = new NumberFormatterImpl();
        System.out.println(numberFormatter.formatNumbers(numberParser.parseLineToNumbers(text)));
    } 
}
