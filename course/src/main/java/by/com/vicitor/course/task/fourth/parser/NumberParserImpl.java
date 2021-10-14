package by.com.vicitor.course.task.fourth.parser;

import java.util.LinkedList;
import java.util.List;

import by.com.vicitor.course.task.fourth.creator.NumberCreator;
import by.com.vicitor.course.task.fourth.creator.NumberCreatorImpl;

public class NumberParserImpl implements NumberParser {

    private static final String EMPTY_STRING = "";

    public List<List<String>> parseLineToNumbers(String line) {
        validateLine(line);
        List<Integer> digits = parseToInt(line.split(EMPTY_STRING));
        return parseDigitsToNumber(digits);
    }

    private void validateLine(String line) {
        if (line.equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("Line can not be empty");
        }
    }

    private List<Integer> parseToInt(String[] digits) {
        List<Integer> result = new LinkedList<>();

        for (String digit : digits) {
            validateNumber(digit);
            result.add(Integer.parseInt(digit));
        }
        return result;
    }

    private void validateNumber(String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("Should be number : " + number);
        }
    }

    private List<List<String>> parseDigitsToNumber(List<Integer> digits) {
        NumberCreator numberCreator = new NumberCreatorImpl();
        List<List<String>> result = new LinkedList<>();
        int biggestDigit = calculateBiggestDigit(digits);

        for (int digit : digits) {
            List<String> number = numberCreator.getNumber(digit, isBiggestDigit(digit, biggestDigit));
            result.add(number);
        }
        return result;
    }

    private int calculateBiggestDigit(List<Integer> digits) {
        int result = digits.get(0);
        for (int digit : digits) {
            if (result < digit) {
                result = digit;
            }
        }
        return result;
    }
    
    private boolean isBiggestDigit(int digit, int biggestDigit) {
        return digit == biggestDigit;
    }
}
