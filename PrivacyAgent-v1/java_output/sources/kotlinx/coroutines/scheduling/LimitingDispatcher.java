package kotlinx.coroutines.scheduling;

@kotlin.Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010(\u001a\u00020\u001e¢\u0006\u0004\b0\u00101J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\u0010\u000e\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\u0010\u000e\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ#\u0010\u0018\u001a\u00020\u00072\n\u0010\u000e\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010(\u001a\u00020\u001e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u001e\u0010,\u001a\f\u0012\b\u0012\u00060\u0004j\u0002`\u00050)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00062"}, d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", com.heytap.mcssdk.constant.b.y, "", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "afterTask", "", "tailDispatch", "a", "(Ljava/lang/Runnable;Z)V", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "t", "I", "parallelism", com.umeng.analytics.pro.bo.aN, "Ljava/lang/String;", "name", "v", "getTaskMode", "()I", "taskMode", "Ljava/util/concurrent/ConcurrentLinkedQueue;", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILjava/lang/String;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
final class LimitingDispatcher extends kotlinx.coroutines.ExecutorCoroutineDispatcher implements kotlinx.coroutines.scheduling.TaskContext, java.util.concurrent.Executor {
    public static final /* synthetic */ java.util.concurrent.atomic.AtomicIntegerFieldUpdater x = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(kotlinx.coroutines.scheduling.LimitingDispatcher.class, "inFlightTasks");

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher dispatcher;

    /* renamed from: t, reason: from kotlin metadata */
    public final int parallelism;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String name;

    /* renamed from: v, reason: from kotlin metadata */
    public final int taskMode;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> queue = new java.util.concurrent.ConcurrentLinkedQueue<>();

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int inFlightTasks = 0;

    public LimitingDispatcher(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, @org.jetbrains.annotations.Nullable java.lang.String str, int i2) {
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = i;
        this.name = str;
        this.taskMode = i2;
    }

    public final void a(java.lang.Runnable block, boolean tailDispatch) {
        do {
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = x;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.parallelism) {
                this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(block, this, tailDispatch);
                return;
            }
            this.queue.add(block);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.parallelism) {
                return;
            } else {
                block = this.queue.poll();
            }
        } while (block != null);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
        java.lang.Runnable poll = this.queue.poll();
        if (poll != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(poll, this, true);
            return;
        }
        x.decrementAndGet(this);
        java.lang.Runnable poll2 = this.queue.poll();
        if (poll2 == null) {
            return;
        }
        a(poll2, true);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new java.lang.IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        a(block, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        a(block, true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@org.jetbrains.annotations.NotNull java.lang.Runnable command) {
        a(command, false);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.util.concurrent.Executor getExecutor() {
        return this;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.taskMode;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        java.lang.String str = this.name;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.dispatcher + ']';
    }
}
