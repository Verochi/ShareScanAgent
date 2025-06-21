package kotlinx.coroutines.scheduling;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0007R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "", "close", "", "toString", "toDebugString", "Lkotlinx/coroutines/CoroutineDispatcher;", "x", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class DefaultScheduler extends kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.scheduling.DefaultScheduler INSTANCE;

    /* renamed from: x, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.CoroutineDispatcher IO;

    static {
        int coerceAtLeast;
        int d;
        kotlinx.coroutines.scheduling.DefaultScheduler defaultScheduler = new kotlinx.coroutines.scheduling.DefaultScheduler();
        INSTANCE = defaultScheduler;
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(64, kotlinx.coroutines.internal.SystemPropsKt.getAVAILABLE_PROCESSORS());
        d = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.d(kotlinx.coroutines.DispatchersKt.IO_PARALLELISM_PROPERTY_NAME, coerceAtLeast, 0, 0, 12, null);
        IO = new kotlinx.coroutines.scheduling.LimitingDispatcher(defaultScheduler, d, "Dispatchers.IO", 1);
    }

    public DefaultScheduler() {
        super(0, 0, null, 7, null);
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new java.lang.UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineDispatcher getIO() {
        return IO;
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @org.jetbrains.annotations.NotNull
    public final java.lang.String toDebugString() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return kotlinx.coroutines.scheduling.TasksKt.DEFAULT_DISPATCHER_NAME;
    }
}
