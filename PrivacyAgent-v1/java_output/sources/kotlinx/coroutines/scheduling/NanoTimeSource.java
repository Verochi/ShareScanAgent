package kotlinx.coroutines.scheduling;

@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "()V", "nanoTime", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class NanoTimeSource extends kotlinx.coroutines.scheduling.SchedulerTimeSource {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.scheduling.NanoTimeSource INSTANCE = new kotlinx.coroutines.scheduling.NanoTimeSource();

    @Override // kotlinx.coroutines.scheduling.SchedulerTimeSource
    public long nanoTime() {
        return java.lang.System.nanoTime();
    }
}
