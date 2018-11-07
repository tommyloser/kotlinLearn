package net.println.kotlin.Chapter7.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

class DownloadContext (val url:String):AbstractCoroutineContextElement(Key){
    //泛生对象继承CoroutineContext.Key,如果实现Interceptor 接口， 就不用写， 因为Interceptor 就定义了这个泛生对象
    companion object Key:CoroutineContext.Key<DownloadContext>
}