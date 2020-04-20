package com.rec.movie.domain;


public class Result<T> {
    private Integer code;

    private String message;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public  Result success(T data){
        Result result = new Result();
        result.setCode(0);
        result.setData(data);
        result.setMessage("操作成功");
        return result;
    }

    public  Result success(){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("操作成功");
        return result;
    }

    @Override
    public String toString() {
        return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
    }


}
