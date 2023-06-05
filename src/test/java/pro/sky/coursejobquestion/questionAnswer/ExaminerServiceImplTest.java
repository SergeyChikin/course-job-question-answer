package pro.sky.coursejobquestion.questionAnswer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursejobquestion.questionAnswer.exceptions.QuestionsLimitException;
import pro.sky.coursejobquestion.questionAnswer.model.Question;
import pro.sky.coursejobquestion.questionAnswer.service.ExaminerServiceImpl;
import pro.sky.coursejobquestion.questionAnswer.service.JavaQuestionService;

import java.util.Collection;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestion;

    @InjectMocks
    private ExaminerServiceImpl examiner;

    @BeforeEach
    public void beforeEach() {
        when(javaQuestion.getAll()).thenReturn( Set.of(
                new Question("ВОПРОС_1",""),
                new Question("ВОПРОС_2",""),
                new Question("ВОПРОС_3",""),
                new Question("ВОПРОС_4",""),
                new Question("ВОПРОС_5",""),
                new Question("ВОПРОС_6",""),
                new Question("ВОПРОС_7",""),
                new Question("ВОПРОС_8",""),
                new Question("ВОПРОС_9",""),
                new Question("ВОПРОС_10","")
        )
        );
    }

    @Test
    public void getQuestionsTest() {
        when(javaQuestion.getRandomQuestion()).thenReturn( new Question("ВОПРОС_1",""));
        Question expected = new Question("ВОПРОС_1", "");

        Assertions.assertThat(examiner.getQuestions(1)).containsExactlyInAnyOrder(expected)
                .hasSize(1);
    }


    @Test
    public void getQuestionsNegativeTest() {
        Assertions.assertThatExceptionOfType(QuestionsLimitException.class)
                .isThrownBy(() -> examiner.getQuestions(11));
    }

}
