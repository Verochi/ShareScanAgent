package kotlinx.coroutines.scheduling;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0005"}, d2 = {"isSchedulerWorker", "", "thread", "Ljava/lang/Thread;", "mayNotBlock", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class CoroutineSchedulerKt {
    @kotlin.jvm.JvmName(name = "isSchedulerWorker")
    public static final boolean isSchedulerWorker(@org.jetbrains.annotations.NotNull java.lang.Thread thread) {
        return thread instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.Worker;
    }

    @kotlin.jvm.JvmName(name = "mayNotBlock")
    public static final boolean mayNotBlock(@org.jetbrains.annotations.NotNull java.lang.Thread thread) {
        return (thread instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) && ((kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) thread).state == kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}
