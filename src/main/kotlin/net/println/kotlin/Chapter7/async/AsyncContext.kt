package net.println.kotlin.Chapter7.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor

/**
 * AbstractCoroutineContextElement 需要一个Key<>参数， 该参数是ContinuationInterceptor 的反生参数
 */
class AsyncContext: AbstractCoroutineContextElement(ContinuationInterceptor.Key), ContinuationInterceptor{
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return UiContinuationWrapper(continuation.context.fold(continuation){
            continuation, element ->//element -> CoroutineContext.Element, continuation 是初始值
            /*
            如果element 不等于AsyncContext, 且也继承了ContinuationInterceptor,
            则这些他们自个的intercept 方法， 否则返回使用我的UiContinuationWrapper 篡改
             */
            if (element != this && element is ContinuationInterceptor) {
                element.interceptContinuation(continuation)
            }else continuation
        })
    }

}