package com.springacademy.pointofsale.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntryDuplicateException extends RuntimeException{

    public EntryDuplicateException(String msg){
        super(msg);
    }
}
