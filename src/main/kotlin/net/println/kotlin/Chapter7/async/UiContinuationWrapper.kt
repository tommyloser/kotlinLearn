package net.println.kotlin.Chapter7.async

import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

class UiContinuationWrapper<T>(val continuation: Continuation<T>):Continuation<T> {
    override val context: CoroutineContext = EmptyCoroutineContext

    override fun resume(value: T) {//在执行真正的resume 执行先切线程
        SwingUtilities.invokeLater{continuation.resume(value)}
    }

    override fun resumeWithException(exception: Throwable) {
        SwingUtilities.invokeLater{continuation.resumeWithException(exception)}
    }
}