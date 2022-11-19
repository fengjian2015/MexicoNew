package com.fly.ayudaconfiable.network

import com.fly.ayudaconfiable.bean.response.*
import com.fly.ayudaconfiable.network.bean.BaseResponseBean
import io.reactivex.rxjava3.core.Observable
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface HttpService {
    @POST("api/auth/uploadCocoLoanWardAuth")
    fun applyInfo(@Body applyInfoBean: Map<String, String>): Observable<BaseResponseBean>

    @POST("api/system/getNewVersion")
    fun getNewVersion(): Observable<UpdateBeanResponse>

    @POST("api/account/sendVerifyCode")
    fun sendVerifyCode(@Body applyInfoBean: Map<String, String>): Observable<BaseResponseBean>

    @POST("api/account/loginByPhoneVerifyCode")
    fun loginByPhoneVerifyCode(@Body applyInfoBean: Map<String, String>): Observable<UserInfoBeanResponse>

    @GET("api/system/getProtocolUrl")
    fun getProtocolUrl(): Observable<ProtocolLinkBeanResponse>

    @GET("api/system/getSunmi")
    fun getSunmi(): Observable<ProtocolLinkBeanResponse>

    @POST("api/account/logout")
    fun logout(): Observable<BaseResponseBean>

    @GET("api/system/getPublicIp")
    fun getPublicIp(): Observable<IpResponse>

    @GET("api/system/getCOS")
    fun getCOS(): Observable<IpResponse>

    @Multipart
    @POST("api/system/uploadimg")
    fun uploadImg(@Part suffix: MultipartBody.Part,@Part type: MultipartBody.Part,@Part oldPath: MultipartBody.Part, @Part file: MultipartBody.Part): Call<ImgResponse>
}