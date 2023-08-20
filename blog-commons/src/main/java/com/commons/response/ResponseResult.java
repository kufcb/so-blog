package com.commons.response;

import com.google.gson.Gson;

public class ResponseResult<T> {
    private Integer status;
    private String message;
    private T data;

    public static <T> String success() {
        return success(null);
    }

    public static <T> String success(T data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(ResponseStatus.SUCCESS.getResponseCode());
        responseResult.setData(data);
        responseResult.setMessage(ResponseStatus.SUCCESS.getDescription());
        Gson gson = new Gson();
        return gson.toJson(responseResult);
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
