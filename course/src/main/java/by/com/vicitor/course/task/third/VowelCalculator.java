package by.com.vicitor.course.task.third;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class VowelCalculator {

    private static final char[] LOWERCASE_VOWELS = { 'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я' };
    private static final char[] UPPERCASE_VOWELS = { 'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я' };
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";

    public String getLineSortedByNumberVowelsInWords(String line) {
        validateLine(line);
        List<Word> words = calculateNumberVowelsInWords(line.split(SPACE));
        return formatWords(sortWordsByNumberVowels(words));
    }

    private void validateLine(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Line can not be null");
        }
    }

    private List<Word> calculateNumberVowelsInWords(String[] words) {
        List<Word> result = new LinkedList<>();
        for (String word : words) {
            result.add(new Word(word, calculateCountVowelsInLine(word)));
        }
        return result;
    }

    private List<Word> sortWordsByNumberVowels(List<Word> words) {
        return words.stream().sorted(Comparator.comparing(Word::getCountOfVowel).reversed())
                .collect(Collectors.toList());
    }

    private String formatWords(List<Word> words) {
        StringBuilder result = new StringBuilder();
        for (Word word : words) {
            result.append(word.getWord()).append(SPACE);
        }
        return result.toString();
    }

    public int calculateCountVowelsInLine(String line) {
        char[] symbols = line.toCharArray();
        int countOfVowels = 0;

        for (char symbol : symbols) {
            if (isLowercaseVowel(symbol) || isUppercaseVowel(symbol)) {
                countOfVowels++;
            }
        }
        return countOfVowels;
    }

    public String makeUppercaseFirstVowelInWords(String line) {
        String[] words = line.split(SPACE);
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(makeUppercaseFirstVowelInWord(word)).append(SPACE);
        }
        return result.toString();
    }

    private String makeUppercaseFirstVowelInWord(String word) {
        char[] symbols = word.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            if (isUppercaseVowel(symbols[i])) {
                return word;
            }
            if (isLowercaseVowel(symbols[i])) {
                symbols[i] = Character.toUpperCase(symbols[i]);
                return String.join(EMPTY_STRING, String.valueOf(symbols));
            }
        }
        return word;
    }

    private boolean isUppercaseVowel(char symbol) {
        for (char vowel : UPPERCASE_VOWELS) {
            if (symbol == vowel) {
                return true;
            }
        }
        return false;
    }

    private boolean isLowercaseVowel(char symbol) {
        for (char vowel : LOWERCASE_VOWELS) {
            if (symbol == vowel) {
                return true;
            }
        }
        return false;
    }
}
