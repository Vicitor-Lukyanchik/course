package by.com.vicitor.course.task.fourth.creator;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NumberCreatorImpl implements NumberCreator {

    private static final String EMPTY_LINE = "";
    private static final String SPACE = " ";
    private static final String NUMBER_STROKE = "*";
    private Map<Integer, List<String>> numbers;

    public NumberCreatorImpl() {
        this.numbers = initNumbers();
    }
    
    private static Map<Integer, List<String>> initNumbers() {
        Map<Integer, List<String>> result = new LinkedHashMap<>();

        result.put(0, Arrays.asList(SPACE + NUMBER_STROKE.repeat(3) + SPACE.repeat(2),
                        NUMBER_STROKE + SPACE.repeat(3) + NUMBER_STROKE + SPACE,
                        NUMBER_STROKE + SPACE.repeat(3) + NUMBER_STROKE + SPACE,
                        NUMBER_STROKE + SPACE.repeat(3) + NUMBER_STROKE + SPACE,
                        NUMBER_STROKE + SPACE.repeat(3) + NUMBER_STROKE + SPACE,
                        NUMBER_STROKE + SPACE.repeat(3) + NUMBER_STROKE + SPACE,
                        SPACE + NUMBER_STROKE.repeat(3) + SPACE.repeat(2)));

        result.put(1, Arrays.asList(SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(3),
                SPACE + NUMBER_STROKE.repeat(2) + SPACE.repeat(3), SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(3),
                SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(3), SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(3),
                SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(3), SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(3)));

        result.put(2, Arrays.asList(NUMBER_STROKE.repeat(4) + SPACE.repeat(2),
                SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                NUMBER_STROKE.repeat(4) + SPACE.repeat(2), NUMBER_STROKE + SPACE.repeat(5),
                NUMBER_STROKE + SPACE.repeat(5), NUMBER_STROKE.repeat(4) + SPACE.repeat(2)));

        result.put(3, Arrays.asList(NUMBER_STROKE.repeat(4) + SPACE.repeat(2),
                SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                NUMBER_STROKE.repeat(4) + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), NUMBER_STROKE.repeat(4) + SPACE.repeat(2)));

        result.put(4, Arrays.asList(SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                SPACE.repeat(2) + NUMBER_STROKE.repeat(2) + SPACE.repeat(2),
                SPACE + NUMBER_STROKE + SPACE + NUMBER_STROKE + SPACE.repeat(2),
                NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2), NUMBER_STROKE.repeat(5) + SPACE,
                SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2)));

        result.put(5, Arrays.asList(NUMBER_STROKE.repeat(4) + SPACE.repeat(2), NUMBER_STROKE + SPACE.repeat(5),
                        NUMBER_STROKE + SPACE.repeat(5), NUMBER_STROKE.repeat(4) + SPACE.repeat(2),
                        SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                        SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), NUMBER_STROKE.repeat(4) + SPACE.repeat(2)));

        result.put(6, Arrays.asList(NUMBER_STROKE.repeat(4) + SPACE.repeat(2), NUMBER_STROKE + SPACE.repeat(5),
                        NUMBER_STROKE + SPACE.repeat(5), NUMBER_STROKE.repeat(4) + SPACE.repeat(2),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        NUMBER_STROKE.repeat(4) + SPACE.repeat(2)));

        result.put(7, Arrays.asList(NUMBER_STROKE.repeat(4) + SPACE.repeat(2),
                SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2)));

        result.put(8, Arrays.asList(SPACE + NUMBER_STROKE.repeat(2) + SPACE.repeat(3),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        SPACE + NUMBER_STROKE.repeat(2) + SPACE.repeat(3),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        SPACE + NUMBER_STROKE.repeat(2) + SPACE.repeat(3)));

        result.put(9, Arrays.asList(NUMBER_STROKE.repeat(4) + SPACE.repeat(2),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        NUMBER_STROKE + SPACE.repeat(2) + NUMBER_STROKE + SPACE.repeat(2),
                        NUMBER_STROKE.repeat(4) + SPACE.repeat(2), SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2),
                        SPACE.repeat(3) + NUMBER_STROKE + SPACE.repeat(2), NUMBER_STROKE.repeat(4) + SPACE.repeat(2)));

        return result;
    }
    
    @Override
    public List<String> getNumber(int digit, boolean isBiggestDigit) {
        validateDigit(digit);
        if (isBiggestDigit) {
            return refactorNumber(numbers.get(digit), String.valueOf(digit));
        }
        return numbers.get(digit);
    }
    
    private void validateDigit(int digit) {
        if(digit < 0 || digit > 9) {
            throw new IllegalArgumentException("Digit can not be less then zero or mere than 9");
        }
    }
    
    private List<String> refactorNumber(List<String> number, String digit) {
        List<String> result = new LinkedList<>();
        for(String line : number) {
            result.add(replaceStroke(line.split(EMPTY_LINE), digit));
        }
        return result;
    }
    
    private String replaceStroke(String[] symbols, String digit) {
        String result = EMPTY_LINE;
        for(String symbol : symbols) { 
            if (symbol.equals(NUMBER_STROKE)) {
                symbol = digit;
            }
            result += symbol;
        }
        return result;
    }
}
