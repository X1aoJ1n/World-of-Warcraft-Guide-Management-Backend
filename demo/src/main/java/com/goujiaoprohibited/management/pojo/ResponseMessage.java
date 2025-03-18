package com.goujiaoprohibited.management.pojo;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T>  {
    private int code;
    private String message;
    private T data;

    public ResponseMessage (int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseMessage<T> success (T data) {
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success", data);
    }

    public static <T> ResponseMessage<T> success () {
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success", null);
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

}
