package pro.sky.coursejobquestion.questionAnswer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursejobquestion.questionAnswer.model.Question;
import pro.sky.coursejobquestion.questionAnswer.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")

public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/{amount}")
    public Collection<Question> getQuestions(@PathVariable(required = false) int amount) {
        return examinerService.getQuestions(amount);
    }

}
