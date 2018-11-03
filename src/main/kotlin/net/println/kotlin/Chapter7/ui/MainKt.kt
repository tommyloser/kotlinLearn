package net.println.kotlin.Chapter7.ui

import net.println.kotlin.Chapter7.common.HttpError
import net.println.kotlin.Chapter7.common.HttpException
import net.println.kotlin.Chapter7.common.HttpService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        HttpService.service.getLogo(LOGO_URL)
                .enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>) {
                        if (response.isSuccessful) {
                            val imageData = response.body()?.byteStream()?.readBytes()
                            if (imageData == null) {
                                throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
                            } else {
                                SwingUtilities.invokeLater {
                                    frame.setLogo(imageData)
                                }
                            }
                        } else {
                            throw HttpException(response.code())
                        }
                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        throw HttpException(HttpError.HTTP_ERROR_UNKNONW)
                    }
                })
    }
}