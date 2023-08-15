package com.commons.response;

public class ResponseResult<T> {
    private Integer status;
    private String message;
    private T data;

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    public static <T> ResponseResult<T> success(T data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setStatus(ResponseStatus.SUCCESS.getResponseCode());
        responseResult.setData(data);
        responseResult.setMessage(ResponseStatus.SUCCESS.getDescription());
        return responseResult;
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
