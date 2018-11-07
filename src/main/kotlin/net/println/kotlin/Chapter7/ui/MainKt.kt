package net.println.kotlin.Chapter7.ui

import net.println.kotlin.Chapter7.async.DownloadContext
import net.println.kotlin.Chapter7.async.我要开始加载图片了
import net.println.kotlin.Chapter7.async.我要开始协程了
import net.println.kotlin.Chapter7.async.我要开始耗时操作了
import net.println.kotlin.Chapter7.common.HttpError
import net.println.kotlin.Chapter7.common.HttpException
import net.println.kotlin.Chapter7.common.HttpService
import net.println.kotlin.Chapter7.common.log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.awt.Window
import javax.swing.JFrame.EXIT_ON_CLOSE
import javax.swing.SwingUtilities

const val LOGO_URL = "http://www.imooc.com/static/img/index/logo.png?t=1.1"

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(132,150)
    frame.isResizable = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true

    frame.onButtonClick {
        log("协程之前")
        我要开始协程了(DownloadContext(LOGO_URL )){ // 传入一个带有url 属性的Context
            log("协程开始")
//            val imageData = 我要开始加载图片了(LOGO_URL)
            //这里可以try catch
            val imageData = 我要开始耗时操作了 {
                /*
                this[DownloadContext] 获得 DownloadContext实例
                这个实例定义了一个url属性
                 */
                我要开始加载图片了(this[DownloadContext]!!.url)
            }
            log("拿到图片")

            frame.setLogo(imageData)
//            SwingUtilities.invokeLater{
//
//            }
        }
        log("协程之后")
    }

//    frame.onButtonClick {
//        //网络请求
//        HttpService.service.getLogo(LOGO_URL)
//                .enqueue(object : Callback<ResponseBody> {
//                    override fun onResponse(
//                            call: Call<ResponseBody>,
//                            response: Response<ResponseBody>) {
//                        if (response.isSuccessful) { //成功
//                            val imageData = response.body()?.byteStream()?.readBytes()
//                            if (imageData == null) {
//                                throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
//                            } else {
//                                SwingUtilities.invokeLater {
//                                    frame.setLogo(imageData)
//                                }
//                            }
//                        } else {
//                            throw HttpException(response.code())
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                        throw HttpException(HttpError.HTTP_ERROR_UNKNONW)
//                    }
//                })
//    }
}