package net.println.kotlin.Chapter7.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor

/**
 * AbstractCoroutineContextElement 需要一个Key<>参数， 该参数是ContinuationInterceptor 的反生参数
 */
class AsyncContext: AbstractCoroutineContextElement(ContinuationInterceptor), ContinuationInterceptor{
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return UiContinuationWrapper(continuation.context.fold(continuation){
            continuation, element ->
            if (element != this && element is ContinuationInterceptor) {
                element.interceptContinuation(continuation)
            }else continuation
        })
    }

}