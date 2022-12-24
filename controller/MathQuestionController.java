package com.nomad.coursework_2_second.controller;

import com.nomad.coursework_2_second.dao.Question;
import com.nomad.coursework_2_second.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("add")
    public Question add (@PathParam("question") String question,
                         @PathParam ("answer") String answer){
        return questionService.add(new Question(question, answer));
    }

    @GetMapping("/remove")
    public Question remove (@PathParam ("question") String question,
                            @PathParam ("answer") String answer){
        Question target = new Question(question, answer);
        return questionService.remove(target);
    }

    @GetMapping
    public Collection<Question> getAll() {

        return  questionService.getAll();
    }
}
