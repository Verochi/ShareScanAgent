package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\r\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/AbstractCoroutine;", "", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "", "afterCompletion", "D", "()Ljava/lang/Object;", "Ljava/lang/Thread;", com.umeng.analytics.pro.bo.aN, "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/EventLoop;", "v", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "", "isScopedCoroutine", "()Z", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
final class BlockingCoroutine<T> extends kotlinx.coroutines.AbstractCoroutine<T> {

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.Thread blockedThread;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.EventLoop eventLoop;

    public BlockingCoroutine(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext, @org.jetbrains.annotations.NotNull java.lang.Thread thread, @org.jetbrains.annotations.Nullable kotlinx.coroutines.EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T D() {
        kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
        if (timeSource != null) {
            timeSource.registerTimeLoopThread();
        }
        try {
            kotlinx.coroutines.EventLoop eventLoop = this.eventLoop;
            if (eventLoop != null) {
                kotlinx.coroutines.EventLoop.incrementUseCount$default(eventLoop, false, 1, null);
            }
            while (!java.lang.Thread.interrupted()) {
                try {
                    kotlinx.coroutines.EventLoop eventLoop2 = this.eventLoop;
                    long processNextEvent = eventLoop2 == null ? Long.MAX_VALUE : eventLoop2.processNextEvent();
                    if (isCompleted()) {
                        T t = (T) kotlinx.coroutines.JobSupportKt.unboxState(getState$kotlinx_coroutines_core());
                        r3 = t instanceof kotlinx.coroutines.CompletedExceptionally ? (kotlinx.coroutines.CompletedExceptionally) t : null;
                        if (r3 == null) {
                            return t;
                        }
                        throw r3.cause;
                    }
                    kotlinx.coroutines.AbstractTimeSource timeSource2 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
                    if (timeSource2 == null) {
                        java.util.concurrent.locks.LockSupport.parkNanos(this, processNextEvent);
                    } else {
                        timeSource2.parkNanos(this, processNextEvent);
                    }
                } finally {
                    kotlinx.coroutines.EventLoop eventLoop3 = this.eventLoop;
                    if (eventLoop3 != null) {
                        kotlinx.coroutines.EventLoop.decrementUseCount$default(eventLoop3, false, 1, null);
                    }
                }
            }
            java.lang.InterruptedException interruptedException = new java.lang.InterruptedException();
            cancelCoroutine(interruptedException);
            throw interruptedException;
        } finally {
            kotlinx.coroutines.AbstractTimeSource timeSource3 = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
            if (timeSource3 != null) {
                timeSource3.unregisterTimeLoopThread();
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(@org.jetbrains.annotations.Nullable java.lang.Object state) {
        if (kotlin.jvm.internal.Intrinsics.areEqual(java.lang.Thread.currentThread(), this.blockedThread)) {
            return;
        }
        java.lang.Thread thread = this.blockedThread;
        kotlinx.coroutines.AbstractTimeSource timeSource = kotlinx.coroutines.AbstractTimeSourceKt.getTimeSource();
        if (timeSource == null) {
            java.util.concurrent.locks.LockSupport.unpark(thread);
        } else {
            timeSource.unpark(thread);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean isScopedCoroutine() {
        return true;
    }
}
