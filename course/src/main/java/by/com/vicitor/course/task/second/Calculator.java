package by.com.vicitor.course.task.second;

import java.util.LinkedList;
import java.util.List;

public class Calculator {

    private static final int MIN_MULTIPLIER = 2;
    
    public List<Integer> findMultiplier(int number) {
        validateNumber(number);
        int currentValue = number;
        int multiplier = MIN_MULTIPLIER;
        List<Integer> result = new LinkedList<>();

        while (currentValue >= MIN_MULTIPLIER && multiplier <= Math.sqrt(number)) {
            if (currentValue % multiplier == 0) {
                result.add(multiplier);
                currentValue /= multiplier;
            } else {
                multiplier = getNextMultiplier(multiplier);
            }
        }
        if (currentValue > 1) {
            result.add(currentValue);
        }
        return result;
    }

    private void validateNumber(int number) {
        if (number == 0 || number == 1) {
            throw new IllegalArgumentException("Number can not be zero or one");
        }
    }
    
    private int getNextMultiplier(int multiplier) {
        if (multiplier == MIN_MULTIPLIER) {
            return 3;
        }
        return multiplier + MIN_MULTIPLIER;
    }
}
