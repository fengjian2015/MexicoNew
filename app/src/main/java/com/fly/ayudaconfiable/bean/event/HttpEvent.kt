package com.fly.ayudaconfiable.bean.event

import android.os.Build
import android.text.TextUtils
import android.util.Base64
import android.webkit.WebView
import androidx.fragment.app.FragmentActivity
import com.appsflyer.AppsFlyerLib
import com.blankj.utilcode.util.ToastUtils
import com.fly.ayudaconfiable.MyApplication
import com.fly.ayudaconfiable.bean.ApplyInfo
import com.fly.ayudaconfiable.bean.response.*
import com.fly.ayudaconfiable.js.AndroidCallBackJS
import com.fly.ayudaconfiable.js.bean.CommentParseDataBean
import com.fly.ayudaconfiable.network.HttpClient
import com.fly.ayudaconfiable.network.HttpClient.Companion.instance
import com.fly.ayudaconfiable.network.NetworkScheduler
import com.fly.ayudaconfiable.network.bean.BaseResponseBean
import com.fly.ayudaconfiable.network.bean.HttpErrorBean
import com.fly.ayudaconfiable.network.bean.HttpResponse
import com.fly.ayudaconfiable.utils.*
import com.fly.ayudaconfiable.utils.Cons.KEY_AF_CHANNEL
import com.fly.ayudaconfiable.utils.Cons.KEY_PROTOCAL_1
import com.fly.ayudaconfiable.utils.Cons.KEY_PROTOCAL_2
import com.fly.ayudaconfiable.utils.Cons.KEY_PROTOCAL_3
import com.fly.ayudaconfiable.utils.Cons.KEY_PROTOCAL_4
import com.fly.ayudaconfiable.utils.Cons.KEY_PROTOCAL_5
import com.fly.ayudaconfiable.utils.Cons.KEY_PROTOCAL_6
import com.fly.ayudaconfiable.utils.Cons.KEY_PROTOCAL_7
import com.fly.ayudaconfiable.utils.LogUtils.d
import com.fly.ayudaconfiable.weight.UpdateDialog
import com.google.gson.Gson
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import okio.Buffer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException

object HttpEvent {

