package pro.sky.coursejobquestion.questionAnswer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionsLimitException extends RuntimeException {
    public QuestionsLimitException() {
    }

    public QuestionsLimitException(String message) {
        super(message);
    }
}
