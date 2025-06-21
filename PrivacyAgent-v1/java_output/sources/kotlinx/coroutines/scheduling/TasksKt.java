package kotlinx.coroutines.scheduling;

@kotlin.Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\u000e\u001a\u00020\u000f*\u00020\u00108À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0011¨\u0006\u0012"}, d2 = {"BLOCKING_DEFAULT_PARALLELISM", "", "CORE_POOL_SIZE", "DEFAULT_DISPATCHER_NAME", "", "DEFAULT_SCHEDULER_NAME", "IDLE_WORKER_KEEP_ALIVE_NS", "", "MAX_POOL_SIZE", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", "", "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class TasksKt {

    @kotlin.jvm.JvmField
    public static final int BLOCKING_DEFAULT_PARALLELISM;

    @kotlin.jvm.JvmField
    public static final int CORE_POOL_SIZE;

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEFAULT_DISPATCHER_NAME = "Dispatchers.Default";

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";

    @kotlin.jvm.JvmField
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;

    @kotlin.jvm.JvmField
    public static final int MAX_POOL_SIZE;
    public static final int TASK_NON_BLOCKING = 0;
    public static final int TASK_PROBABLY_BLOCKING = 1;

    @kotlin.jvm.JvmField
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;

    @kotlin.jvm.JvmField
    @org.jetbrains.annotations.NotNull
    public static kotlinx.coroutines.scheduling.SchedulerTimeSource schedulerTimeSource;

    static {
        long e;
        int d;
        int coerceAtLeast;
        int d2;
        int coerceIn;
        int d3;
        long e2;
        e = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        WORK_STEALING_TIME_RESOLUTION_NS = e;
        d = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        BLOCKING_DEFAULT_PARALLELISM = d;
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(kotlinx.coroutines.internal.SystemPropsKt.getAVAILABLE_PROCESSORS(), 2);
        d2 = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.scheduler.core.pool.size", coerceAtLeast, 1, 0, 8, null);
        CORE_POOL_SIZE = d2;
        coerceIn = kotlin.ranges.RangesKt___RangesKt.coerceIn(kotlinx.coroutines.internal.SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, d2, kotlinx.coroutines.scheduling.CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE);
        d3 = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.scheduler.max.pool.size", coerceIn, 0, kotlinx.coroutines.scheduling.CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, null);
        MAX_POOL_SIZE = d3;
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.SECONDS;
        e2 = kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        IDLE_WORKER_KEEP_ALIVE_NS = timeUnit.toNanos(e2);
        schedulerTimeSource = kotlinx.coroutines.scheduling.NanoTimeSource.INSTANCE;
    }

    public static final boolean isBlocking(@org.jetbrains.annotations.NotNull kotlinx.coroutines.scheduling.Task task) {
        return task.taskContext.getTaskMode() == 1;
    }
}
