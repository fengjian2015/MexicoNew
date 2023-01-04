package com.fly.ayudaconfiable.network.net.http;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.fly.ayudaconfiable.BuildConfig;
import com.fly.ayudaconfiable.network.GzipRequestInterceptor;
import com.fly.ayudaconfiable.network.HttpLoggingInterceptor;
import com.fly.ayudaconfiable.network.net.http.response.Result;
import com.fly.ayudaconfiable.utils.Cons;
import com.fly.ayudaconfiable.utils.LogUtils;
import com.fly.ayudaconfiable.utils.ToastUtil;
import com.fly.ayudaconfiable.utils.encrypt.DESEncryption;
import com.fly.ayudaconfiable.utils.encrypt.MD5Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.$Gson$Types;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.FileNameMap;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.regex.Pattern;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.TlsVersion;

public class NetClient {
    private static String TAG = "NetClient";
    private static Application context;
    protected static Object tag;
    protected static String serverAddr = Cons.getBaseUrl();
    protected static String payServerAddr = Cons.getBaseUrl();
    private static NetClient mInstance;
    private static OkHttpClient mOkHttpClient;
    private static OkHttpClient.Builder okHttpClientBuilder;
    private static final MediaType MEDIA_TYPE_FORM = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    private Handler mDelivery;
    private static StringBuilder parambuilder = new StringBuilder("");
    private static boolean needReLogin = false;
    private HttpLoggingInterceptor loggingInterceptor = null;
    private String appkey = "";
    private static Gson mGson = null;
    private static String request_token = "";
    private static String payKey = "";
    private static String MerchantCode = "";
    private static String TerminalId = "";
    private static String ChannelType = "";
    private static String mRequestId = "";
    private static AtomicInteger mNextRequestId = new AtomicInteger(1);

