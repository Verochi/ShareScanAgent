package kotlin.time;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0015\u0010\u0007\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0011H\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource;", "", "toString", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "markNow", "timeMark", "Lkotlin/time/Duration;", "elapsedFrom-6eNON_k", "(J)J", "elapsedFrom", "duration", "adjustReading-6QKq23U", "(JJ)J", "adjustReading", "", "a", "J", "zero", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.time.ExperimentalTime
/* loaded from: classes14.dex */
public final class MonotonicTimeSource implements kotlin.time.TimeSource {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.time.MonotonicTimeSource INSTANCE = new kotlin.time.MonotonicTimeSource();

    /* renamed from: a, reason: from kotlin metadata */
    public static final long zero = java.lang.System.nanoTime();

    public final long a() {
        return java.lang.System.nanoTime() - zero;
    }

    /* renamed from: adjustReading-6QKq23U, reason: not valid java name */
    public final long m730adjustReading6QKq23U(long timeMark, long duration) {
        return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m738constructorimpl(kotlin.time.LongSaturatedMathKt.m729saturatingAddpTJri5U(timeMark, duration));
    }

    /* renamed from: elapsedFrom-6eNON_k, reason: not valid java name */
    public final long m731elapsedFrom6eNON_k(long timeMark) {
        return kotlin.time.LongSaturatedMathKt.saturatingDiff(a(), timeMark);
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ kotlin.time.TimeMark markNow() {
        return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m737boximpl(m732markNowz9LOYto());
    }

    /* renamed from: markNow-z9LOYto, reason: not valid java name */
    public long m732markNowz9LOYto() {
        return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m738constructorimpl(a());
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
