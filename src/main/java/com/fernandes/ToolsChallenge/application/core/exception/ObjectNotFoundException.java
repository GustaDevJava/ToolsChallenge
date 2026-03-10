package com.fernandes.ToolsChallenge.application.core.exception;

public class ObjectNotFoundException extends RuntimeException{

    private String msg;

    public ObjectNotFoundException(String msg){
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
