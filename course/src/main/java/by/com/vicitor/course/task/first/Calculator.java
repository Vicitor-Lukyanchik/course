package by.com.vicitor.course.task.first;

public class Calculator {

    public int calculateSumDigitInText(String line) {
        validateString(line);
        char[] symbols = line.toCharArray();
        int sumOfDigit = 0;

        for (char symbol : symbols) {
            if (Character.isDigit(symbol)) {
                sumOfDigit += Integer.parseInt(String.valueOf(symbol));
            }
        }
        return sumOfDigit;
    }

    private void validateString(String string) {
        if(string == null) {
            throw new IllegalArgumentException("Line can not be null");
        }
    }
}
