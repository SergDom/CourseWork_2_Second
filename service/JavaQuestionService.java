package com.nomad.coursework_2_second.service;

import com.nomad.coursework_2_second.dao.Question;
import com.nomad.coursework_2_second.exceptions.BadRequestException;
import com.nomad.coursework_2_second.exceptions.EmptyQuestionListException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();


    @Override
    public Question add(String question, String answer) {

        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if  (questions.contains(question)){
           throw new BadRequestException("Такой вопрос уже есть в списке");
        }

       questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if  (!questions.contains(question)){
            throw new EmptyQuestionListException("Такого вопроса нет в списке");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));

    }
}
