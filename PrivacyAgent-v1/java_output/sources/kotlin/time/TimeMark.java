package kotlin.time;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001J\u0014\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "plus", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.time.ExperimentalTime
/* loaded from: classes14.dex */
public interface TimeMark {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(@org.jetbrains.annotations.NotNull kotlin.time.TimeMark timeMark) {
            return kotlin.time.Duration.m658isNegativeimpl(timeMark.mo625elapsedNowUwyO8pc());
        }

        public static boolean hasPassedNow(@org.jetbrains.annotations.NotNull kotlin.time.TimeMark timeMark) {
            return !kotlin.time.Duration.m658isNegativeimpl(timeMark.mo625elapsedNowUwyO8pc());
        }

        @org.jetbrains.annotations.NotNull
        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public static kotlin.time.TimeMark m734minusLRDsOJo(@org.jetbrains.annotations.NotNull kotlin.time.TimeMark timeMark, long j) {
            return timeMark.mo627plusLRDsOJo(kotlin.time.Duration.m677unaryMinusUwyO8pc(j));
        }

        @org.jetbrains.annotations.NotNull
        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public static kotlin.time.TimeMark m735plusLRDsOJo(@org.jetbrains.annotations.NotNull kotlin.time.TimeMark timeMark, long j) {
            return new kotlin.time.AdjustedTimeMark(timeMark, j, null);
        }
    }

    /* renamed from: elapsedNow-UwyO8pc */
    long mo625elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @org.jetbrains.annotations.NotNull
    /* renamed from: minus-LRDsOJo */
    kotlin.time.TimeMark mo626minusLRDsOJo(long j);

    @org.jetbrains.annotations.NotNull
    /* renamed from: plus-LRDsOJo */
    kotlin.time.TimeMark mo627plusLRDsOJo(long j);
}
