package pro.sky.coursejobquestion.questionAnswer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.coursejobquestion.questionAnswer.exceptions.InputException;
import pro.sky.coursejobquestion.questionAnswer.exceptions.QuestionAlreadyAddException;
import pro.sky.coursejobquestion.questionAnswer.exceptions.QuestionNotFoundException;
import pro.sky.coursejobquestion.questionAnswer.model.Question;
import pro.sky.coursejobquestion.questionAnswer.service.JavaQuestionService;

public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        out.add("ВОПРОС_1","");
        out.add("ВОПРОС_2","");
        out.add("ВОПРОС_3","");
    }

    @AfterEach
    public void afterEach() {
        out.getAll()
                .forEach(question -> out.remove(question));
    }

    @Test
    public void addQuestionPositiveTest() {
        int beforeCount = out.getAll().size();
        Question expected = new Question("ВОПРОС_4", "");

        Assertions.assertThat(out.add("ВОПРОС_4", ""))
                .isEqualTo(expected)
                .isIn(out.getAll());
        Assertions.assertThat(out.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void addQuestionIfPresentTest() {
        int beforeCount = out.getAll().size();
        Assertions.assertThatExceptionOfType(QuestionAlreadyAddException.class)
                .isThrownBy(() -> out.add("ВОПРОС_3", ""));
        Assertions.assertThat(out.getAll()).hasSize(beforeCount);
    }

    @Test
    public void addQuestionNegativeTest() {
        Assertions.assertThatExceptionOfType(InputException.class)
                .isThrownBy(() -> out.add("", ""));
    }

    @Test
    public void removeQuestionPositiveTest() {
        int beforeCount = out.getAll().size();
        Question expected = new Question("ВОПРОС_3", "");

        Assertions.assertThat(out.remove(new Question("ВОПРОС_3", "")))
                .isEqualTo(expected)
                .isNotIn(out.getAll());
        Assertions.assertThat(out.getAll()).hasSize(beforeCount - 1);
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(new Question("ВОПРОС_3", "")));
    }

    @Test
    public void getAllQuestionsTest() {
        Assertions.assertThat(out.getAll())
                .hasSize(23)
                .containsExactlyInAnyOrder(
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
                        new Question("Какие есть типы данных в Java?",""),
                        new Question("ВОПРОС_1",""),
                        new Question("ВОПРОС_2",""),
                        new Question("ВОПРОС_3","")
                );

    }

}
