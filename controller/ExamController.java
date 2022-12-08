package com.nomad.coursework_2_second.controller;

import com.nomad.coursework_2_second.dao.Question;
import com.nomad.coursework_2_second.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService){
        this.examinerService=examinerService;
    }

    @GetMapping( "/get/{amount}")
    public Collection <Question> getQuestions (@PathVariable ("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
