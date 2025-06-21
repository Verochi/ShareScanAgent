package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002\"\u0004\b\u0000\u0010\u0000H\u0000\u001a,\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\u00060\u0005j\u0002`\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0080\b¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0080\b\u001a\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000\"\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015*\f\b\u0000\u0010\u0017\"\u00020\u00052\u00020\u0005¨\u0006\u0018"}, d2 = {androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", "Lkotlinx/coroutines/internal/SubscribersList;", "subscriberList", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Lkotlin/Function0;", "action", "withLock", "(Ljava/util/concurrent/locks/ReentrantLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "expectedSize", "", "identitySet", "Ljava/util/concurrent/Executor;", "executor", "", "removeFutureOnCancel", "Ljava/lang/reflect/Method;", "a", "Ljava/lang/reflect/Method;", "REMOVE_FUTURE_ON_CANCEL", "ReentrantLock", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class ConcurrentKt {

    @org.jetbrains.annotations.Nullable
    public static final java.lang.reflect.Method a;

    static {
        java.lang.reflect.Method method;
        try {
            method = java.util.concurrent.ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", java.lang.Boolean.TYPE);
        } catch (java.lang.Throwable unused) {
            method = null;
        }
        a = method;
    }

    public static /* synthetic */ void ReentrantLock$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public static final <E> java.util.Set<E> identitySet(int i) {
        return java.util.Collections.newSetFromMap(new java.util.IdentityHashMap(i));
    }

    public static final boolean removeFutureOnCancel(@org.jetbrains.annotations.NotNull java.util.concurrent.Executor executor) {
        java.lang.reflect.Method method;
        try {
            java.util.concurrent.ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof java.util.concurrent.ScheduledThreadPoolExecutor ? (java.util.concurrent.ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor == null || (method = a) == null) {
                return false;
            }
            method.invoke(scheduledThreadPoolExecutor, java.lang.Boolean.TRUE);
            return true;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final <E> java.util.List<E> subscriberList() {
        return new java.util.concurrent.CopyOnWriteArrayList();
    }

    public static final <T> T withLock(@org.jetbrains.annotations.NotNull java.util.concurrent.locks.ReentrantLock reentrantLock, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> function0) {
        reentrantLock.lock();
        try {
            return function0.invoke();
        } finally {
            kotlin.jvm.internal.InlineMarker.finallyStart(1);
            reentrantLock.unlock();
            kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        }
    }
}
