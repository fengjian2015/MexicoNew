package com.fly.ayudaconfiable.network.net.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import com.fly.ayudaconfiable.utils.LogUtils;
import com.google.gson.Gson;

public class AccessTokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (Exception exc) {
            LogUtils.e("exception in " + exc);
            throw exc;// new IOException("Canceled");
        }

        String returnCode = null;
        if (response == null) {
            LogUtils.e("  expton error .so next ");
            return chain.proceed(request);//丢给下一轮处理
        }
        Headers headers = response.headers();
        if (headers == null) {
            LogUtils.d(" 直接返回，不用处理了 ");
            return response;
        }
        for (int i = 0, count = headers.size(); i < count; i++) {
            String name = headers.name(i);
            if (name.equalsIgnoreCase("ReturnCode")) {
                returnCode = headers.value(i);

                break;
            }
        }

        if (returnCode != null) {
            if (returnCode.equals("997")) {
                //令牌参数异常
                //退到登录
                //GlobalApplication.jumpToLoginActivity(false, "令牌参数异常");
            } else if (returnCode.equals("998")) {
                //令牌无效
                //退到登录
                //GlobalApplication.jumpToLoginActivity(false, "令牌无效");
            } else if (returnCode.equals("999")) {
                //令牌过期
                //重新获取令牌
                HashMap<String, String> params = new HashMap<>();
                if (params != null) {
                    String requestUrl = "";//GlobalApplication.getChainAccessTokenUrlAndParam(params);
                    int paramCount = params.size();
                    if (requestUrl != null && paramCount > 0) {
                        NetClient.Param[] param = new NetClient.Param[paramCount];
                        if (param != null) {
                            int i = 0;
                            Set<HashMap.Entry<String, String>> entries = params.entrySet();
                            for (HashMap.Entry<String, String> entry : entries) {
                                param[i++] = new NetClient.Param(entry.getKey(), entry.getValue());
                            }

                            boolean hasError = true;
                            String token = null;

                            Response tokenResponse = NetClient.post(requestUrl, false, param);
                            if (tokenResponse != null) {
                                int responseCode = tokenResponse.code();
                                if (responseCode == 200) {
                                    try {
                                        String tokenBody = tokenResponse.body().string();
                                        HashMap<String, String> data = new HashMap<>();
                                        data = new Gson().fromJson(tokenBody, data.getClass());
                                        if (data != null) {
                                            int state = 0;
                                            String resultCode = null;

                                            Object status = data.get("status");
                                            if (status instanceof Double) {
                                                state = ((Double) status).intValue();
                                            } else if (status instanceof Integer) {
                                                state = ((Integer) status).intValue();
                                            }

                                            String tempValue = data.get("code");
                                            if (tempValue != null) {
                                                resultCode = tempValue;
                                            }
                                            if (state == 1 && resultCode != null && resultCode.equals("00")) {
                                                token = data.get("data");
                                                if (token != null) {
                                                    hasError = false;
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                        LogUtils.e(e.toString());
                                    }
                                }
                                tokenResponse.close();
                            }

                            if (hasError) {
                                //GlobalApplication.jumpToLoginActivity(false, "获取令牌失败");
                            } else {
                                if (request.body() instanceof FormBody) {
                                    //重新发起请求
                                    Request.Builder requestBuilder = request.newBuilder();

                                    FormBody.Builder newFormBody = new FormBody.Builder();
                                    FormBody oldFormBody = (FormBody) request.body();
                                    for (i = 0; i < oldFormBody.size(); i++) {
                                        String name = oldFormBody.encodedName(i);
                                        if (name.equals("AccessToken")) {
                                            newFormBody.addEncoded(name, token);
                                        } else {
                                            newFormBody.addEncoded(name, oldFormBody.encodedValue(i));
                                        }
                                    }
                                    requestBuilder.method(request.method(), newFormBody.build());

                                    request = requestBuilder.build();
                                    response.body().close();

                                    return chain.proceed(request);
                                }
                            }
                        }
                    }
                }
            }
        }

        return response;
    }
}