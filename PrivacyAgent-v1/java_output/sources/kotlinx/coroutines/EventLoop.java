package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0011\u0010!\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b!\u0010\u001b¨\u0006$"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "processNextEvent", "", "processUnconfinedEvent", "shouldBeProcessedFromContext", "Lkotlinx/coroutines/DispatchedTask;", "task", "", "dispatchUnconfined", "unconfined", "incrementUseCount", "decrementUseCount", "shutdown", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "J", "useCount", "t", "Z", "shared", "Lkotlinx/coroutines/internal/ArrayQueue;", com.umeng.analytics.pro.bo.aN, "Lkotlinx/coroutines/internal/ArrayQueue;", "unconfinedQueue", "isEmpty", "()Z", "getNextTime", "()J", "nextTime", "isActive", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public abstract class EventLoop extends kotlinx.coroutines.CoroutineDispatcher {

    /* renamed from: n, reason: from kotlin metadata */
    public long useCount;

    /* renamed from: t, reason: from kotlin metadata */
    public boolean shared;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public kotlinx.coroutines.internal.ArrayQueue<kotlinx.coroutines.DispatchedTask<?>> unconfinedQueue;

    public static /* synthetic */ void decrementUseCount$default(kotlinx.coroutines.EventLoop eventLoop, boolean z, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        eventLoop.decrementUseCount(z);
    }

    public static /* synthetic */ void incrementUseCount$default(kotlinx.coroutines.EventLoop eventLoop, boolean z, int i, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        eventLoop.incrementUseCount(z);
    }

    public final long a(boolean unconfined) {
        if (unconfined) {
            return tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1L;
    }

    public final void decrementUseCount(boolean unconfined) {
        long a = this.useCount - a(unconfined);
        this.useCount = a;
        if (a <= 0 && this.shared) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(@org.jetbrains.annotations.NotNull kotlinx.coroutines.DispatchedTask<?> task) {
        kotlinx.coroutines.internal.ArrayQueue<kotlinx.coroutines.DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null) {
            arrayQueue = new kotlinx.coroutines.internal.ArrayQueue<>();
            this.unconfinedQueue = arrayQueue;
        }
        arrayQueue.addLast(task);
    }

    public long getNextTime() {
        kotlinx.coroutines.internal.ArrayQueue<kotlinx.coroutines.DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        return (arrayQueue == null || arrayQueue.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void incrementUseCount(boolean unconfined) {
        this.useCount += a(unconfined);
        if (unconfined) {
            return;
        }
        this.shared = true;
    }

    public final boolean isActive() {
        return this.useCount > 0;
    }

    public boolean isEmpty() {
        return isUnconfinedQueueEmpty();
    }

    public final boolean isUnconfinedLoopActive() {
        return this.useCount >= a(true);
    }

    public final boolean isUnconfinedQueueEmpty() {
        kotlinx.coroutines.internal.ArrayQueue<kotlinx.coroutines.DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null) {
            return true;
        }
        return arrayQueue.isEmpty();
    }

    public long processNextEvent() {
        return !processUnconfinedEvent() ? Long.MAX_VALUE : 0L;
    }

    public final boolean processUnconfinedEvent() {
        kotlinx.coroutines.DispatchedTask<?> removeFirstOrNull;
        kotlinx.coroutines.internal.ArrayQueue<kotlinx.coroutines.DispatchedTask<?>> arrayQueue = this.unconfinedQueue;
        if (arrayQueue == null || (removeFirstOrNull = arrayQueue.removeFirstOrNull()) == null) {
            return false;
        }
        removeFirstOrNull.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public void shutdown() {
    }
}
