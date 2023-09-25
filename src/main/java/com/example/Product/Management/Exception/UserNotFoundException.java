package com.example.Product.Management.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private String userName;
    private String fieldName;
    private int fieldValue;

    public UserNotFoundException(String userName, String fieldName, int fieldValue){
        super(String.format("%s not found with %s : '%s'",userName,fieldName,fieldValue));
        this.userName=userName;
        this.fieldName=fieldName;
        this.fieldValue=fieldValue;
    }
}