    private static SSLSocketFactory createSSLSocketFactory() {
        SSLSocketFactory ssfFactory = null;

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, new TrustManager[]{new ServerCertsVerifier()}, new SecureRandom());
            ssfFactory = sc.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ssfFactory;
    }

    private NetClient() {
        LogUtils.d("  NetClient  初始化，单实例 ");
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(String.class, new StringConverter());
        mGson = gb.create();

        LogUtils.v("<------------------------------------------------------->");

        HttpLoggingInterceptor.Level ptlevel = HttpLoggingInterceptor.Level.BODY;
        loggingInterceptor = new HttpLoggingInterceptor("NewNake");
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setPrintLevel(ptlevel);
            loggingInterceptor.setColorLevel(Level.INFO);
        } else {
            ptlevel = HttpLoggingInterceptor.Level.NONE;
            loggingInterceptor.setPrintLevel(ptlevel);
            loggingInterceptor.setColorLevel(Level.OFF);
        }

        if (okHttpClientBuilder == null) {
            okHttpClientBuilder = new OkHttpClient.Builder();
        }
        okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.callTimeout(62, TimeUnit.SECONDS);
        okHttpClientBuilder.pingInterval(59, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(50, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okHttpClientBuilder.retryOnConnectionFailure(false);
        okHttpClientBuilder.eventListenerFactory(new PicEventListenerFactory());
        if (!BuildConfig.DEBUG) {
            okHttpClientBuilder.proxy(Proxy.NO_PROXY);
        }
        ConnectionPool pool = new ConnectionPool(8, 10, TimeUnit.MINUTES);
        okHttpClientBuilder.connectionPool(pool);
        okHttpClientBuilder.protocols(Collections.unmodifiableList(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)));
        okHttpClientBuilder.addInterceptor(new GzipRequestInterceptor());
        AccessTokenInterceptor accessTokenInterceptor = new AccessTokenInterceptor();
        okHttpClientBuilder.addInterceptor(accessTokenInterceptor);

        okHttpClientBuilder.addInterceptor(loggingInterceptor);
        LogUtils.d(" Current SDK INT: " + Build.VERSION.SDK_INT);
        if (Build.VERSION_CODES.M > Build.VERSION.SDK_INT) {
            /****  Add Start ***/
            // Https 异常：javax.net.ssl.SSLHandshakeException: Handshake failed
            // Caused by: javax.net.ssl.SSLProtocolException: SSL handshake aborted: ssl=0x7a59e45208: Failure in SSL library, usually a protocol error
            // 解决在Android5.0版本以下https无法访问（亲测5.0以上版本也报同样的错误，猜测应该通过服务器配置协议兼容可以解决，目前是Android端自己做了兼容）
            ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.COMPATIBLE_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1)
                    .allEnabledCipherSuites()
                    .build();
            // 兼容http接口
            ConnectionSpec spec1 = new ConnectionSpec.Builder(ConnectionSpec.CLEARTEXT).build();
            okHttpClientBuilder.connectionSpecs(Arrays.asList(spec, spec1));
            /****  Add End ***/
        }
        /**==================所有参数在创建OkhttpClient之前设置！！！================================**/
        if (mOkHttpClient == null) {
            mOkHttpClient = okHttpClientBuilder
                    // 不需要校验证书 // https请求，不作证书校验
                    .sslSocketFactory(createSSLSocketFactory(), new ServerCertsVerifier())
                    .hostnameVerifier(new ServerHostnameVerifier())
                    .build();
        }
        mDelivery = new Handler(Looper.getMainLooper());
    }

    public Handler getDelivery() {
        return mDelivery;
    }

    /**
     * 单实例
     *
     * @return
     */
    public static NetClient getInstance() {
        if (mInstance == null) {
            synchronized (NetClient.class) {
                if (mInstance == null) {
                    mInstance = new NetClient();
                }
            }
        }
        return mInstance;
    }

    /**
     * 必须在全局Application先调用，获取context上下文，否则缓存无法使用
     */
    public static void init(Application app) {
        context = app;
    }

    /**
     * 获取全局上下文
     */
    public static Context getContext() {
        if (context == null) {
            throw new IllegalStateException("请先在全局Application中调用 OkGo.init() 初始化！");
        }

        return context;
    }

    /**
     * 调试模式,默认打开所有的异常调试
     */
    public NetClient debug(String tag) {
        //debug(tag, Level.INFO, true);
        return this;
    }

    public static void setServerAddr(String serverAddrs) {
        serverAddr = serverAddrs;
    }

    public static void setPayServerAddr(String payServerAddrs) {
        payServerAddr = payServerAddrs;
    }

    public static String getPayServerAddr() {
        return payServerAddr;
    }

    public static String getServerAddr() {
        return serverAddr;
    }
    public static void setToken(String requestToken) {
        request_token = requestToken;
    }

    public void setReLoginFlag() {
        needReLogin = false;
    }

    public static void onDestroy() {
        //我们需要关闭调度器服务。这一步会导致以后所有使用此客户端的请求都会被残忍拒接。
        if (mOkHttpClient != null) {
            mOkHttpClient.dispatcher().executorService().shutdown();
            //关闭网络连接池。此时连接池的守护线程会立即退出
            mOkHttpClient.connectionPool().evictAll();
            if (mOkHttpClient.cache() != null) {
                try {
                    mOkHttpClient.cache().close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
            }
        }
        mOkHttpClient = null;
        okHttpClientBuilder = null;
    }

    /**
     * 设置头
     *
     * @param headers
     * @return
     */
    private static Request.Builder addHeaders(Map<String, String> headers) {
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Connection", "Keep-Alive");
        builder.addHeader("Accept", "application/json;charset=utf-8");
        builder.addHeader("Cache-Control", "no-cache");
        // builder.addHeader("Accept-Encoding", "gzip, deflate");
        builder.addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 6.0; zh-cn;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36");
        builder.addHeader("Accept-Language", "zh-CN,zh;q=0.8");

        if (headers != null) {
            Set<Map.Entry<String, String>> entries = headers.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (!TextUtils.isEmpty(request_token)) {
            builder.addHeader("luck_api_token", request_token);
        }

        NetEventModel model = new NetEventModel();
        mRequestId = String.valueOf(mNextRequestId.getAndIncrement());
        model.setRequestId(mRequestId);
        builder.tag(NetEventModel.class, model);
        return builder;
    }

    private static Request.Builder addCompressHeaders() {
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Connection", "Keep-Alive");
        builder.addHeader("Accept", "application/json;charset=utf-8");
        builder.addHeader("Cache-Control", "no-cache");
        builder.addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 6.0; zh-cn;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Mobile Safari/537.36");
        builder.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
        builder.addHeader("Use-Compress", "1");

        return builder;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return Response
     */
    private Response _getAsyn(String url) throws IOException {
        final Request request = addHeaders(null)
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        Response execute = call.execute();
        return execute;
    }

    /**
     * 同步的Get请求
     *
     * @param url
     * @return 字符串
     */
    private String _getAsString(String url) throws IOException {
        Response execute = _getAsyn(url);
        return execute.body().string();
    }

    /**
     * 异步的get请求
     *
     * @param url
     * @param callback
     */
    private void _getAsyn(String url, final ResultCallback callback) {
        final Request request = addHeaders(null)
                .url(url)
                .tag(getSeq())
                .build();
        deliveryResult(callback, request);
    }

    /**
     * 同步的Post请求
     *
     * @param url
     * @param params post的参数
     * @return
     */
    private Response _post(String url, Param... params) throws IOException {
        Request request = buildPostRequest(url, params, null, true);
        if (request == null) {
            return null;
        }

        Response response = mOkHttpClient.newCall(request).execute();
        return response;
    }

    /**
     * 同步的Post请求
     *
     * @param url
     * @param params post的参数
     * @return
     */
    private Response _post(String url, boolean isEncryp, Param... params) throws IOException {
        Request request = buildPostRequest(url, params, null, isEncryp);
        if (request == null) {
            return null;
        }

        Response response = mOkHttpClient.newCall(request).execute();
        return response;
    }

    /**
     * 同步的Post请求
     *
     * @param url
     * @param params post的参数
     * @return 字符串
     */
    private String _postAsString(String url, Param... params) throws IOException {
        Response response = _post(url, params);
        return response.body().string();
    }

    /**
     * 异步的post请求
     *
     * @param url
     * @param callback
     * @param params
     */
    private void _postAsyn(String url, final ResultCallback callback, Param... params) {
        Request request = buildPostRequest(url, params, null, true);
        if (request != null) {
            deliveryResult(callback, request);
        }
    }

    private void _postAsyn(String url, final ResultCallback callback, String json) {
        //LogUtils.d("json params:" + json);
        Request request = buildPostRequest(url, json);
        if (request != null) {
            deliveryResult(callback, request);
        }
    }

    private void _postAsynCompress(String url, final ResultCallback callback, String json) {
        Request request = buildPostCompressRequest(url, json);
        if (request != null) {
            deliveryResult(callback, request);
        }
    }

    /**
     * 异步的post请求
     *
     * @param url
     * @param callback
     * @param params
     * @param headers
     * @param isEncryp
     * @return
     */
    private void _postAsyn(String url, final ResultCallback callback, Map<String, String> params, Map<String, String> headers, boolean isEncryp) {
        Param[] paramsArr = map2Params(params);
        Request request = buildPostRequest(url, paramsArr, headers, isEncryp);
        if (request != null) {
            deliveryResult(callback, request);
        }
    }

    /**
     * 同步基于post的文件上传
     *
     * @param params
     * @return
     */
    private Response _post(String url, File[] files, String[] fileKeys, Param... params) throws IOException {
        Request request = buildMultipartFormRequest(url, files, fileKeys, params);
        return mOkHttpClient.newCall(request).execute();
    }

    private Response _post(String url, File file, String fileKey) throws IOException {
        Request request = buildMultipartFormRequest(url, new File[]{file}, new String[]{fileKey}, null);
        return mOkHttpClient.newCall(request).execute();
    }

    private Response _post(String url, File file, String fileKey, Param... params) throws IOException {
        Request request = buildMultipartFormRequest(url, new File[]{file}, new String[]{fileKey}, params);
        return mOkHttpClient.newCall(request).execute();
    }

    /**
     * 异步基于post的文件上传
     *
     * @param url
     * @param callback
     * @param files
     * @param fileKeys
     * @throws IOException
     */
    private void _postAsyn(String url, ResultCallback callback, File[] files, String[] fileKeys, Param... params) throws IOException {
        Request request = buildMultipartFormRequest(url, files, fileKeys, params);
        deliveryResult(callback, request);
    }

    /**
     * 异步基于post的文件上传，单文件不带参数上传
     *
     * @param url
     * @param callback
     * @param file
     * @param fileKey
     * @throws IOException
     */
    private void _postAsyn(String url, ResultCallback callback, File file, String fileKey) throws IOException {
        Request request = buildMultipartFormRequest(url, new File[]{file}, new String[]{fileKey}, null);
        deliveryResult(callback, request);
    }

    /**
     * 异步基于post的文件上传，单文件且携带其他form参数上传
     *
     * @param url
     * @param callback
     * @param file
     * @param fileKey
     * @param params
     * @throws IOException
     */
    private void _postAsyn(String url, ResultCallback callback, File file, String fileKey, Param... params) throws IOException {
        Request request = buildMultipartFormRequest(url, new File[]{file}, new String[]{fileKey}, params);
        deliveryResult(callback, request);
    }

    private void _postAsyn(String url, ResultCallback callback, File file, String fileKey, Map<String, String> params) throws IOException {
        Param[] paramsArr = map2Params(params);
        Request request = buildMultipartFormRequest(url, new File[]{file}, new String[]{fileKey}, paramsArr);
        deliveryResult(callback, request);
    }

    private static long getSeq() {
        long curTime = System.currentTimeMillis();
        //转换成秒
        return curTime;
    }

    /**
     * 异步下载文件
     *
     * @param url
     * @param destFileDir 本地文件存储的文件夹
     * @param callback
     */
    private void _downloadAsyn(final String url, final String destFileDir, final ResultCallback callback) {
        final Request request = addHeaders(null)
                .url(url).build();
        final Call call = mOkHttpClient.newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LogUtils.d(" 发生异常了。。。");
            if (e instanceof SocketTimeoutException) {
                //判断超时异常
                LogUtils.d(" 请求超时了 ");
            }
            if (e instanceof ConnectException) {
                ////判断连接异常，
                LogUtils.d(" 连接异常了  ");
            }
            e.printStackTrace();
            //sendFailedStringCallback(request, e, callback);
        }
/*        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(final Request request, final IOException e)
            {
                sendFailedStringCallback(request, e, callback);
            }*/

/*            @Override
            public void onResponse(Response response)
            {*/
        //if (response == null) {
        //    //sendFailedStringCallback(request, new IOException("erro"), callback);
        //}

        if (response != null && response.isSuccessful()) {
            InputStream is = null;
            byte[] buf = new byte[2048];
            int len = 0;
            FileOutputStream fos = null;
            try {
                is = response.body().byteStream();
                File file = new File(destFileDir, getFileName(url));
                fos = new FileOutputStream(file);
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                fos.flush();
                //如果下载文件成功，第一个参数为文件的绝对路径
                //sendSuccessResultCallback(file.getAbsolutePath(), callback);
            } catch (IOException e) {
                //sendFailedStringCallback(response.request(), e, callback);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }

                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                    }
                }
            }
        }
        //});
    }

    private String getFileName(String path) {
        int separatorIndex = path.lastIndexOf("/");
        return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1, path.length());
    }

    //*************对外公布的方法************
    public static Response getAsyn(String url) throws IOException {
        return getInstance()._getAsyn(url);
    }

    public static String getAsString(String url) throws IOException {
        return getInstance()._getAsString(url);
    }

    public static void getAsyn(String url, ResultCallback callback) {
        getInstance()._getAsyn(url, callback);
    }

    public static void getAsyn(String url, Map<String, String> params, ResultCallback callback) {
        url = url + "?" + buildGetParams(params);
        LogUtils.v(" 请求URL：  " + url);
        getInstance()._getAsyn(url, callback);
    }

    public static Response post(String url, Param... params) throws IOException {
        return getInstance()._post(url, params);
    }

    public static Response post(String url, boolean isEncryp, Param... params) throws IOException {
        return getInstance()._post(url, isEncryp, params);
    }

    public static String postAsString(String url, Param... params) throws IOException {
        return getInstance()._postAsString(url, params);
    }

    public static void postAsyn(String url, final ResultCallback callback, Param... params) {
        getInstance()._postAsyn(url, callback, params);
    }

    public static void postAsyn(String url, final ResultCallback callback, Map<String, String> params) {
        getInstance()._postAsyn(url, callback, params, null, true);
    }

    public static void postAsyn(String url, Map<String, String> params, final ResultCallback callback) {
        getInstance()._postAsyn(url, callback, params, null, true);
    }

    public static void postAsyn(String url, Map<String, String> params, Map<String, String> headers, final ResultCallback callback) {
        getInstance()._postAsyn(url, callback, params, headers, true);
    }

    public static void postNoEncrypAsyn(String url, Map<String, String> params, final ResultCallback callback) {
        getInstance()._postAsyn(url, callback, params, null, false);
    }

    public static void postAsyn(String url, String json, final ResultCallback callback) {
        getInstance()._postAsyn(url, callback, json);
    }

    public static void postAsynCompress(String url, String json, final ResultCallback callback) {
        getInstance()._postAsynCompress(url, callback, json);
    }

    public static void postJsonStrAsyn(String url, String json, final ResultCallback callback) {
        if (TextUtils.isEmpty(url) || json == null) {
            return;
        }
        if (needReLogin) {
            LogUtils.e("  需要 重新登录 ");
            callback.onFailure(100015, "登录信息已失效,需要重新登录!");
            return;
        }

        /** 重新组合地址**/
        if (!url.startsWith("http")) {
            url = serverAddr + url;
        }
        getInstance()._postAsyn(url, callback, json);
    }

    public static void postJsonAsyn(String url, Map<String, String> params, final ResultCallback callback) {
        if (TextUtils.isEmpty(url) || params == null) {
            return;
        }
        if (needReLogin) {
            LogUtils.e("  需要 重新登录 ");
            callback.onFailure(100015, "登录信息已失效,需要重新登录!");
            return;
        }

        /** 重新组合地址**/
        if (!url.startsWith("http")) {
            url = serverAddr + url;
        }
        getInstance()._postAsyn(url, callback, mapToJson(params));
    }

    public static Response post(String url, File[] files, String[] fileKeys, Param... params) throws IOException {
        return getInstance()._post(url, files, fileKeys, params);
    }

    public static Response post(String url, File file, String fileKey) throws IOException {
        return getInstance()._post(url, file, fileKey);
    }

    public static Response post(String url, File file, String fileKey, Param... params) throws IOException {
        return getInstance()._post(url, file, fileKey, params);
    }

    public static void postAsyn(String url, ResultCallback callback, File[] files, String[] fileKeys, Param... params) throws IOException {
        getInstance()._postAsyn(url, callback, files, fileKeys, params);
    }

    public static void postAsyn(String url, ResultCallback callback, File file, String fileKey) throws IOException {
        getInstance()._postAsyn(url, callback, file, fileKey);
    }

    public static void postAsyn(String url, ResultCallback callback, File file, String fileKey, Param... params) throws IOException {
        getInstance()._postAsyn(url, callback, file, fileKey, params);
    }

    public static void postAsyn(String url, Map<String, String> params, String fileKey, File file, ResultCallback callback) throws IOException {
        getInstance()._postAsyn(url, callback, file, fileKey, params);
    }

    private static String buildGetParams(Map<String, String> params) {
        parambuilder.delete(0, parambuilder.length());
        if (params != null && !params.isEmpty()) {
            Map<String, String> resultMap = params;//sortMapByKey(params);	//按Key进行排序

            for (Map.Entry<String, String> entry : resultMap.entrySet()) {
                LogUtils.v("	 " + entry.getKey() + "     " + entry.getValue());
                parambuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }

            parambuilder.deleteCharAt(parambuilder.length() - 1);
        }
        return parambuilder.toString();
    }

    private Request buildMultipartFormRequest(String url, File[] files, String[] fileKeys, Param[] params) {
        params = validateParam(params);

        //创建文件参数
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        for (Param param : params) {
            builder.addFormDataPart(param.key, param.value);
        }
        /*if (files != null) {
            RequestBody fileBody = null;
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String fileName = file.getName();
                fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileName)), file);
                //TODO 根据文件名设置contentType
                builder.addFormDataPart(fileKeys[i], fileName, fileBody);
            }
        }*/
        if (files != null) {
            LogUtils.d("  大小 :  " + files.length);
            RequestBody fileBody = null;
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String filekey = "";//fileKeys[i];
                if (fileKeys == null) {
                    filekey = null;
                } else {
                    filekey = fileKeys[i];
                }
                if (file == null) {
                    LogUtils.e(" 没有文件！！  ");
                    break;
                }
                final String fileName = file.getName();
                if (filekey == null || filekey.length() < 1) {
                    filekey = "file";
                }
                fileBody = RequestBody.create(MediaType.parse(guessMimeType(fileName)), file);

                FileRequestBody fileRequestBody = new FileRequestBody(fileBody, new FileRequestBody.LoadingListener() {
                    @Override
                    public void onProgress(long currentLength, long contentLength) {
                        //获取上传的比例
                        //LogUtils.v("Tag--  ", currentLength + "/" + contentLength);
                        //ui层回调,设置当前上传的进度值
                        int progress = (int) ((100 * currentLength) / contentLength);
                        if (BuildConfig.DEBUG) {
                            LogUtils.i("  " + fileName + " 当前进度:  " + progress + "%");
                        }
                    }
                });

                //TODO 根据文件名设置contentType
                builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + filekey + "\"; filename=\"" + fileName + "\""), fileRequestBody);
            }
        }

        RequestBody requestBody = builder.build();
        return addHeaders(null)
                .url(url)
                .tag(getSeq())
                .post(requestBody)
                .build();
    }

    private String guessMimeType(String path) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String contentTypeFor = fileNameMap.getContentTypeFor(path);
        if (contentTypeFor == null) {
            contentTypeFor = "application/octet-stream";
        }
        return contentTypeFor;
    }

    private Param[] validateParam(Param[] params) {
        if (params == null) {
            return new Param[0];
        } else {
            return params;
        }
    }

    private Param[] map2Params(Map<String, String> params) {
        if (params == null) {
            return new Param[0];
        }
        int size = params.size();
        Param[] res = new Param[size];
        Set<Map.Entry<String, String>> entries = params.entrySet();
        int i = 0;
        for (Map.Entry<String, String> entry : entries) {
            res[i++] = new Param(entry.getKey(), entry.getValue());
        }
        return res;
    }

    private void deliveryResult(final ResultCallback callback, Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.e("  onFailure erorr  ");
                if (e instanceof SocketTimeoutException) {
                    sendFailedStringCallback(9002, "连接超时,请检查网络设置后再试", callback);
                } else if (e instanceof ConnectException) {
                    sendFailedStringCallback(9003, "网络连接异常,请检查网络设置后再试", callback);
                } else if (e instanceof SocketException) {
                    sendFailedStringCallback(9004, "连接异常断开,请检查网络设置后再试", callback);
                } else {
                    if (e != null) {
                        String exception = e.getMessage();
                        LogUtils.e("  onFailure   " + exception);
                        LogUtils.f("[" + exception + "]");
                        if (!TextUtils.isEmpty(exception)) {
                            if (exception.endsWith("server's subject is not equals to client's subject")) {
                                sendFailedStringCallback(9010, "证书Subject DN错误", callback);
                                return;
                            } else if (exception.contains("stream was reset")) {
                                sendFailedStringCallback(9011, "网络被重置", callback);
                                return;
                            } else if (exception.startsWith("Unable to resolve host")) {
                                sendFailedStringCallback(9012, "网络连接已断开", callback);
                                return;
                            } else {
                                sendFailedStringCallback(9013, "当前网络异常,请稍后再试", callback);
                            }
                        } else {
                            sendFailedStringCallback(9007, "未知错误," + e.getMessage(), callback);
                        }
                    }
                    if (e == null) {
                        sendFailedStringCallback(9007, "网络失败了，未知异常", callback);
                    }
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int responseCode = response.code();
                ////响应失败，一般为服务器内部错误，或者找不到页面等
                if (responseCode != 200) {
                    if (responseCode == 404) {
                        sendFailedStringCallback(9005, "未找到资源", callback);
                    } else if (responseCode == 500) {
                        sendFailedStringCallback(9006, "服务器内部错误", callback);
                    } else {
                        sendFailedStringCallback(9007, "未知错误" + responseCode, callback);
                    }
                    LogUtils.f("api call error : " + responseCode + "  request url:  " + request.url().toString());
                    return;
                }

                String body = "";
                try {
                    body = response.body().string();
                    if (callback.mType == String.class) {
                        sendSuccessResultCallback(responseCode, body, callback);
                    } else {
                        Object o = mGson.fromJson(body, callback.mType);
                        /** 强转为父类  */
                        Result temp = (Result) o;
                        if (temp.getStatus() == 1 && (temp.getCode() != null) && temp.getCode().equals("000000")) {
                            sendSuccessResultCallback(responseCode, o, callback);
                        } else {
                            LogUtils.e(" body: " + body);
                            /** {"status":0,"code":"100008","msg":"Token过期或已失效，请重新登陆!"} **/
                            if (temp.getCode() != null && temp.getCode().equals("100027")) {
                                //100027过期了也允许登录进去，显示客服信息
                                sendSuccessResultCallback(responseCode, o, callback);
                            } else {
                                try {
                                    if (!TextUtils.isEmpty(temp.getMsg())) {
                                        if (TextUtils.isEmpty(temp.getCode())) {
                                            sendFailedStringCallback(0, temp.getMsg(), callback);
                                        } else {
                                            int retCode = Integer.parseInt(temp.getCode());
                                            sendFailedStringCallback(retCode, temp.getMsg(), callback);
                                        }
                                    } else {
                                        sendFailedStringCallback(responseCode, "未知错误" + temp.getMsg(), callback);
                                    }
                                } catch (JsonSyntaxException e) {
                                    sendFailedStringCallback(responseCode, "数据格式错误", callback);
                                }
                            }
                            //LogLongUtill.d("log", body);
                        }
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    LogUtils.f("json", body);
                    sendFailedStringCallback(9123, "解析异常", callback);
                } catch (IOException e) {
                    LogUtils.f("json", body);
                    sendFailedStringCallback(9009, "获取消息体错误", callback);
                } catch (JsonParseException e) { //Json解析的错误
                    LogUtils.f("ben", callback.mType.toString());
                    LogUtils.f("json", body);
                    LogUtils.d("  " + callback.mType.toString() + "   " + body);
                    sendFailedStringCallback(9008, "Json解析的错误", callback);
                }
                response.close();
            }
        });
    }

    private void deliveryPayResult(final ResultCallback callback, Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtils.e("  onFailure   ");
                if (e instanceof SocketTimeoutException) {
                    sendFailedStringCallback(9002, "连接超时,请检查网络设置后再试", callback);
                } else if (e instanceof ConnectException) {
                    sendFailedStringCallback(9003, "网络连接异常,请检查网络设置后再试", callback);
                } else if (e instanceof SocketException) {
                    sendFailedStringCallback(9004, "连接异常断开,请检查网络设置后再试", callback);
                } else {
                    sendFailedStringCallback(9007, "未知错误", callback);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                int responseCode = response.code();
                ////响应失败，一般为服务器内部错误，或者找不到页面等
                if (responseCode != 200) {
                    if (responseCode == 404) {
                        sendFailedStringCallback(9005, "未找到资源", callback);
                    } else if (responseCode == 500) {
                        sendFailedStringCallback(9006, "服务器内部错误", callback);
                    } else {
                        sendFailedStringCallback(9007, "未知错误" + responseCode, callback);
                    }
                    LogUtils.f("api call error : " + responseCode + "  request url:  " + request.url().toString());
                    return;
                }

                String body = "";
                try {
                    body = response.body().string();
                    if (callback.mType == String.class) {
                        sendSuccessResultCallback(responseCode, body, callback);
                    } else {
                        Object o = mGson.fromJson(body, callback.mType);
                        sendSuccessResultCallback(responseCode, o, callback);
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    //sendFailedStringCallback(ERRCODE_FORMAT_INVALID, ERRMSG_FORMAT_INVALID, callback);
                } catch (IOException e) {
                    sendFailedStringCallback(9009, "获取消息体错误", callback);
                } catch (JsonParseException e) { //Json解析的错误
                    LogUtils.d("  " + callback.mType.toString() + "   " + body);
                    sendFailedStringCallback(9008, "Json解析的错误", callback);
                }
                response.close();
            }
        });
    }

    private void sendStringResultCallback(final String object, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onResponseStr(object);
                }
            }
        });
    }

    private void sendFailedStringCallback(final int statusCode, final String message, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                try {
                    if (callback != null) {
                        callback.onFailure(statusCode, message);
                    }
                    switch (statusCode) {
                        case 000004://尊敬的用户：您好！您的企业所在数据库当前停用中！暂时请不要登录,请谅解!
                        case 100008://尊敬的用户：您好！您的企业代码正在维护中！暂时请不要登录,请谅解!/Token过期或已失效，请重新登陆!
                        case 100009://Token失效，不是有效的令牌，请重新登陆!
                        case 100015://帐号在别的地方登录，您被强迫下线！登录IP：{0}
                        case 100016://您的登录信息已过期，请重新登录!
                        case 100017: {//您的登录信息已失效，请重新登录!
                            /** 跳转到登录界面，其它界面全部关了*/
                            LogUtils.e(" 需要重新登录  ");
                            if (!needReLogin) {
                                //context.startActivity(new Intent(context, LoginActivity.class));
                                needReLogin = true;
                                //LwsService.getInstance().unBindAlias();

                                //Intent intent = new Intent(context, LoginActivity.class);
                                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                //context.startActivity(intent);
                                LogUtils.e(" rec msg :" + message);
                                ToastUtil.show(message);
                            } else {
                                LogUtils.e("needReLogin is true rec msg :" + message);
                            }
                        }
                        break;
                        default:
                            LogUtils.e(" error : " + statusCode);
                            break;
                    }
                } catch (Exception e) {
                    LogUtils.e("  exception ");
                    e.printStackTrace();
                }
            }
        });
    }

    private void sendSuccessResultCallback(final int statusCode, final Object object, final ResultCallback callback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                try {
                    if (callback != null) {
                        try {
                            callback.onSuccess(statusCode, object);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    LogUtils.e("error ");
                    e.printStackTrace();
                }
            }
        });
    }

    private Request buildPostRequest(String url, String json) {
        String check_url = "";
        if (url == null) {
            return null;
        }
        check_url = url;
        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.v("unexpected url: " + check_url);
            return null;
        }

        RequestBody requestBody = FormBody.create(MEDIA_TYPE_JSON, json);
        return addHeaders(null)
                .url(url)
                .tag(getSeq())
                .post(requestBody)
                .build();
    }

    private Request buildPostCompressRequest(String url, String json) {
        String check_url = "";
        if (url == null) {
            return null;
        }
        check_url = url;
        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.v("unexpected url: " + check_url);
            return null;
        }
        LogUtils.v(" Full  url : " + check_url);
        RequestBody requestBody = FormBody.create(MEDIA_TYPE_JSON, json);
        return addCompressHeaders()
                .url(url)
                .post(requestBody)
                .build();
    }

    private Request buildPayRequest(String url, String json) {
        LogUtils.v(" Full  url : " + url);
        RequestBody requestBody = FormBody.create(MEDIA_TYPE_JSON, json);
        return addHeaders(null)
                .url(url)
                .tag(getSeq())
                .post(requestBody)
                .build();
    }

    private Request buildPostRequest(String url, Param[] params, Map<String, String> headers, boolean isEncryp) {
        String check_url = "";
        if (url == null) {
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return null;
        }
        //check_url = Domain + url;
        check_url = url;
        //LogUtils.v(" Method:  " + url);

        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.v("unexpected url: " + check_url);
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return null;
        }

        if (params == null) {
            params = new Param[0];
        }
        FormBody.Builder builder = new FormBody.Builder();
        //FormEncodingBuilder builder = new FormEncodingBuilder();
        LogUtils.v("	----------------------------参数开始-----------------------------------");
        for (Param param : params) {
            String key = param.key;
            String value = "";
            LogUtils.v("     " + key + "  :   " + param.value);
            if (isEncryp) {
                if (key.equals("CompCode")) {
                    value = param.value;
                } else {
                    value = DESEncryption.encrypt(appkey, param.value);
                }
            } else {
                value = param.value;
            }

            if (value != null) {
                builder.add(param.key, value);
            }
        }
        LogUtils.v("	----------------------------参数结束-----------------------------------");

        LogUtils.v(" Full  url : " + check_url);

        RequestBody requestBody = builder.build();
        return addHeaders(headers)
                .url(url)
                .post(requestBody)
                .tag(getSeq())
                .build();
    }

    public static abstract class ResultCallback<T> {
        Type mType;

        public ResultCallback() {
            mType = getSuperclassTypeParameter(getClass());
        }

        static Type getSuperclassTypeParameter(Class<?> subclass) {
            Type superclass = subclass.getGenericSuperclass();
            if (superclass instanceof Class) {
                throw new RuntimeException("Missing type parameter.");
            }
            ParameterizedType parameterized = (ParameterizedType) superclass;
            return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
        }

        public abstract void onSuccess(int statusCode, T result);

        public abstract void onFailure(int statusCode, String message);

        public void onResponseStr(String response) {
        }
    }

    public static class Param {
        public Param() {
        }

        public Param(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String key;
        String value;
    }

    public static abstract class ResponseCallback<T> {
        public ResponseCallback() {
        }

        public abstract void onSuccess(int statusCode, T result);

        public abstract void onFailure(int statusCode, String message);

        public void onResponseStr(String response) {
        }
    }

    public static void HttpPrePay(final String url, final Map<String, String> params, final ResultCallback callback) {
        //判断网络是否可用
        // if (!NetBroadcastReceiver.isConnected()) {
        //   //callback.onFailure(ERRCODE_NETWORK_UNAVALLABLE, ERRMSG_NETWORK_UNAVALLABLE);
        //    return;
        // }

        String check_url = "";
        if (url == null) {
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        check_url = url;

        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.d("unexpected url: " + check_url);
            // callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        LogUtils.v("Full  url : " + check_url);
        parambuilder.setLength(0);

        Map<String, String> packages = new LinkedHashMap<String, String>();

        String payType = params.get("PayType");
        String totalFee = params.get("TotalFee");

        if (TextUtils.isEmpty(payType)) {
            return;
        }

        if (TextUtils.isEmpty(totalFee)) {
            return;
        }

        //String url, Map<String, String> packages, String payType, String TerminalTrace, String TerminalTime, String totalFee, String outTradeNo, ResultCallback callback
    }

    public static void HttpPayQuery(final String url, final Map<String, String> params, final ResultCallback callback) {
        //判断网络是否可用
        //if (!NetBroadcastReceiver.isConnected()) {
        //    //callback.onFailure(ERRCODE_NETWORK_UNAVALLABLE, ERRMSG_NETWORK_UNAVALLABLE);
        //    return;
        //}

        String check_url = "";
        if (url == null) {
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        check_url = url;

        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.d("unexpected url: " + check_url);
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        LogUtils.v("Full  url : " + check_url);
        parambuilder.setLength(0);

        Map<String, String> packages = new LinkedHashMap<String, String>();

        String payType = params.get("PayType");
        String outTradeNo = params.get("OutTradeNo");

        if (TextUtils.isEmpty(payType)) {
            return;
        }

        if (TextUtils.isEmpty(outTradeNo)) {
            return;
        }

        getInstance().payCommonCall(url, packages, payType, null, null, "", outTradeNo, callback);
    }

    public static void HttpBarcodePay(final String url, final Map<String, String> params, final ResultCallback callback) {
        //判断网络是否可用
        //if (!NetBroadcastReceiver.isConnected()) {
        //  //callback.onFailure(ERRCODE_NETWORK_UNAVALLABLE, ERRMSG_NETWORK_UNAVALLABLE);
        //    return;
        // }

        String check_url = "";
        if (url == null) {
            // callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        check_url = url;

        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.d("unexpected url: " + check_url);
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        LogUtils.v("Full  url : " + check_url);
        parambuilder.setLength(0);

        Map<String, String> packages = new LinkedHashMap<String, String>();

        String payType = params.get("PayType");
        String totalFee = params.get("TotalFee");
        String authNo = params.get("AuthNo");

        if (TextUtils.isEmpty(payType)) {
            return;
        }

        if (TextUtils.isEmpty(totalFee)) {
            return;
        }

        if (TextUtils.isEmpty(authNo)) {
            return;
        }
    }

    public static void HttpPayRefund(final String url, final Map<String, String> params, final ResultCallback callback) {
        //判断网络是否可用
        //if (!NetBroadcastReceiver.isConnected()) {
        //    //callback.onFailure(ERRCODE_NETWORK_UNAVALLABLE, ERRMSG_NETWORK_UNAVALLABLE);
        //    return;
        //}

        String check_url = "";
        if (url == null) {
            // callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        check_url = url;

        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.d("unexpected url: " + check_url);
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        LogUtils.v("Full  url : " + check_url);
        parambuilder.setLength(0);

        Map<String, String> packages = new LinkedHashMap<String, String>();

        String payType = params.get("PayType");
        String totalFee = params.get("RefundFee");
        String outTradeNo = params.get("OutTradeNo");

        if (TextUtils.isEmpty(payType)) {
            return;
        }

        if (TextUtils.isEmpty(totalFee)) {
            return;
        }

        if (TextUtils.isEmpty(outTradeNo)) {
            return;
        }

    }

    private void payCommonCall(String url, Map<String, String> packages, String payType, String TerminalTrace, String TerminalTime, String totalFee, String outTradeNo, ResultCallback callback) {
        /** !!!! 必须 按文档顺序 来添加参数 ！！！ */
        packages.put("pay_type", payType);
        packages.put("channel_type", ChannelType);
        packages.put("merchant_no", MerchantCode);
        packages.put("terminal_id", TerminalId);
        packages.put("terminal_trace", TerminalTrace);
        packages.put("terminal_time", TerminalTime);
        if (!TextUtils.isEmpty(totalFee)) {
            packages.put("refund_fee", totalFee);
        }
        if (!TextUtils.isEmpty(outTradeNo)) {
            packages.put("out_trade_no", outTradeNo);
        }

        String terminal_time = TerminalTime;
        for (Map.Entry<String, String> entry : packages.entrySet()) {
            LogUtils.v("     " + entry.getKey() + "     " + entry.getValue());
            parambuilder.append(entry.getKey() + "=" + entry.getValue() + "&");
        }

        String thirdkey = MD5Utility.enc32(payKey);//必须大写
        String deviceKey = MD5Utility.enc32(thirdkey.toUpperCase() + terminal_time).toUpperCase();//必须大写
        LogUtils.v("  deviceKey :    " + deviceKey);

        parambuilder.append("access_token=" + deviceKey);
        String readySign = parambuilder.toString();
        LogUtils.v(" 待签名的字符串 ：  " + readySign);

        packages.put("key", payKey);//支付key ,第三方给的

        String key_sign = MD5Utility.enc32(readySign);
        packages.put("key_sign", key_sign.toUpperCase());//

        String context = mapToJson(packages);  //formData;  //
        LogUtils.v("  传给后台的json 内容: \n\r" + context);
        Request request = getInstance().buildPayRequest(url, context);
        if (request == null) {
            return;
        }
        getInstance().deliveryPayResult(callback, request);
    }

    public static void HttpBankPrePay(String url, final String payData, final ResultCallback callback) {
        //判断网络是否可用
        //if (!NetBroadcastReceiver.isConnected()) {
        //  //callback.onFailure(ERRCODE_NETWORK_UNAVALLABLE, ERRMSG_NETWORK_UNAVALLABLE);
        //    return;
        // }
        String check_url = "";
        if (url == null) {
            url = "https://pay.goodhuiyuan.com/api/Pay/BankPrePay";
        }
        if (BuildConfig.DEBUG) {
            url = "https://pay.vip9158.com/api/Pay/BankPrePay";
            url = "https://yxepay.600vip.cn/api/Pay/BankPrePay";
        }
        check_url = url;
        HttpUrl parsed = HttpUrl.parse(check_url);
        if (parsed == null) {
            LogUtils.d("unexpected url: " + check_url);
            //callback.onFailure(ERRCODE_REQUEST_URL, ERRMSG_REQUEST_URL);
            return;
        }
        LogUtils.v("Full  url : " + check_url);
        LogUtils.f(" 传给后台的json 内容: " + payData);
        Request request = getInstance().buildPayRequest(url, payData);
        if (request == null) {
            return;
        }
        getInstance().deliveryPayResult(callback, request);
    }



    private String getLocalSn() {
        try {
            return Build.SERIAL;
        } catch (Throwable localThrowable) {
            LogUtils.v("Failed to get hardware serial number.");
        }
        //return "fail";

        String serial = "";
        try {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.N) {  //8.0+
                serial = Build.SERIAL;
            } else {//8.0-
                Class<?> c = Class.forName("android.os.SystemProperties");
                Method get = c.getMethod("get", String.class);
                serial = (String) get.invoke(c, "ro.serialno");
            }
            return serial;
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("读取设备序列号异常：" + e.toString());
        }
        return "fail";
    }

    /**
     * 将Map转化为Json
     *
     * @param map
     * @return String
     */
    public static <T> String mapToJson(Map<String, T> map) {
        String jsonStr = mGson.toJson(map);
        return jsonStr;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 使用 Map按key进行排序
     *
     * @param map
     * @return
     */
    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }


    public void sendRevokeRecord(String fee, String trade_no, int state) {
        String uploadblank = "https://pay.goodhuiyuan.com/api/Pay/BankCardCancelOrder";
        if (BuildConfig.DEBUG) {
            //uploadblank = "http://pay.vip9158.com/api/Pay/BankCardCancelOrder";
        }
        String paytime = "";
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMddHHmmss");
        paytime = formatter1.format(new Date());
        String jsonparam = "{\"refund_fee\":\"" + fee + "\",\"refund_state\":\"" + state + "\",\"out_trade_no\":\"" + trade_no + "\",\"terminal_time\":\"" + paytime + "\"}";
        LogUtils.v(" jsonparam:" + jsonparam);
        postAsyn(uploadblank, jsonparam, new ResultCallback<String>() {
            @Override
            public void onSuccess(int statusCode, String result) {
                LogUtils.i(result);
            }

            @Override
            public void onFailure(int statusCode, String message) {
                LogUtils.e(" statusCode: " + statusCode + " msg: " + message);
            }
        });
    }

    /*** 更新状态的接口 **/
    public void updatePaySate(String orderno, String paytime, int state, String channel_type, String merchant_no, String voucher_no, String bankcard_type) {
        String uploadblank = "https://pay.goodhuiyuan.com/api/Pay/BankCardPayUpdate";
        if (BuildConfig.DEBUG) {
            //uploadblank = "http://pay.vip9158.com/api/Pay/BankCardPayUpdate";
        }

        if (bankcard_type == null || bankcard_type.length() == 0) {
            bankcard_type = "0";//借贷卡标记 0借记卡 1贷记卡
        }

        String jsonparam = "{\"out_trade_no\":\"" + orderno + "\",\"State\":\"" + state + "\",\"channel_type\":\"" + channel_type + "\",\"merchant_no\":\"" + merchant_no + "\",\"voucher_no\":\"" + voucher_no + "\",\"terminal_time\":\"" + paytime + "\",\"bankcard_type\":\"" + bankcard_type + "\"}";
        LogUtils.v(" jsonparam:" + jsonparam);
        postAsyn(uploadblank, jsonparam, new ResultCallback<String>() {
            @Override
            public void onSuccess(int statusCode, String result) {
                LogUtils.i(result);
            }

            @Override
            public void onFailure(int statusCode, String message) {
                LogUtils.e(" statusCode: " + statusCode + " msg: " + message);
            }
        });
    }
}

//比较器类
class MapKeyComparator implements Comparator<String> {
    @Override
    public int compare(String str1, String str2) {
        // 降序排序
        //return compareTo(obj1);
        //升序
        String temp1 = str1.toString().toUpperCase();
        String temp2 = str2.toString().toUpperCase();
        return temp1.compareTo(temp2);
        //return str1.compareTo(str2);
    }
}

class StringConverter implements JsonSerializer<String>, JsonDeserializer<String> {
    @Override
    public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return new JsonPrimitive("");
        } else {
            return new JsonPrimitive(src.toString());
        }
    }

    @Override
    public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json != null) {
            try {
                if (json.isJsonArray()) {
                    LogUtils.i("  是数组 " + json.getAsJsonArray().size());
                    if (json.getAsJsonArray().size() == 0) {
                        //return json.getAsJsonArray().getAsString();
                        return null;
                    }
                    return json.getAsJsonArray().getAsString();
                } else if (json.isJsonNull()) {
                    LogUtils.i("  json null ");
                } else if (json.isJsonPrimitive()) {
                    //LogUtils.i("  json primitive " + json.toString());
                } else if (json.isJsonObject()) {
                    LogUtils.i("  json object  ");
                    return json.toString();
                } else {
                    LogUtils.i("  json other  ");
                }
            } catch (IllegalStateException e) {
                LogUtils.e(" 异常了");
                return "";
            }
            return json.getAsJsonPrimitive().getAsString();
        } else {
            return "";
        }
    }
}