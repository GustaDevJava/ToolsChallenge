package com.fernandes.ToolsChallenge.application.core.exception;

public class ApiException extends RuntimeException{

    private Integer codigo;
    private String msg;

    public ApiException(Integer codigo, String msg){
        super(msg);
        this.codigo = codigo;
        this.msg = msg;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMsg() {
        return msg;
    }
}
