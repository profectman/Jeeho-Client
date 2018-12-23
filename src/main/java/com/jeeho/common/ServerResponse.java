package com.jeeho.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private int status;
    private T data;
    private String msg;

    private ServerResponse(int status){
        this.status = status;
    }

    private ServerResponse(int status,T data){
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status,String msg){
        this.msg = msg;
        this.status = status;
    }

    private ServerResponse(int status,T data,String msg){
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    /**
     * @JsonIgnore 使之不再json序列化当中
     * @return
     */
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * @param <T>
     * response success
     * @return
     */
    public static <T> ServerResponse createSuccessByStatus(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse createSuccessByMsg(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse createSuccessByData(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServerResponse createSuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data,msg);
    }

    /**
     * response error
     * @param <T>
     * @return
     */
    public static <T> ServerResponse createError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse createErrorByMsg(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T> ServerResponse createErrorCodeByMsg(int status , String msg){
        return new ServerResponse<T>(status,msg);
    }
}
