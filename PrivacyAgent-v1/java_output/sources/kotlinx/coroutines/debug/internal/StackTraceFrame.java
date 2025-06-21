package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "t", "Ljava/lang/StackTraceElement;", "stackTraceElement", "<init>", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/StackTraceElement;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class StackTraceFrame implements kotlin.coroutines.jvm.internal.CoroutineStackFrame {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final kotlin.coroutines.jvm.internal.CoroutineStackFrame callerFrame;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.StackTraceElement stackTraceElement;

    public StackTraceFrame(@org.jetbrains.annotations.Nullable kotlin.coroutines.jvm.internal.CoroutineStackFrame coroutineStackFrame, @org.jetbrains.annotations.NotNull java.lang.StackTraceElement stackTraceElement) {
        this.callerFrame = coroutineStackFrame;
        this.stackTraceElement = stackTraceElement;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.Nullable
    public kotlin.coroutines.jvm.internal.CoroutineStackFrame getCallerFrame() {
        return this.callerFrame;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @org.jetbrains.annotations.NotNull
    public java.lang.StackTraceElement getStackTraceElement() {
        return this.stackTraceElement;
    }
}
