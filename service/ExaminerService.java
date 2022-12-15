package com.nomad.coursework_2_second.service;

import com.nomad.coursework_2_second.dao.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
