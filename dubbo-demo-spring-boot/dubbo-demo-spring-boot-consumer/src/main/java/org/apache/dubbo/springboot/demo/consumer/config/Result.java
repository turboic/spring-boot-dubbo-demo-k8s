package org.apache.dubbo.springboot.demo.consumer.config;

public class Result<B> {
    private int code;
    private String msg;
    private B data;

    public Result(int code, String msg, B data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result failure(String msg) {
        return new Result(500, msg, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public B getData() {
        return data;
    }

    public void setData(B data) {
        this.data = data;
    }
}
