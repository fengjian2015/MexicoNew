package com.fly.ayudaconfiable.network.net.http.response;

/**
 * nakesoft
 * Created by 孔明 on 2018年9月11日,0011.
 * 158045632@qq.com
 */

public class ListResult<T> {
    private int status;
    private String msg;
    private String errmsg;
    private int total;
    private boolean success;
    private T obj;

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

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
