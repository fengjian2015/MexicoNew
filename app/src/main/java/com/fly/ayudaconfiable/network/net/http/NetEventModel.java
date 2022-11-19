package com.fly.ayudaconfiable.network.net.http;


/**
 * lucksoft
 * Created by AndroidDevelop on 2022/6/30.
 * 158045632@qq.com
 */
public class NetEventModel {
    public String requestId = "";
    public long fetch_duration = 0;           // call 请求发出到拿到数据，不包括本地排队时间
    public long dns_duration = 0;             //dns解析时间
    public long connect_duration = 0;         // connect 创建socket通道时间
    public long secure_duration = 0;          // ssl握手时间，connect_duration包含secure_duration
    public long reqheader_duration = 0;       //header上行耗时
    public long request_duration = 0;         // writeBytes的时间 body上行耗时
    public long resheader_duration = 0;       // header下行耗时
    public long response_duration = 0;        // readBytes的时间  body下行耗时

    public long serve_duration = 0; // 相当于responseStartDate - requestEndDate

    public long getFetch_duration() {
        return fetch_duration;
    }

    public void setFetch_duration(long fetch_duration) {
        this.fetch_duration = fetch_duration;
    }

    public long getDns_duration() {
        return dns_duration;
    }

    public void setDns_duration(long dns_duration) {
        this.dns_duration = dns_duration;
    }

    public long getConnect_duration() {
        return connect_duration;
    }

    public void setConnect_duration(long connect_duration) {
        this.connect_duration = connect_duration;
    }

    public long getSecure_duration() {
        return secure_duration;
    }

    public void setSecure_duration(long secure_duration) {
        this.secure_duration = secure_duration;
    }

    public long getRequest_duration() {
        return request_duration;
    }

    public void setRequest_duration(long request_duration) {
        this.request_duration = request_duration;
    }

    public long getResponse_duration() {
        return response_duration;
    }

    public void setResponse_duration(long response_duration) {
        this.response_duration = response_duration;
    }

    public long getServe_duration() {
        return serve_duration;
    }

    public void setServe_duration(long serve_duration) {
        this.serve_duration = serve_duration;
    }

    public long getReqheader_duration() {
        return reqheader_duration;
    }

    public void setReqheader_duration(long reqheader_duration) {
        this.reqheader_duration = reqheader_duration;
    }

    public long getResheader_duration() {
        return resheader_duration;
    }

    public void setResheader_duration(long resheader_duration) {
        this.resheader_duration = resheader_duration;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
