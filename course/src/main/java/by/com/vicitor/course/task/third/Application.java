package by.com.vicitor.course.task.third;

public class Application {

    public static void main(String[] args) {
        String line = ConsoleReader.readLine();
        VowelCalculator calculator = new VowelCalculator();
        
        System.out.println("Count of vowel : " + calculator.calculateCountVowelsInLine(line));
        
        System.out.println("String with sorted by number of vowel in words : "
                + calculator.getLineSortedByNumberVowelsInWords(line));
        
        System.out.println(
                "String with first vowels in words are uppercase: " + calculator.makeUppercaseFirstVowelInWords(line));
    }
}
