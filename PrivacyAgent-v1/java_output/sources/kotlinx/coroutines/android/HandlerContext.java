package kotlinx.coroutines.android;

@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b*\u0010+B\u001d\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b*\u0010,J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016J\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010)\u001a\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010%\u001a\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "", "toString", "", "other", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "Landroid/os/Handler;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Landroid/os/Handler;", "handler", "t", "Ljava/lang/String;", "name", com.umeng.analytics.pro.bo.aN, "Z", "invokeImmediately", "_immediate", "Lkotlinx/coroutines/android/HandlerContext;", "v", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "immediate", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class HandlerContext extends kotlinx.coroutines.android.HandlerDispatcher {

    @org.jetbrains.annotations.Nullable
    private volatile kotlinx.coroutines.android.HandlerContext _immediate;

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final android.os.Handler handler;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String name;

    /* renamed from: u, reason: from kotlin metadata */
    public final boolean invokeImmediately;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.android.HandlerContext immediate;

    public HandlerContext(@org.jetbrains.annotations.NotNull android.os.Handler handler, @org.jetbrains.annotations.Nullable java.lang.String str) {
        this(handler, str, false);
    }

    public /* synthetic */ HandlerContext(android.os.Handler handler, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(android.os.Handler handler, java.lang.String str, boolean z) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this._immediate = z ? this : null;
        kotlinx.coroutines.android.HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new kotlinx.coroutines.android.HandlerContext(handler, str, true);
            this._immediate = handlerContext;
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
        this.immediate = handlerContext;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        this.handler.post(block);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        return (other instanceof kotlinx.coroutines.android.HandlerContext) && ((kotlinx.coroutines.android.HandlerContext) other).handler == this.handler;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.android.HandlerContext getImmediate() {
        return this.immediate;
    }

    public int hashCode() {
        return java.lang.System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, @org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        long coerceAtMost;
        android.os.Handler handler = this.handler;
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(timeMillis, kotlin.time.DurationKt.MAX_MILLIS);
        handler.postDelayed(block, coerceAtMost);
        return new kotlinx.coroutines.android.HandlerContext$invokeOnTimeout$1(this, block);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        return (this.invokeImmediately && kotlin.jvm.internal.Intrinsics.areEqual(android.os.Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long timeMillis, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> continuation) {
        long coerceAtMost;
        kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(continuation, this);
        android.os.Handler handler = this.handler;
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(timeMillis, kotlin.time.DurationKt.MAX_MILLIS);
        handler.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, coerceAtMost);
        continuation.invokeOnCancellation(new kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl != null) {
            return stringInternalImpl;
        }
        java.lang.String str = this.name;
        if (str == null) {
            str = this.handler.toString();
        }
        return this.invokeImmediately ? kotlin.jvm.internal.Intrinsics.stringPlus(str, ".immediate") : str;
    }
}
