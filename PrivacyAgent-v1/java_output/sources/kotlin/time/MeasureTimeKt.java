package kotlin.time;

@kotlin.Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\f\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class MeasureTimeKt {
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.time.ExperimentalTime
    public static final long measureTime(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        long m736markNowz9LOYto = kotlin.time.TimeSource.Monotonic.INSTANCE.m736markNowz9LOYto();
        block.invoke();
        return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m739elapsedNowUwyO8pc(m736markNowz9LOYto);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.time.ExperimentalTime
    public static final long measureTime(@org.jetbrains.annotations.NotNull kotlin.time.TimeSource.Monotonic monotonic, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(monotonic, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        long m736markNowz9LOYto = monotonic.m736markNowz9LOYto();
        block.invoke();
        return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m739elapsedNowUwyO8pc(m736markNowz9LOYto);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.time.ExperimentalTime
    public static final long measureTime(@org.jetbrains.annotations.NotNull kotlin.time.TimeSource timeSource, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeSource, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        kotlin.time.TimeMark markNow = timeSource.markNow();
        block.invoke();
        return markNow.mo625elapsedNowUwyO8pc();
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.time.TimedValue<T> measureTimedValue(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        return new kotlin.time.TimedValue<>(block.invoke(), kotlin.time.TimeSource.Monotonic.ValueTimeMark.m739elapsedNowUwyO8pc(kotlin.time.TimeSource.Monotonic.INSTANCE.m736markNowz9LOYto()), null);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.time.TimedValue<T> measureTimedValue(@org.jetbrains.annotations.NotNull kotlin.time.TimeSource.Monotonic monotonic, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(monotonic, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        return new kotlin.time.TimedValue<>(block.invoke(), kotlin.time.TimeSource.Monotonic.ValueTimeMark.m739elapsedNowUwyO8pc(monotonic.m736markNowz9LOYto()), null);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.time.TimedValue<T> measureTimedValue(@org.jetbrains.annotations.NotNull kotlin.time.TimeSource timeSource, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeSource, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        return new kotlin.time.TimedValue<>(block.invoke(), timeSource.markNow().mo625elapsedNowUwyO8pc(), null);
    }
}
