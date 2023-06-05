package pro.sky.coursejobquestion.questionAnswer.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursejobquestion.questionAnswer.model.Question;
import pro.sky.coursejobquestion.questionAnswer.service.JavaQuestionService;

@RestController
@RequestMapping(path = "/exam/")

public class JavaQuestionController {

    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("java/add")
    public Object addQuestion(@RequestParam("question") String question,
                              @RequestParam("answer") String answer) {

           return javaQuestionService.add(question, answer);
    }

    @GetMapping("java/remove")
    public Object removeQuestion(@RequestParam("question") String question,
                                 @RequestParam("answer") String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }

    @GetMapping("/java")
    public Object getAll() {
        return javaQuestionService.getAll();
    }
}
