package kotlinx.coroutines.debug.internal;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", com.tencent.open.SocialConstants.PARAM_SOURCE, "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "coroutineId", "", "getCoroutineId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "dispatcher", "", "getDispatcher", "()Ljava/lang/String;", "lastObservedStackTrace", "", "Ljava/lang/StackTraceElement;", "getLastObservedStackTrace", "()Ljava/util/List;", "lastObservedThreadName", "getLastObservedThreadName", "lastObservedThreadState", "getLastObservedThreadState", "name", "getName", "sequenceNumber", "getSequenceNumber", "()J", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "getState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlin.PublishedApi
/* loaded from: classes16.dex */
public final class DebuggerInfo implements java.io.Serializable {

    @org.jetbrains.annotations.Nullable
    private final java.lang.Long coroutineId;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String dispatcher;

    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.StackTraceElement> lastObservedStackTrace;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String lastObservedThreadName;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String lastObservedThreadState;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String name;
    private final long sequenceNumber;

    @org.jetbrains.annotations.NotNull
    private final java.lang.String state;

    public DebuggerInfo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.debug.internal.DebugCoroutineInfo debugCoroutineInfo, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext coroutineContext) {
        java.lang.Thread.State state;
        kotlinx.coroutines.CoroutineId coroutineId = (kotlinx.coroutines.CoroutineId) coroutineContext.get(kotlinx.coroutines.CoroutineId.INSTANCE);
        this.coroutineId = coroutineId == null ? null : java.lang.Long.valueOf(coroutineId.getId());
        kotlin.coroutines.ContinuationInterceptor continuationInterceptor = (kotlin.coroutines.ContinuationInterceptor) coroutineContext.get(kotlin.coroutines.ContinuationInterceptor.INSTANCE);
        this.dispatcher = continuationInterceptor == null ? null : continuationInterceptor.toString();
        kotlinx.coroutines.CoroutineName coroutineName = (kotlinx.coroutines.CoroutineName) coroutineContext.get(kotlinx.coroutines.CoroutineName.INSTANCE);
        this.name = coroutineName == null ? null : coroutineName.getName();
        this.state = debugCoroutineInfo.get_state();
        java.lang.Thread thread = debugCoroutineInfo.lastObservedThread;
        this.lastObservedThreadState = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        java.lang.Thread thread2 = debugCoroutineInfo.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfo.lastObservedStackTrace();
        this.sequenceNumber = debugCoroutineInfo.sequenceNumber;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getCoroutineId() {
        return this.coroutineId;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getDispatcher() {
        return this.dispatcher;
    }

    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getState() {
        return this.state;
    }
}
