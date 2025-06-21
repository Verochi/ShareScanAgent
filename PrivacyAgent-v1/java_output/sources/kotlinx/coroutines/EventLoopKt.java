package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"createEventLoop", "Lkotlinx/coroutines/EventLoop;", "processNextEventInCurrentThread", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class EventLoopKt {
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.EventLoop createEventLoop() {
        return new kotlinx.coroutines.BlockingEventLoop(java.lang.Thread.currentThread());
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    public static final long processNextEventInCurrentThread() {
        kotlinx.coroutines.EventLoop currentOrNull$kotlinx_coroutines_core = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
        if (currentOrNull$kotlinx_coroutines_core == null) {
            return Long.MAX_VALUE;
        }
        return currentOrNull$kotlinx_coroutines_core.processNextEvent();
    }
}
