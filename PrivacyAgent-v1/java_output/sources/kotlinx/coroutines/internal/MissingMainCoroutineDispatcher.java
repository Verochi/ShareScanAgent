package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016J\u001e\u0010\u0016\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0002R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "", "time", "", "delay", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeMillis", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "a", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "d", "", "toString", "c", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Throwable;", "cause", "t", "Ljava/lang/String;", "errorHint", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class MissingMainCoroutineDispatcher extends kotlinx.coroutines.MainCoroutineDispatcher implements kotlinx.coroutines.Delay {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Throwable cause;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String errorHint;

    public MissingMainCoroutineDispatcher(@org.jetbrains.annotations.Nullable java.lang.Throwable th, @org.jetbrains.annotations.Nullable java.lang.String str) {
        this.cause = th;
        this.errorHint = str;
    }

    public /* synthetic */ MissingMainCoroutineDispatcher(java.lang.Throwable th, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? null : str);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        c();
        throw new kotlin.KotlinNothingValueException();
    }

    public final java.lang.Void c() {
        java.lang.String stringPlus;
        if (this.cause == null) {
            kotlinx.coroutines.internal.MainDispatchersKt.throwMissingMainDispatcherException();
            throw new kotlin.KotlinNothingValueException();
        }
        java.lang.String str = this.errorHint;
        java.lang.String str2 = "";
        if (str != null && (stringPlus = kotlin.jvm.internal.Intrinsics.stringPlus(". ", str)) != null) {
            str2 = stringPlus;
        }
        throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Module with the Main dispatcher had failed to initialize", str2), this.cause);
    }

    @Override // kotlinx.coroutines.Delay
    @org.jetbrains.annotations.NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public java.lang.Void scheduleResumeAfterDelay(long timeMillis, @org.jetbrains.annotations.NotNull kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> continuation) {
        c();
        throw new kotlin.KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    @org.jetbrains.annotations.Nullable
    public java.lang.Object delay(long j, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        c();
        throw new kotlin.KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.MainCoroutineDispatcher getImmediate() {
        return this;
    }

    @Override // kotlinx.coroutines.Delay
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.DisposableHandle invokeOnTimeout(long timeMillis, @org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        c();
        throw new kotlin.KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context) {
        c();
        throw new kotlin.KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Dispatchers.Main[missing");
        java.lang.Throwable th = this.cause;
        sb.append(th != null ? kotlin.jvm.internal.Intrinsics.stringPlus(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }
}
