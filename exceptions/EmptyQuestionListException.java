package com.nomad.coursework_2_second.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyQuestionListException extends RuntimeException{
    public EmptyQuestionListException(String message){
        super(message);
    }
}
