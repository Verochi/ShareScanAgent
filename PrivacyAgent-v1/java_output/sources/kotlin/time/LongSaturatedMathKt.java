package kotlin.time;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a\"\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a*\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\"\u0010\n\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0005\u001a\"\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"", "longNs", "Lkotlin/time/Duration;", "duration", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAdd", "durationNs", "a", "(JJJ)J", "b", "valueNs", "originNs", "saturatingDiff", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LongSaturatedMathKt {
    public static final long a(long j, long j2, long j3) {
        if (!kotlin.time.Duration.m657isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new java.lang.IllegalArgumentException("Summing infinities of different signs");
    }

    public static final long b(long j, long j2) {
        long m633divUwyO8pc = kotlin.time.Duration.m633divUwyO8pc(j2, 2);
        return ((kotlin.time.Duration.m650getInWholeNanosecondsimpl(m633divUwyO8pc) - 1) | 1) == Long.MAX_VALUE ? (long) (j + kotlin.time.Duration.m668toDoubleimpl(j2, kotlin.time.DurationUnit.NANOSECONDS)) : m729saturatingAddpTJri5U(m729saturatingAddpTJri5U(j, m633divUwyO8pc), m633divUwyO8pc);
    }

    /* renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m729saturatingAddpTJri5U(long j, long j2) {
        long m650getInWholeNanosecondsimpl = kotlin.time.Duration.m650getInWholeNanosecondsimpl(j2);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return a(j, j2, m650getInWholeNanosecondsimpl);
        }
        if ((1 | (m650getInWholeNanosecondsimpl - 1)) == Long.MAX_VALUE) {
            return b(j, j2);
        }
        long j3 = j + m650getInWholeNanosecondsimpl;
        return ((j ^ j3) & (m650getInWholeNanosecondsimpl ^ j3)) < 0 ? j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j3;
    }

    public static final long saturatingDiff(long j, long j2) {
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return kotlin.time.Duration.m677unaryMinusUwyO8pc(kotlin.time.DurationKt.toDuration(j2, kotlin.time.DurationUnit.DAYS));
        }
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            kotlin.time.Duration.Companion companion = kotlin.time.Duration.INSTANCE;
            return kotlin.time.DurationKt.toDuration(j3, kotlin.time.DurationUnit.NANOSECONDS);
        }
        long j4 = 1000000;
        long j5 = (j / j4) - (j2 / j4);
        long j6 = (j % j4) - (j2 % j4);
        kotlin.time.Duration.Companion companion2 = kotlin.time.Duration.INSTANCE;
        return kotlin.time.Duration.m661plusLRDsOJo(kotlin.time.DurationKt.toDuration(j5, kotlin.time.DurationUnit.MILLISECONDS), kotlin.time.DurationKt.toDuration(j6, kotlin.time.DurationUnit.NANOSECONDS));
    }
}
