package kotlinx.coroutines;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000\"\u001a\u0010\n\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t\"\u001a\u0010\r\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u0012\u0004\b\f\u0010\t*\u001e\b\u0002\u0010\u0010\u001a\u0004\b\u0000\u0010\u000e\"\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\u0012\u0004\u0012\u00028\u00000\u000f¨\u0006\u0011"}, d2 = {"", "timeMillis", "delayToNanos", "timeNanos", "delayNanosToMillis", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "getDISPOSED_TASK$annotations", "()V", "DISPOSED_TASK", "b", "getCLOSED_EMPTY$annotations", "CLOSED_EMPTY", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes15.dex */
public final class EventLoop_commonKt {

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol a = new kotlinx.coroutines.internal.Symbol("REMOVED_TASK");

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.Symbol b = new kotlinx.coroutines.internal.Symbol("CLOSED_EMPTY");

    public static final long delayNanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}
