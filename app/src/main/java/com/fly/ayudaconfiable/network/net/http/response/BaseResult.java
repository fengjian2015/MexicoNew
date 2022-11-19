
package com.fly.ayudaconfiable.network.net.http.response;

public class BaseResult<M, T, P> extends Result {
    private M data;
    private T rows;
    private P extend;

    public BaseResult(int status, String msg) {
    }

    public BaseResult() {
    }

    public M getData() {
        return data;
    }

    public void setData(M obj) {
        this.data = obj;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public P getExtend() {
        return extend;
    }

    public void setExtend(P extend) {
        this.extend = extend;
    }
}
