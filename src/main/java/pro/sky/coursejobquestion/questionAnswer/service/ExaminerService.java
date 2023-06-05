package pro.sky.coursejobquestion.questionAnswer.service;

import pro.sky.coursejobquestion.questionAnswer.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
