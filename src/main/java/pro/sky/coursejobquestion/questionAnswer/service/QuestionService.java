package pro.sky.coursejobquestion.questionAnswer.service;

import pro.sky.coursejobquestion.questionAnswer.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
