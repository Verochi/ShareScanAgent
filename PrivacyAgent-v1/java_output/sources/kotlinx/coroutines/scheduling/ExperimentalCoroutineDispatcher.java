package kotlinx.coroutines.scheduling;

@kotlinx.coroutines.InternalCoroutinesApi
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010&\u001a\u00020\r\u0012\u0006\u0010(\u001a\u00020\r\u0012\u0006\u0010+\u001a\u00020\u001b\u0012\b\b\u0002\u0010.\u001a\u00020\u000b¢\u0006\u0004\b6\u00107B'\b\u0016\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\b\u0002\u0010(\u001a\u00020\r\u0012\b\b\u0002\u0010.\u001a\u00020\u000b¢\u0006\u0004\b6\u00108B\u001d\b\u0017\u0012\b\b\u0002\u0010&\u001a\u00020\r\u0012\b\b\u0002\u0010(\u001a\u00020\r¢\u0006\u0004\b6\u00109J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u001c\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rJ+\u0010\u0017\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u001a\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010!\u001a\u00020\u0007H\u0000¢\u0006\u0004\b \u0010\u0019J\b\u0010#\u001a\u00020\"H\u0002R\u0014\u0010&\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010%R\u0014\u0010+\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006:"}, d2 = {"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "dispatchYield", "close", "", "toString", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "blocking", "limited", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "tailDispatch", "dispatchWithContext$kotlinx_coroutines_core", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "dispatchWithContext", "usePrivateScheduler$kotlinx_coroutines_core", "()V", "usePrivateScheduler", "", "timeout", "shutdown$kotlinx_coroutines_core", "(J)V", "shutdown", "restore$kotlinx_coroutines_core", com.alibaba.sdk.android.oss.common.RequestParameters.X_OSS_RESTORE, "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "a", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "corePoolSize", "t", "maxPoolSize", com.umeng.analytics.pro.bo.aN, "J", "idleWorkerKeepAliveNs", "v", "Ljava/lang/String;", "schedulerName", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "<init>", "(IIJLjava/lang/String;)V", "(IILjava/lang/String;)V", "(II)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public class ExperimentalCoroutineDispatcher extends kotlinx.coroutines.ExecutorCoroutineDispatcher {

    /* renamed from: n, reason: from kotlin metadata */
    public final int corePoolSize;

    /* renamed from: t, reason: from kotlin metadata */
    public final int maxPoolSize;

    /* renamed from: u, reason: from kotlin metadata */
    public final long idleWorkerKeepAliveNs;

    /* renamed from: v, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String schedulerName;

    /* renamed from: w, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.scheduling.CoroutineScheduler coroutineScheduler;

    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2) {
        this(i, i2, kotlinx.coroutines.scheduling.TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, null, 8, null);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? kotlinx.coroutines.scheduling.TasksKt.CORE_POOL_SIZE : i, (i3 & 2) != 0 ? kotlinx.coroutines.scheduling.TasksKt.MAX_POOL_SIZE : i2);
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, long j, @org.jetbrains.annotations.NotNull java.lang.String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        this.coroutineScheduler = a();
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, long j, java.lang.String str, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, (i3 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public ExperimentalCoroutineDispatcher(int i, int i2, @org.jetbrains.annotations.NotNull java.lang.String str) {
        this(i, i2, kotlinx.coroutines.scheduling.TasksKt.IDLE_WORKER_KEEP_ALIVE_NS, str);
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, java.lang.String str, int i3, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? kotlinx.coroutines.scheduling.TasksKt.CORE_POOL_SIZE : i, (i3 & 2) != 0 ? kotlinx.coroutines.scheduling.TasksKt.MAX_POOL_SIZE : i2, (i3 & 4) != 0 ? kotlinx.coroutines.scheduling.TasksKt.DEFAULT_SCHEDULER_NAME : str);
    }

    public static /* synthetic */ kotlinx.coroutines.CoroutineDispatcher blocking$default(kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, int i2, java.lang.Object obj) {
        if (obj != null) {
            throw new java.lang.UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
        }
        if ((i2 & 1) != 0) {
            i = kotlinx.coroutines.scheduling.TasksKt.BLOCKING_DEFAULT_PARALLELISM;
        }
        return experimentalCoroutineDispatcher.blocking(i);
    }

    public final kotlinx.coroutines.scheduling.CoroutineScheduler a() {
        return new kotlinx.coroutines.scheduling.CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineDispatcher blocking(int parallelism) {
        if (parallelism > 0) {
            return new kotlinx.coroutines.scheduling.LimitingDispatcher(this, parallelism, null, 1);
        }
        throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected positive parallelism level, but have ", java.lang.Integer.valueOf(parallelism)).toString());
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.coroutineScheduler.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        try {
            kotlinx.coroutines.scheduling.CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, null, false, 6, null);
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            kotlinx.coroutines.DefaultExecutor.INSTANCE.dispatch(context, block);
        }
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@org.jetbrains.annotations.NotNull java.lang.Runnable block, @org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.TaskContext context, boolean tailDispatch) {
        try {
            this.coroutineScheduler.dispatch(block, context, tailDispatch);
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            kotlinx.coroutines.DefaultExecutor.INSTANCE.enqueue(this.coroutineScheduler.createTask(block, context));
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext context, @org.jetbrains.annotations.NotNull java.lang.Runnable block) {
        try {
            kotlinx.coroutines.scheduling.CoroutineScheduler.dispatch$default(this.coroutineScheduler, block, null, true, 2, null);
        } catch (java.util.concurrent.RejectedExecutionException unused) {
            kotlinx.coroutines.DefaultExecutor.INSTANCE.dispatchYield(context, block);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.util.concurrent.Executor getExecutor() {
        return this.coroutineScheduler;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.CoroutineDispatcher limited(int parallelism) {
        if (!(parallelism > 0)) {
            throw new java.lang.IllegalArgumentException(kotlin.jvm.internal.Intrinsics.stringPlus("Expected positive parallelism level, but have ", java.lang.Integer.valueOf(parallelism)).toString());
        }
        if (parallelism <= this.corePoolSize) {
            return new kotlinx.coroutines.scheduling.LimitingDispatcher(this, parallelism, null, 0);
        }
        throw new java.lang.IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.corePoolSize + "), but have " + parallelism).toString());
    }

    public final void restore$kotlinx_coroutines_core() {
        usePrivateScheduler$kotlinx_coroutines_core();
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long timeout) {
        this.coroutineScheduler.shutdown(timeout);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return super.toString() + "[scheduler = " + this.coroutineScheduler + ']';
    }

    public final synchronized void usePrivateScheduler$kotlinx_coroutines_core() {
        this.coroutineScheduler.shutdown(1000L);
        this.coroutineScheduler = a();
    }
}