    fun getSunmi(){
        instance.httpService
            .getSunmi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : HttpResponse<ProtocolLinkBeanResponse>() {
                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {}
                override fun businessSuccess(data: ProtocolLinkBeanResponse) {
                    d("  成功了 ")
                }
            })
    }


    /**
     * 验证码登录接口
     */
    fun logout(){
        HttpClient.instance.httpService
            .logout()
            .compose(NetworkScheduler.compose())
            .subscribe(object : HttpResponse<BaseResponseBean>() {
                override fun businessSuccess(data: BaseResponseBean) {

                }

                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {

                }
            })
    }

    /**
     * 验证码登录接口
     */
    fun getProtocolUrl(){
        HttpClient.instance.httpService
            .getProtocolUrl()
            .compose(NetworkScheduler.compose())
            .subscribe(object : HttpResponse<ProtocolLinkBeanResponse>() {
                override fun businessSuccess(data: ProtocolLinkBeanResponse) {
                    if (data.code == 200){
                        data.protocolUrlBeans?.let {
                            for (protocolUrlBean in it){
                                if (protocolUrlBean.protocalType == 1){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_1,protocolUrlBean.url)
                                } else if (protocolUrlBean.protocalType == 2){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_2,protocolUrlBean.url)
                                }else if (protocolUrlBean.protocalType == 3){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_3,protocolUrlBean.url)
                                }else if (protocolUrlBean.protocalType == 4){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_4,protocolUrlBean.url)
                                }else if (protocolUrlBean.protocalType == 5){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_5,protocolUrlBean.url)
                                }else if (protocolUrlBean.protocalType == 6){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_6,protocolUrlBean.url)
                                }else if (protocolUrlBean.protocalType == 7){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_7,protocolUrlBean.url)
                                }
                            }
                        }
                    }
                }

                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {

                }
            })
    }

    /**
     * 验证码登录接口
     */
    fun getPublicIp(){
        HttpClient.instance.httpService
            .getPublicIp()
            .compose(NetworkScheduler.compose())
            .subscribe(object : HttpResponse<IpResponse>() {
                override fun businessSuccess(data: IpResponse) {
                    if (data.code == 200){
                        data.data?.let {
                            MMKVCacheUtil.putString(Cons.KEY_PUBLIC_IP,it)
                        }
                    }
                }

                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {

                }
            })
    }

    /**
     * 验证码登录接口
     */
    fun getCOS(){
        HttpClient.instance.httpService
            .getPublicIp()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : HttpResponse<IpResponse>() {
                override fun businessSuccess(data: IpResponse) {
                    if (data.code == 200){
                        data.data?.let {
                            MMKVCacheUtil.putString(Cons.KEY_PUBLIC_IP,it)
                        }
                    }
                }

                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {

                }
            })
    }

    /**
     * 检测更新
     */
    fun getNewVersion(){
        HttpClient.instance.httpService
            .getNewVersion()
            .compose(NetworkScheduler.compose())
            .subscribe(object : HttpResponse<UpdateBeanResponse>() {
                override fun businessSuccess(data: UpdateBeanResponse) {
                    if (data.code == 200){
                        var updateBean = data.data
                        updateBean?.let {
                            if (CommonUtil.stringToInt(updateBean.code) >
                                CommonUtil.stringToInt(CommonUtil.getVersionCode(MyApplication.application).toString())){
                                try {
                                    val dialog = UpdateDialog(updateBean)
                                    val activity =  ActivityManager.getCurrentActivity() as FragmentActivity
                                    dialog.show(activity.supportFragmentManager, "update'")
                                } catch (e: Exception) {
                                }
                            }
                        }
                    }
                }

                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {

                }
            })
    }

    /**
     * 上传风控数据
     */
    fun uploadApplyInfo(applyInfoBean:ApplyInfo, mWebView: WebView, id:String, event:String){
        val map: MutableMap<String, String> = HashMap()
        val content = Gson().toJson(applyInfoBean)
        map["authInfo"] = Base64.encodeToString(content.toByteArray(), Base64.DEFAULT)
        HttpClient.instance.authService
            .applyInfo(map)
            .compose(NetworkScheduler.compose())
            .subscribe(object : HttpResponse<BaseResponseBean>() {
                override fun businessFail(statusCode: Int, httpErrorBean: HttpErrorBean) {
                    AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,httpErrorBean.message)
                }

                override fun businessSuccess(data: BaseResponseBean) {
                    if (data.code == 200){
                        AndroidCallBackJS.callBackJsSuccess(mWebView,id,event)
                    }else{
                        AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,data.message)
                    }
                }
            })
    }

    /**
     * Okhttp上传图片(流)
     */
    public fun uploadImage(file: File,type:String,mWebView: WebView,id:String ,event:String) {
        GlobalScope.launch(Dispatchers.Main) {
            LoadingUtil.showLoading()
        }
        GlobalScope.launch(Dispatchers.IO){
            // 创建 OkHttpClient
            val client = HttpClient.instance.initOkHttpClient(false)
            // 要上传的文件
            val mediaType = MediaType.parse("image/jpeg")
            // 把文件封装进请求体
            val fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
            // MultipartBody 上传文件专用的请求体
            val body: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM) // 表单类型(必填)
                .addFormDataPart("file", file.name, fileBody)
                .addFormDataPart("suffix", "jpg")
                .addFormDataPart("type", type)
                .addFormDataPart("oldPath", "")
                .build()
            val request: Request = Request.Builder()
                .url(Cons.baseUrl + "api/system/uploadimg")
                .post(body)
                .build()
            val call: okhttp3.Call = client.newCall(request)
            call.enqueue(object : okhttp3.Callback {

                override fun onFailure(call: okhttp3.Call, e: IOException) {
                    LoadingUtil.dismissProgress()
                    AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,e.toString())
                }

                override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                    LoadingUtil.dismissProgress()
                    if (response.isSuccessful) {
                        //返回数据处理
                        try {
                            var imageResponse = Gson().fromJson(getResponseBody(response),ImgResponse::class.java)
                            LogUtils.d("----上传图片成功：${imageResponse}")
                            var commontParseDataBean = CommentParseDataBean()
                            if(TextUtils.isEmpty(imageResponse.data)){
                                AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,imageResponse.message)
                                return
                            }
                            commontParseDataBean.value = imageResponse.data
                            AndroidCallBackJS.callBackJsSuccess(mWebView,id,event,Gson().toJson(commontParseDataBean))
                        }catch (e:Exception){
                            e.printStackTrace()
                        }

                    } else {
                        //图片上传失败
                        LogUtils.d("----上传图片失败：$response")
                        AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,response.message())
                    }
                }

            })
        }
    }

    fun getResponseBody(response: okhttp3.Response): String? {
        val UTF8: Charset = Charset.forName("UTF-8")
        val responseBody: ResponseBody? = response.body() as ResponseBody?
        val source = responseBody!!.source()
        try {
            source.request(Long.MAX_VALUE) // Buffer the entire body.
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val buffer: Buffer = source.buffer()
        var charset: Charset = UTF8
        val contentType = responseBody.contentType()
        if (contentType != null) {
            try {
                charset = contentType.charset(UTF8)!!
            } catch (e: UnsupportedCharsetException) {
                e.printStackTrace()
            }
        }
        return buffer.clone().readString(charset)
    }

    /**
     * 上传图片
     * 文件类型1-用户自拍头像面部照片 2-curp身份证正面照 3-curp身份证反面照片 4-活体认证照片
     */
    fun uploadImage(file: File,type:String,mWebView: WebView,id:String ,event:String, n :String){
        LoadingUtil.showLoading()
        val imageBody: RequestBody =
            RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val imageBodyPart = MultipartBody.Part.createFormData("file", file.name, imageBody)
        val txtBodyPart = MultipartBody.Part.createFormData("suffix", "jpg")
        val type = MultipartBody.Part.createFormData("type", type)
        val oldPath = MultipartBody.Part.createFormData("oldPath", "")
        val repos: Call<ImgResponse> =
            HttpClient
                .instance
                .httpService
                .uploadImg(txtBodyPart,type,oldPath, imageBodyPart)
        repos.enqueue(object : Callback<ImgResponse> {
            override fun onResponse(
                call: Call<ImgResponse>,
                response: Response<ImgResponse>) {
                LoadingUtil.dismissProgress()
                try {
                    if (response.body()!!.code === 200) { //请求成功
                        //返回数据处理
                        LogUtils.d("----上传图片成功：$response")
                        var commontParseDataBean = CommentParseDataBean()
                        commontParseDataBean.value = response.body()!!.data
                        AndroidCallBackJS.callBackJsSuccess(mWebView,id,event,Gson().toJson(commontParseDataBean))
                    } else {
                        //图片上传失败
                        LogUtils.d("----上传图片失败：$response")
                        AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,response.message())
                    }
                } catch (e: Exception) {
                    //返回数据异常
                    AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,e.toString())
                    LogUtils.d("----上传图片异常：$e")
                }
            }

            override fun onFailure(call: Call<ImgResponse>, t: Throwable) {
                LoadingUtil.dismissProgress()
                //请求异常
                LogUtils.d("----上传图片异常：$t")
                AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,t.toString())
            }
        })
    }

}