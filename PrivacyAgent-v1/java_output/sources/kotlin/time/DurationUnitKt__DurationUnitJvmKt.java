package kotlin.time;

@kotlin.Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a\f\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"convertDurationUnit", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "toDurationUnit", "Ljava/util/concurrent/TimeUnit;", "toTimeUnit", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/time/DurationUnitKt")
/* loaded from: classes14.dex */
class DurationUnitKt__DurationUnitJvmKt {

    @kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[java.util.concurrent.TimeUnit.values().length];
            iArr[java.util.concurrent.TimeUnit.NANOSECONDS.ordinal()] = 1;
            iArr[java.util.concurrent.TimeUnit.MICROSECONDS.ordinal()] = 2;
            iArr[java.util.concurrent.TimeUnit.MILLISECONDS.ordinal()] = 3;
            iArr[java.util.concurrent.TimeUnit.SECONDS.ordinal()] = 4;
            iArr[java.util.concurrent.TimeUnit.MINUTES.ordinal()] = 5;
            iArr[java.util.concurrent.TimeUnit.HOURS.ordinal()] = 6;
            iArr[java.util.concurrent.TimeUnit.DAYS.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @kotlin.SinceKotlin(version = "1.3")
    public static final double convertDurationUnit(double d, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit sourceUnit, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit targetUnit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        long convert = targetUnit.getTimeUnit().convert(1L, sourceUnit.getTimeUnit());
        return convert > 0 ? d * convert : d / sourceUnit.getTimeUnit().convert(1L, targetUnit.getTimeUnit());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    public static final long convertDurationUnit(long j, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit sourceUnit, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit targetUnit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j, sourceUnit.getTimeUnit());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    public static final long convertDurationUnitOverflow(long j, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit sourceUnit, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit targetUnit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
        return targetUnit.getTimeUnit().convert(j, sourceUnit.getTimeUnit());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    public static final kotlin.time.DurationUnit toDurationUnit(@org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit timeUnit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(timeUnit, "<this>");
        switch (kotlin.time.DurationUnitKt__DurationUnitJvmKt.WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
            case 1:
                return kotlin.time.DurationUnit.NANOSECONDS;
            case 2:
                return kotlin.time.DurationUnit.MICROSECONDS;
            case 3:
                return kotlin.time.DurationUnit.MILLISECONDS;
            case 4:
                return kotlin.time.DurationUnit.SECONDS;
            case 5:
                return kotlin.time.DurationUnit.MINUTES;
            case 6:
                return kotlin.time.DurationUnit.HOURS;
            case 7:
                return kotlin.time.DurationUnit.DAYS;
            default:
                throw new kotlin.NoWhenBranchMatchedException();
        }
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.time.ExperimentalTime
    @org.jetbrains.annotations.NotNull
    public static final java.util.concurrent.TimeUnit toTimeUnit(@org.jetbrains.annotations.NotNull kotlin.time.DurationUnit durationUnit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(durationUnit, "<this>");
        return durationUnit.getTimeUnit();
    }
}
