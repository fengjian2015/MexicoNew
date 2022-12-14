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
                    d("  ????????? ")
                }
            })
    }


    /**
     * ?????????????????????
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
     * ?????????????????????
     */
    fun getProtocolUrl(){
        HttpClient.instance.httpService
            .getProtocolUrl()
            .compose(NetworkScheduler.compose())
            .subscribe(object : HttpResponse<ProtocolLinkBeanResponse>() {
                override fun businessSuccess(data: ProtocolLinkBeanResponse) {
                    if (data.code == 200){
                        data.data?.let {
                            for (protocolUrlBean in it){
                                if (protocolUrlBean.protocalType == 2){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_1,protocolUrlBean.url)
                                } else if (protocolUrlBean.protocalType == 1){
                                    MMKVCacheUtil.putString(KEY_PROTOCAL_2,protocolUrlBean.url)
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
     * ?????????????????????
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
     * ?????????????????????
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
     * ????????????
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
     * ??????????????????
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
     * Okhttp????????????(???)
     */
    public fun uploadImage(file: File,type:String,mWebView: WebView,id:String ,event:String) {
        GlobalScope.launch(Dispatchers.Main) {
            LoadingUtil.showLoading()
        }
        GlobalScope.launch(Dispatchers.IO){
            // ?????? OkHttpClient
            val client = HttpClient.instance.initOkHttpClient(false)
            // ??????????????????
            val mediaType = MediaType.parse("image/jpeg")
            // ???????????????????????????
            val fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)
            // MultipartBody ??????????????????????????????
            val body: RequestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM) // ????????????(??????)
                .addFormDataPart("file", file.name, fileBody)
                .addFormDataPart("suffix", "jpg")
                .addFormDataPart("type", type)
                .addFormDataPart("oldPath", "")
                .build()
            val request: Request = Request.Builder()
                .url(Cons.baseUrl + "system/uploadimg")
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
                        //??????????????????
                        try {
                            var imageResponse = Gson().fromJson(getResponseBody(response),ImgResponse::class.java)
                            LogUtils.d("----?????????????????????${imageResponse}")
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
                        //??????????????????
                        LogUtils.d("----?????????????????????$response")
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
     * ????????????
     * ????????????1-?????????????????????????????? 2-curp?????????????????? 3-curp????????????????????? 4-??????????????????
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
                    if (response.body()!!.code === 200) { //????????????
                        //??????????????????
                        LogUtils.d("----?????????????????????$response")
                        var commontParseDataBean = CommentParseDataBean()
                        commontParseDataBean.value = response.body()!!.data
                        AndroidCallBackJS.callBackJsSuccess(mWebView,id,event,Gson().toJson(commontParseDataBean))
                    } else {
                        //??????????????????
                        LogUtils.d("----?????????????????????$response")
                        AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,response.message())
                    }
                } catch (e: Exception) {
                    //??????????????????
                    AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,e.toString())
                    LogUtils.d("----?????????????????????$e")
                }
            }

            override fun onFailure(call: Call<ImgResponse>, t: Throwable) {
                LoadingUtil.dismissProgress()
                //????????????
                LogUtils.d("----?????????????????????$t")
                AndroidCallBackJS.callbackJsErrorOther(mWebView,id,event,t.toString())
            }
        })
    }

}