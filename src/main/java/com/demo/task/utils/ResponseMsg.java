package com.demo.task.utils;

public class ResponseMsg<T> {
    private int status;
    private String msg;
    private T data;

    public ResponseMsg(int status, String msg){
        setStatus(status);
        setMsg(msg);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
