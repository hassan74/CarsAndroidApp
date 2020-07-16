package com.example.taskexpert.base.entities;

public class ApiResponseBody<T> {
    T data ;
    int status ;
    Error error ;

    public T getData() {
        return data;
    }

    public void setData(T main) {
        this.data = main;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
