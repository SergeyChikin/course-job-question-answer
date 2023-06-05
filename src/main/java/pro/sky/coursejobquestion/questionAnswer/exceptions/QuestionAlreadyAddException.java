package pro.sky.coursejobquestion.questionAnswer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class QuestionAlreadyAddException extends RuntimeException {
    public QuestionAlreadyAddException() {
    }

    public QuestionAlreadyAddException(String message) {
        super(message);
    }
}
