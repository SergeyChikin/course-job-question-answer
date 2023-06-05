package pro.sky.coursejobquestion.questionAnswer.service;

import org.springframework.stereotype.Service;
import pro.sky.coursejobquestion.questionAnswer.exceptions.QuestionsLimitException;
import pro.sky.coursejobquestion.questionAnswer.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int numberOfQuestions = javaQuestionService.getAll().size();
        if (numberOfQuestions < amount) {
            throw new QuestionsLimitException("Заданное число вопросов превышает кол-во сохранённых!");
        }

        Set<Question> listOfQuestions = new HashSet<>();

        while (listOfQuestions.size() < amount) {
            listOfQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return listOfQuestions;
    }

}
