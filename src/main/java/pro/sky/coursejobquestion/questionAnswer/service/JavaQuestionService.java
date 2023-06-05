package pro.sky.coursejobquestion.questionAnswer.service;

import org.springframework.stereotype.Service;
import pro.sky.coursejobquestion.questionAnswer.exceptions.InputException;
import pro.sky.coursejobquestion.questionAnswer.exceptions.QuestionAlreadyAddException;
import pro.sky.coursejobquestion.questionAnswer.exceptions.QuestionNotFoundException;
import pro.sky.coursejobquestion.questionAnswer.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> javaQuestionsList = new LinkedHashSet<>(Set.of(
       new Question("Расскажите про String в Java.",""),
       new Question("Что такое interface? Может ли быть final interface?",""),
       new Question("Чем отличаются HashSet от HashMap?", ""),
       new Question("Дайте краткую характеристику Enum в Java.",""),
       new Question("Назовите все методы класса Object.",""),
       new Question("Как сравнить две строки в Java и/или отсортировать их?",""),
       new Question("В чем разница между абстрактным классом и интерфейсом в Java?",""),
       new Question("Нужно ли проверять checked exception?",""),
       new Question("Какие есть способы создания объекта String? Где он создается?",""),
       new Question("Что такое коллизия в hashCode? Как с ней бороться?",""),
       new Question("Что такое abstract? Абстрактный класс? Абстрактный метод?",""),
       new Question("Что означает ключевое слово final?",""),
       new Question("Что будет, если поле, участвующее в контракте hashCode() у объекта, меняет свое значение?",""),
       new Question("Какие методы называются геттерами? Что они делают?",""),
       new Question("Для чего применяется метод toString?",""),
       new Question("В чем преимущество ArrayList перед массивом?",""),
       new Question("Дайте определение классу в Java.",""),
       new Question("Что такое переопределение (override) метода?",""),
       new Question("Что такое массив?",""),
       new Question("Какие есть типы данных в Java?","")
    )
    );

    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        for( Question q : javaQuestionsList) {
            if (q.getQuestion().equals(newQuestion.getQuestion())){
                throw new QuestionAlreadyAddException("Данный вопрос уже был добавлен!");
            }
        }
        if (javaQuestionsList.contains(newQuestion)) {
            throw new QuestionAlreadyAddException("Данный вопрос уже был добавлен!");
        }

        add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {

        if (!validate(question)) {
            throw new InputException("Ошибка ввода!");
        }

        javaQuestionsList.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) {

        if (!javaQuestionsList.contains(question)) {
            throw new QuestionNotFoundException("Вопрос не найден!");
        }
        javaQuestionsList.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(javaQuestionsList);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(javaQuestionsList);
        int randNumber = random.nextInt(getAll().size());
        return list.get(randNumber);
    }

    public boolean validate(Question question) {
       return question != null
                && question.getQuestion() != null
                && !question.getQuestion().isEmpty()
                && !question.getQuestion().equals(question.getAnswer());
    }

}
