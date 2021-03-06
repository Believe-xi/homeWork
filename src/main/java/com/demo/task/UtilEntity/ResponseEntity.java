package com.demo.task.UtilEntity;

public class ResponseEntity<T> {
    private int status;
    private String msg;
    private T data;

    public ResponseEntity(){}
    public ResponseEntity(int status, String msg){
        setStatus(status);
        setMsg(msg);
    }
    public ResponseEntity(int status, String msg,T data){
        setStatus(status);
        setMsg(msg);
        setData(data);
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
