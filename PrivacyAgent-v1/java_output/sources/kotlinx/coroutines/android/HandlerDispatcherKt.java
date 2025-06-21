package kotlinx.coroutines.android;

@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001f\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\n\u001a\u00020\u0000*\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0001\u001a\u0013\u0010\f\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0016\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002\u001a\u001e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002\"\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018\"\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroid/os/Handler;", "", "name", "Lkotlinx/coroutines/android/HandlerDispatcher;", "from", "(Landroid/os/Handler;Ljava/lang/String;)Lkotlinx/coroutines/android/HandlerDispatcher;", "asCoroutineDispatcher", "Landroid/os/Looper;", "", "async", "asHandler", "", "awaitFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "d", "Landroid/view/Choreographer;", "choreographer", "b", "Main", "Lkotlinx/coroutines/android/HandlerDispatcher;", "getMain$annotations", "()V", "Landroid/view/Choreographer;", "kotlinx-coroutines-android"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class HandlerDispatcherKt {

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.Nullable
    public static final kotlinx.coroutines.android.HandlerDispatcher Main;

    @org.jetbrains.annotations.Nullable
    private static volatile android.view.Choreographer choreographer;

    static {
        java.lang.Object m156constructorimpl;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(new kotlinx.coroutines.android.HandlerContext(asHandler(android.os.Looper.getMainLooper(), true), null, 2, null));
        } catch (java.lang.Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            m156constructorimpl = kotlin.Result.m156constructorimpl(kotlin.ResultKt.createFailure(th));
        }
        Main = (kotlinx.coroutines.android.HandlerDispatcher) (kotlin.Result.m162isFailureimpl(m156constructorimpl) ? null : m156constructorimpl);
    }

    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.NotNull
    public static final android.os.Handler asHandler(@org.jetbrains.annotations.NotNull android.os.Looper looper, boolean z) {
        if (!z) {
            return new android.os.Handler(looper);
        }
        if (android.os.Build.VERSION.SDK_INT < 28) {
            try {
                return (android.os.Handler) android.os.Handler.class.getDeclaredConstructor(android.os.Looper.class, android.os.Handler.Callback.class, java.lang.Boolean.TYPE).newInstance(looper, null, java.lang.Boolean.TRUE);
            } catch (java.lang.NoSuchMethodException unused) {
                return new android.os.Handler(looper);
            }
        }
        java.lang.Object invoke = android.os.Handler.class.getDeclaredMethod("createAsync", android.os.Looper.class).invoke(null, looper);
        if (invoke != null) {
            return (android.os.Handler) invoke;
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }

    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object awaitFrame(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        kotlin.coroutines.Continuation intercepted;
        java.lang.Object coroutine_suspended;
        kotlin.coroutines.Continuation intercepted2;
        java.lang.Object coroutine_suspended2;
        android.view.Choreographer choreographer2 = choreographer;
        if (choreographer2 != null) {
            intercepted2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl = new kotlinx.coroutines.CancellableContinuationImpl(intercepted2, 1);
            cancellableContinuationImpl.initCancellability();
            b(choreographer2, cancellableContinuationImpl);
            java.lang.Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended2) {
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        intercepted = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = new kotlinx.coroutines.CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl2.initCancellability();
        kotlinx.coroutines.Dispatchers.getMain().dispatch(kotlin.coroutines.EmptyCoroutineContext.INSTANCE, new kotlinx.coroutines.android.HandlerDispatcherKt$awaitFrame$lambda3$$inlined$Runnable$1(cancellableContinuationImpl2));
        java.lang.Object result2 = cancellableContinuationImpl2.getResult();
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result2 == coroutine_suspended) {
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result2;
    }

    public static final void b(android.view.Choreographer choreographer2, kotlinx.coroutines.CancellableContinuation<? super java.lang.Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new defpackage.lm0(cancellableContinuation));
    }

    public static final void c(kotlinx.coroutines.CancellableContinuation cancellableContinuation, long j) {
        cancellableContinuation.resumeUndispatched(kotlinx.coroutines.Dispatchers.getMain(), java.lang.Long.valueOf(j));
    }

    public static final void d(kotlinx.coroutines.CancellableContinuation<? super java.lang.Long> cancellableContinuation) {
        android.view.Choreographer choreographer2 = choreographer;
        if (choreographer2 == null) {
            choreographer2 = android.view.Choreographer.getInstance();
            kotlin.jvm.internal.Intrinsics.checkNotNull(choreographer2);
            choreographer = choreographer2;
        }
        b(choreographer2, cancellableContinuation);
    }

    @kotlin.jvm.JvmOverloads
    @kotlin.jvm.JvmName(name = "from")
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.android.HandlerDispatcher from(@org.jetbrains.annotations.NotNull android.os.Handler handler) {
        return from$default(handler, null, 1, null);
    }

    @kotlin.jvm.JvmOverloads
    @kotlin.jvm.JvmName(name = "from")
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.android.HandlerDispatcher from(@org.jetbrains.annotations.NotNull android.os.Handler handler, @org.jetbrains.annotations.Nullable java.lang.String str) {
        return new kotlinx.coroutines.android.HandlerContext(handler, str);
    }

    public static /* synthetic */ kotlinx.coroutines.android.HandlerDispatcher from$default(android.os.Handler handler, java.lang.String str, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return from(handler, str);
    }

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use Dispatchers.Main instead")
    public static /* synthetic */ void getMain$annotations() {
    }
}
