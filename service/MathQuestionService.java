package com.nomad.coursework_2_second.service;

import com.nomad.coursework_2_second.dao.Question;
import com.nomad.coursework_2_second.dao.QuestionRepository;
import com.nomad.coursework_2_second.exceptions.BadRequestException;
import com.nomad.coursework_2_second.exceptions.EmptyQuestionListException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService{
 private final QuestionRepository questions;
 private final Random random = new Random();
 public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questions) {
     this.questions=questions;
 }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {

        if  (questions.getAll().contains(question)){
            throw new BadRequestException("Такой вопрос уже есть в списке");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {

        if  (!questions.getAll().contains(question)){
            throw new EmptyQuestionListException("Такого вопроса нет в списке");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
     return questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {

     return new ArrayList<>(questions.getAll()).get(random.nextInt(questions.getAll().size()));
    }
}
