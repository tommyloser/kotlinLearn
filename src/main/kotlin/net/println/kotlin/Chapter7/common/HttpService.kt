package net.println.kotlin.Chapter7.common

import okhttp3.ResponseBody

object HttpService {
    val service by lazy{ //属性代理 ， 网络请求接口
        val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("http://www.imooc.com") //网络请求url
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create()) //数据解析器
                .build()
        retrofit.create(net.println.kotlin.Chapter7.common.Service::class.java)//创建网络请求接口
    }
}

/**
 * 直接传入一个请求的 URL变量 用于URL设置
 */
interface Service{
    @retrofit2.http.GET
    fun getLogo(@retrofit2.http.Url fileUrl:String): retrofit2.Call<ResponseBody>
}
