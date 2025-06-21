package kotlin.time;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b3\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\t\u001a\"\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002\u001a\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001a\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0017\u001a\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001a\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0017\u001a\u001a\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0017\"\u0014\u0010 \u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010#\"\u0014\u0010$\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b$\u0010#\"!\u0010)\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&\"!\u0010)\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b'\u0010*\u001a\u0004\b%\u0010\u0017\"!\u0010)\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b'\u0010,\u001a\u0004\b%\u0010+\"!\u0010/\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b.\u0010(\u001a\u0004\b-\u0010&\"!\u0010/\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b.\u0010*\u001a\u0004\b-\u0010\u0017\"!\u0010/\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b.\u0010,\u001a\u0004\b-\u0010+\"!\u00102\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u0010(\u001a\u0004\b0\u0010&\"!\u00102\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u0010*\u001a\u0004\b0\u0010\u0017\"!\u00102\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b1\u0010,\u001a\u0004\b0\u0010+\"!\u00105\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b4\u0010(\u001a\u0004\b3\u0010&\"!\u00105\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b4\u0010*\u001a\u0004\b3\u0010\u0017\"!\u00105\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b4\u0010,\u001a\u0004\b3\u0010+\"!\u00108\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b7\u0010(\u001a\u0004\b6\u0010&\"!\u00108\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b7\u0010*\u001a\u0004\b6\u0010\u0017\"!\u00108\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b7\u0010,\u001a\u0004\b6\u0010+\"!\u0010;\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u0010(\u001a\u0004\b9\u0010&\"!\u0010;\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u0010*\u001a\u0004\b9\u0010\u0017\"!\u0010;\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b:\u0010,\u001a\u0004\b9\u0010+\"!\u0010>\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b=\u0010(\u001a\u0004\b<\u0010&\"!\u0010>\u001a\u00020\u0003*\u00020\u00068FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b=\u0010*\u001a\u0004\b<\u0010\u0017\"!\u0010>\u001a\u00020\u0003*\u00020\b8FX\u0087\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b=\u0010,\u001a\u0004\b<\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"", "Lkotlin/time/DurationUnit;", "unit", "Lkotlin/time/Duration;", "toDuration", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "", "value", "", "strictIso", "h", "(Ljava/lang/String;Z)J", "i", "nanos", "g", org.apache.tools.ant.types.selectors.DateSelector.MILLIS_KEY, "f", "normalNanos", "d", "(J)J", "normalMillis", "b", "normalValue", "unitDiscriminator", "a", "(JI)J", "e", "c", "NANOS_IN_MILLIS", "I", "MAX_NANOS", "J", "MAX_MILLIS", "getNanoseconds", "(I)J", "getNanoseconds$annotations", "(I)V", "nanoseconds", "(J)V", "(D)J", "(D)V", "getMicroseconds", "getMicroseconds$annotations", "microseconds", "getMilliseconds", "getMilliseconds$annotations", "milliseconds", "getSeconds", "getSeconds$annotations", "seconds", "getMinutes", "getMinutes$annotations", "minutes", "getHours", "getHours$annotations", "hours", "getDays", "getDays$annotations", "days", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DurationKt {
    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long a(long j, int i) {
        return kotlin.time.Duration.m630constructorimpl((j << 1) + i);
    }

    public static final long b(long j) {
        return kotlin.time.Duration.m630constructorimpl((j << 1) + 1);
    }

    public static final long c(long j) {
        long coerceIn;
        if (new kotlin.ranges.LongRange(-4611686018426L, 4611686018426L).contains(j)) {
            return d(f(j));
        }
        coerceIn = kotlin.ranges.RangesKt___RangesKt.coerceIn(j, -4611686018427387903L, MAX_MILLIS);
        return b(coerceIn);
    }

    public static final long d(long j) {
        return kotlin.time.Duration.m630constructorimpl(j << 1);
    }

    public static final long e(long j) {
        return new kotlin.ranges.LongRange(-4611686018426999999L, MAX_NANOS).contains(j) ? d(j) : b(g(j));
    }

    public static final long f(long j) {
        return j * 1000000;
    }

    public static final long g(long j) {
        return j / 1000000;
    }

    public static final long getDays(double d) {
        return toDuration(d, kotlin.time.DurationUnit.DAYS);
    }

    public static final long getDays(int i) {
        return toDuration(i, kotlin.time.DurationUnit.DAYS);
    }

    public static final long getDays(long j) {
        return toDuration(j, kotlin.time.DurationUnit.DAYS);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getDays$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getDays$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.days", imports = {"kotlin.time.Duration.Companion.days"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getDays$annotations(long j) {
    }

    public static final long getHours(double d) {
        return toDuration(d, kotlin.time.DurationUnit.HOURS);
    }

    public static final long getHours(int i) {
        return toDuration(i, kotlin.time.DurationUnit.HOURS);
    }

    public static final long getHours(long j) {
        return toDuration(j, kotlin.time.DurationUnit.HOURS);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getHours$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getHours$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.hours", imports = {"kotlin.time.Duration.Companion.hours"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getHours$annotations(long j) {
    }

    public static final long getMicroseconds(double d) {
        return toDuration(d, kotlin.time.DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(int i) {
        return toDuration(i, kotlin.time.DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(long j) {
        return toDuration(j, kotlin.time.DurationUnit.MICROSECONDS);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.microseconds", imports = {"kotlin.time.Duration.Companion.microseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMicroseconds$annotations(long j) {
    }

    public static final long getMilliseconds(double d) {
        return toDuration(d, kotlin.time.DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(int i) {
        return toDuration(i, kotlin.time.DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(long j) {
        return toDuration(j, kotlin.time.DurationUnit.MILLISECONDS);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.milliseconds", imports = {"kotlin.time.Duration.Companion.milliseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMilliseconds$annotations(long j) {
    }

    public static final long getMinutes(double d) {
        return toDuration(d, kotlin.time.DurationUnit.MINUTES);
    }

    public static final long getMinutes(int i) {
        return toDuration(i, kotlin.time.DurationUnit.MINUTES);
    }

    public static final long getMinutes(long j) {
        return toDuration(j, kotlin.time.DurationUnit.MINUTES);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minutes", imports = {"kotlin.time.Duration.Companion.minutes"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getMinutes$annotations(long j) {
    }

    public static final long getNanoseconds(double d) {
        return toDuration(d, kotlin.time.DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(int i) {
        return toDuration(i, kotlin.time.DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(long j) {
        return toDuration(j, kotlin.time.DurationUnit.NANOSECONDS);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.nanoseconds", imports = {"kotlin.time.Duration.Companion.nanoseconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getNanoseconds$annotations(long j) {
    }

    public static final long getSeconds(double d) {
        return toDuration(d, kotlin.time.DurationUnit.SECONDS);
    }

    public static final long getSeconds(int i) {
        return toDuration(i, kotlin.time.DurationUnit.SECONDS);
    }

    public static final long getSeconds(long j) {
        return toDuration(j, kotlin.time.DurationUnit.SECONDS);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(double d) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(int i) {
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.seconds", imports = {"kotlin.time.Duration.Companion.seconds"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.time.ExperimentalTime
    public static /* synthetic */ void getSeconds$annotations(long j) {
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a A[LOOP:1: B:25:0x006c->B:33:0x009a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a6 A[EDGE_INSN: B:34:0x00a6->B:35:0x00a6 BREAK  A[LOOP:1: B:25:0x006c->B:33:0x009a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long h(java.lang.String str, boolean z) {
        boolean z2;
        int i;
        char last;
        int i2;
        boolean z3;
        boolean contains$default;
        boolean startsWith$default;
        int length = str.length();
        if (length == 0) {
            throw new java.lang.IllegalArgumentException("The string is empty");
        }
        kotlin.time.Duration.Companion companion = kotlin.time.Duration.INSTANCE;
        long m706getZEROUwyO8pc = companion.m706getZEROUwyO8pc();
        char charAt = str.charAt(0);
        int i3 = (charAt == '+' || charAt == '-') ? 1 : 0;
        boolean z4 = i3 > 0;
        if (z4) {
            startsWith$default = kotlin.text.StringsKt__StringsKt.startsWith$default((java.lang.CharSequence) str, '-', false, 2, (java.lang.Object) null);
            if (startsWith$default) {
                z2 = true;
                if (length > i3) {
                    throw new java.lang.IllegalArgumentException("No components");
                }
                char c = '0';
                if (str.charAt(i3) == 'P') {
                    int i4 = i3 + 1;
                    if (i4 == length) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    boolean z5 = false;
                    kotlin.time.DurationUnit durationUnit = null;
                    while (i4 < length) {
                        if (str.charAt(i4) != 'T') {
                            int i5 = i4;
                            while (true) {
                                if (i5 >= str.length()) {
                                    i2 = length;
                                    break;
                                }
                                char charAt2 = str.charAt(i5);
                                if (!new kotlin.ranges.CharRange(c, '9').contains(charAt2)) {
                                    i2 = length;
                                    contains$default = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) "+-.", charAt2, false, 2, (java.lang.Object) null);
                                    if (!contains$default) {
                                        z3 = false;
                                        if (z3) {
                                            break;
                                        }
                                        i5++;
                                        length = i2;
                                        c = '0';
                                    }
                                } else {
                                    i2 = length;
                                }
                                z3 = true;
                                if (z3) {
                                }
                            }
                            kotlin.jvm.internal.Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                            java.lang.String substring = str.substring(i4, i5);
                            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                            if (substring.length() == 0) {
                                throw new java.lang.IllegalArgumentException();
                            }
                            int length2 = i4 + substring.length();
                            if (length2 < 0 || length2 > kotlin.text.StringsKt__StringsKt.getLastIndex(str)) {
                                throw new java.lang.IllegalArgumentException("Missing unit for value " + substring);
                            }
                            char charAt3 = str.charAt(length2);
                            i4 = length2 + 1;
                            kotlin.time.DurationUnit durationUnitByIsoChar = kotlin.time.DurationUnitKt__DurationUnitKt.durationUnitByIsoChar(charAt3, z5);
                            if (durationUnit != null && durationUnit.compareTo(durationUnitByIsoChar) <= 0) {
                                throw new java.lang.IllegalArgumentException("Unexpected order of duration components");
                            }
                            int indexOf$default = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) substring, '.', 0, false, 6, (java.lang.Object) null);
                            if (durationUnitByIsoChar != kotlin.time.DurationUnit.SECONDS || indexOf$default <= 0) {
                                m706getZEROUwyO8pc = kotlin.time.Duration.m661plusLRDsOJo(m706getZEROUwyO8pc, toDuration(i(substring), durationUnitByIsoChar));
                            } else {
                                kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                java.lang.String substring2 = substring.substring(0, indexOf$default);
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                long m661plusLRDsOJo = kotlin.time.Duration.m661plusLRDsOJo(m706getZEROUwyO8pc, toDuration(i(substring2), durationUnitByIsoChar));
                                kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
                                java.lang.String substring3 = substring.substring(indexOf$default);
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                                m706getZEROUwyO8pc = kotlin.time.Duration.m661plusLRDsOJo(m661plusLRDsOJo, toDuration(java.lang.Double.parseDouble(substring3), durationUnitByIsoChar));
                            }
                            durationUnit = durationUnitByIsoChar;
                            length = i2;
                            c = '0';
                        } else {
                            if (z5 || (i4 = i4 + 1) == length) {
                                throw new java.lang.IllegalArgumentException();
                            }
                            z5 = true;
                        }
                    }
                } else {
                    if (z) {
                        throw new java.lang.IllegalArgumentException();
                    }
                    java.lang.String str2 = "null cannot be cast to non-null type java.lang.String";
                    java.lang.String str3 = "this as java.lang.String).substring(startIndex)";
                    if (kotlin.text.StringsKt__StringsJVMKt.regionMatches(str, i3, "Infinity", 0, java.lang.Math.max(length - i3, 8), true)) {
                        m706getZEROUwyO8pc = companion.m704getINFINITEUwyO8pc();
                    } else {
                        boolean z6 = !z4;
                        if (z4 && str.charAt(i3) == '(') {
                            last = kotlin.text.StringsKt___StringsKt.last(str);
                            if (last == ')') {
                                i3++;
                                int i6 = length - 1;
                                if (i3 == i6) {
                                    throw new java.lang.IllegalArgumentException("No components");
                                }
                                i = i6;
                                z6 = true;
                                boolean z7 = false;
                                kotlin.time.DurationUnit durationUnit2 = null;
                                while (i3 < i) {
                                    if (z7 && z6) {
                                        while (i3 < str.length()) {
                                            if (!(str.charAt(i3) == ' ')) {
                                                break;
                                            }
                                            i3++;
                                        }
                                    }
                                    int i7 = i3;
                                    while (i7 < str.length()) {
                                        char charAt4 = str.charAt(i7);
                                        if (!(new kotlin.ranges.CharRange('0', '9').contains(charAt4) || charAt4 == '.')) {
                                            break;
                                        }
                                        i7++;
                                    }
                                    java.lang.String str4 = str2;
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(str, str4);
                                    java.lang.String substring4 = str.substring(i3, i7);
                                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                                    if (substring4.length() == 0) {
                                        throw new java.lang.IllegalArgumentException();
                                    }
                                    int length3 = i3 + substring4.length();
                                    int i8 = length3;
                                    while (i8 < str.length()) {
                                        if (!new kotlin.ranges.CharRange('a', 'z').contains(str.charAt(i8))) {
                                            break;
                                        }
                                        i8++;
                                    }
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(str, str4);
                                    java.lang.String substring5 = str.substring(length3, i8);
                                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
                                    i3 = length3 + substring5.length();
                                    kotlin.time.DurationUnit durationUnitByShortName = kotlin.time.DurationUnitKt__DurationUnitKt.durationUnitByShortName(substring5);
                                    if (durationUnit2 != null && durationUnit2.compareTo(durationUnitByShortName) <= 0) {
                                        throw new java.lang.IllegalArgumentException("Unexpected order of duration components");
                                    }
                                    int indexOf$default2 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) substring4, '.', 0, false, 6, (java.lang.Object) null);
                                    if (indexOf$default2 > 0) {
                                        kotlin.jvm.internal.Intrinsics.checkNotNull(substring4, str4);
                                        java.lang.String substring6 = substring4.substring(0, indexOf$default2);
                                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring6, "this as java.lang.String…ing(startIndex, endIndex)");
                                        long m661plusLRDsOJo2 = kotlin.time.Duration.m661plusLRDsOJo(m706getZEROUwyO8pc, toDuration(java.lang.Long.parseLong(substring6), durationUnitByShortName));
                                        kotlin.jvm.internal.Intrinsics.checkNotNull(substring4, str4);
                                        java.lang.String substring7 = substring4.substring(indexOf$default2);
                                        java.lang.String str5 = str3;
                                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring7, str5);
                                        m706getZEROUwyO8pc = kotlin.time.Duration.m661plusLRDsOJo(m661plusLRDsOJo2, toDuration(java.lang.Double.parseDouble(substring7), durationUnitByShortName));
                                        if (i3 < i) {
                                            throw new java.lang.IllegalArgumentException("Fractional component must be last");
                                        }
                                        str3 = str5;
                                    } else {
                                        m706getZEROUwyO8pc = kotlin.time.Duration.m661plusLRDsOJo(m706getZEROUwyO8pc, toDuration(java.lang.Long.parseLong(substring4), durationUnitByShortName));
                                    }
                                    str2 = str4;
                                    durationUnit2 = durationUnitByShortName;
                                    z7 = true;
                                }
                            }
                        }
                        i = length;
                        boolean z72 = false;
                        kotlin.time.DurationUnit durationUnit22 = null;
                        while (i3 < i) {
                        }
                    }
                }
                return z2 ? kotlin.time.Duration.m677unaryMinusUwyO8pc(m706getZEROUwyO8pc) : m706getZEROUwyO8pc;
            }
        }
        z2 = false;
        if (length > i3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long i(java.lang.String str) {
        int i;
        boolean z;
        boolean contains$default;
        int length = str.length();
        if (length > 0) {
            contains$default = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) "+-", str.charAt(0), false, 2, (java.lang.Object) null);
            if (contains$default) {
                i = 1;
                if (length - i > 16) {
                    java.lang.Iterable intRange = new kotlin.ranges.IntRange(i, kotlin.text.StringsKt__StringsKt.getLastIndex(str));
                    if (!(intRange instanceof java.util.Collection) || !((java.util.Collection) intRange).isEmpty()) {
                        java.util.Iterator it = intRange.iterator();
                        while (it.hasNext()) {
                            if (!new kotlin.ranges.CharRange('0', '9').contains(str.charAt(((kotlin.collections.IntIterator) it).nextInt()))) {
                                z = false;
                                break;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                    }
                }
                if (kotlin.text.StringsKt__StringsJVMKt.startsWith$default(str, "+", false, 2, null)) {
                    str = kotlin.text.StringsKt___StringsKt.drop(str, 1);
                }
                return java.lang.Long.parseLong(str);
            }
        }
        i = 0;
        if (length - i > 16) {
        }
        if (kotlin.text.StringsKt__StringsJVMKt.startsWith$default(str, "+", false, 2, null)) {
        }
        return java.lang.Long.parseLong(str);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.WasExperimental(markerClass = {kotlin.time.ExperimentalTime.class})
    public static final long toDuration(double d, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit) {
        long roundToLong;
        long roundToLong2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, unit, kotlin.time.DurationUnit.NANOSECONDS);
        if (!(!java.lang.Double.isNaN(convertDurationUnit))) {
            throw new java.lang.IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        roundToLong = kotlin.math.MathKt__MathJVMKt.roundToLong(convertDurationUnit);
        if (new kotlin.ranges.LongRange(-4611686018426999999L, MAX_NANOS).contains(roundToLong)) {
            return d(roundToLong);
        }
        roundToLong2 = kotlin.math.MathKt__MathJVMKt.roundToLong(kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d, unit, kotlin.time.DurationUnit.MILLISECONDS));
        return c(roundToLong2);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.WasExperimental(markerClass = {kotlin.time.ExperimentalTime.class})
    public static final long toDuration(int i, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.compareTo(kotlin.time.DurationUnit.SECONDS) <= 0 ? d(kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(i, unit, kotlin.time.DurationUnit.NANOSECONDS)) : toDuration(i, unit);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6)
    @kotlin.WasExperimental(markerClass = {kotlin.time.ExperimentalTime.class})
    public static final long toDuration(long j, @org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit) {
        long coerceIn;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        kotlin.time.DurationUnit durationUnit = kotlin.time.DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(MAX_NANOS, durationUnit, unit);
        if (new kotlin.ranges.LongRange(-convertDurationUnitOverflow, convertDurationUnitOverflow).contains(j)) {
            return d(kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnitOverflow(j, unit, durationUnit));
        }
        coerceIn = kotlin.ranges.RangesKt___RangesKt.coerceIn(kotlin.time.DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(j, unit, kotlin.time.DurationUnit.MILLISECONDS), -4611686018427387903L, MAX_MILLIS);
        return b(coerceIn);
    }
}
