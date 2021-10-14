package by.com.vicitor.course.task.third;

public class Word {

    private String word;
    private int countOfVowel;
    
    public Word(String word, int countOfVowel) {
        this.word = word;
        this.countOfVowel = countOfVowel;
    }

    public String getWord() {
        return word;
    }

    public int getCountOfVowel() {
        return countOfVowel;
    }
}
