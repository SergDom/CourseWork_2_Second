package com.nomad.coursework_2_second.service;

import com.nomad.coursework_2_second.dao.Question;
import com.nomad.coursework_2_second.exceptions.BadRequestException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl (QuestionService questionService) {

        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new BadRequestException("Запрошено вопросов больше, чем есть в базе данных");
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}
