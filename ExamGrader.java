import java.util.*;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String text, String correctAnswer, String studentAnswer, int points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }
    public abstract double grade();
}

class MCQ extends Question {
    public MCQ(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;[cite: 1]
    }
}

class TF extends Question {
    public TF(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double grade() {
        return studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim()) ? points : 0.0;[cite: 1]
    }
}

class Essay extends Question {
    public Essay(String text, String correctAnswer, String studentAnswer, int points) {
        super(text, correctAnswer, studentAnswer, points);
    }
    @Override
    public double grade() {
        String[] keywords = correctAnswer.split(",");
        String studentLower = studentAnswer.toLowerCase();
        int matches = 0;
        for (String kw : keywords) {
            if (studentLower.contains(kw.trim().toLowerCase())) {
                matches++;
            }
        }
        if (matches >= 2) return points * 0.75;
        else if (matches == 1) return points * 0.50;
        return 0.0;
    }
}