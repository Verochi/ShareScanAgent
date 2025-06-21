package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010&\u001a\u0004\u0018\u00010!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010)\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b'\u0010\n\u001a\u0004\b(\u0010\fR\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148G¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019¨\u00060"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "Lkotlin/coroutines/CoroutineContext;", "a", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "b", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCreationStackBottom", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackBottom", "", "c", "J", "getSequenceNumber", "()J", "sequenceNumber", "", "Ljava/lang/StackTraceElement;", "d", "Ljava/util/List;", "getCreationStackTrace", "()Ljava/util/List;", "creationStackTrace", "", "e", "Ljava/lang/String;", "getState", "()Ljava/lang/String;", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "Ljava/lang/Thread;", "f", "Ljava/lang/Thread;", "getLastObservedThread", "()Ljava/lang/Thread;", "lastObservedThread", "g", "getLastObservedFrame", "lastObservedFrame", "h", "lastObservedStackTrace", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", com.tencent.open.SocialConstants.PARAM_SOURCE, "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@kotlin.PublishedApi
/* loaded from: classes16.dex */
public final class DebugCoroutineInfo {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.CoroutineContext context;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final kotlin.coroutines.jvm.internal.CoroutineStackFrame creationStackBottom;

    /* renamed from: c, reason: from kotlin metadata */
    public final long sequenceNumber;

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.StackTraceElement> creationStackTrace;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String state;

    /* renamed from: f, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Thread lastObservedThread;

    /* renamed from: g, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final kotlin.coroutines.jvm.internal.CoroutineStackFrame lastObservedFrame;

    /* renamed from: h, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.StackTraceElement> lastObservedStackTrace;

    public DebugCoroutineInfo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.debug.internal.DebugCoroutineInfo debugCoroutineInfo, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        this.context = coroutineContext;
        this.creationStackBottom = debugCoroutineInfo.getCreationStackBottom();
        this.sequenceNumber = debugCoroutineInfo.sequenceNumber;
        this.creationStackTrace = debugCoroutineInfo.getCreationStackTrace();
        this.state = debugCoroutineInfo.get_state();
        this.lastObservedThread = debugCoroutineInfo.lastObservedThread;
        this.lastObservedFrame = debugCoroutineInfo.getLastObservedFrame$kotlinx_coroutines_core();
        this.lastObservedStackTrace = debugCoroutineInfo.lastObservedStackTrace();
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.CoroutineContext getContext() {
        return this.context;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlin.coroutines.jvm.internal.CoroutineStackFrame getCreationStackBottom() {
        return this.creationStackBottom;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.StackTraceElement> getCreationStackTrace() {
        return this.creationStackTrace;
    }

    @org.jetbrains.annotations.Nullable
    public final kotlin.coroutines.jvm.internal.CoroutineStackFrame getLastObservedFrame() {
        return this.lastObservedFrame;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Thread getLastObservedThread() {
        return this.lastObservedThread;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getState() {
        return this.state;
    }

    @kotlin.jvm.JvmName(name = "lastObservedStackTrace")
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.StackTraceElement> lastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }
}
