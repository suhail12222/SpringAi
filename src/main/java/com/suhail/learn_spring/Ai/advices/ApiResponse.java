package com.suhail.learn_spring.Ai.advices;

import java.time.LocalDateTime;

public class ApiResponse <T>{
    private T data;
    private ApiError apiError;
    private LocalDateTime localDateTime;
    public ApiResponse(){
        this.localDateTime=LocalDateTime.now();
    }
    public ApiResponse(T data){
        this();
        this.data=data;
    }

    public ApiResponse(ApiError apiError){
        this();
        this.apiError=apiError;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getApiError() {
        return apiError;
    }

    public void setApiError(ApiError apiError) {
        this.apiError = apiError;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
