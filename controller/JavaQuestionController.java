package com.nomad.coursework_2_second.controller;

import com.nomad.coursework_2_second.dao.Question;
import com.nomad.coursework_2_second.service.JavaQuestionService;
import com.nomad.coursework_2_second.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService service;

    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("add")
    public Question add (@PathParam("question") String question,
                                 @PathParam ("answer") String answer){
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove (@PathParam ("question") String question,
                                 @PathParam ("answer") String answer){
        Question target = new Question(question, answer);
        return service.remove(target);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return  service.getAll();
    }
}
