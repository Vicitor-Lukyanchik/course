package by.com.vicitor.course.task.second;

import java.util.List;

public class NumbersFormatter {

    private static final char SPACE = ' ';
    
    public String formatNumbers(List<Integer> numbers){
        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number).append(SPACE);
        }
        return result.toString();
    }
}
