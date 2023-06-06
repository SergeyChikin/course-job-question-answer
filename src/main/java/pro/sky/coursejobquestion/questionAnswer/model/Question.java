package pro.sky.coursejobquestion.questionAnswer.model;

import java.util.Objects;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Question quest = (Question) obj;
        return Objects.equals(question, quest.question) &&
                Objects.equals(answer, quest.answer);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        return String.format("Вопрос: %s, ответ: %s", question, answer);
    }
}
