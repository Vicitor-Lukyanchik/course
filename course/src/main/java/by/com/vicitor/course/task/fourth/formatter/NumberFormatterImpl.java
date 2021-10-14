package by.com.vicitor.course.task.fourth.formatter;

import java.util.List;

public class NumberFormatterImpl implements NumberFormatter {

    private static final char NEXT_LINE = '\n';
    private static final int NUMBERS_HEIGHT = 7;
    
    @Override
    public String formatNumbers(List<List<String>> numbers) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < NUMBERS_HEIGHT; i++) {
            for(List<String> number : numbers) {
                result.append(number.get(i));
            }
            result.append(NEXT_LINE);
        }
        return result.toString();
    }
}
