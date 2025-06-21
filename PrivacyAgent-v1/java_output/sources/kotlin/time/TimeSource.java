package kotlin.time;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@kotlin.time.ExperimentalTime
/* loaded from: classes14.dex */
public interface TimeSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.time.TimeSource.Companion INSTANCE = kotlin.time.TimeSource.Companion.a;

    @kotlin.Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public static final /* synthetic */ kotlin.time.TimeSource.Companion a = new kotlin.time.TimeSource.Companion();
    }

    @kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Monotonic implements kotlin.time.TimeSource {

        @org.jetbrains.annotations.NotNull
        public static final kotlin.time.TimeSource.Monotonic INSTANCE = new kotlin.time.TimeSource.Monotonic();

        @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
        @kotlin.Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010#\u001a\u00060\u001fj\u0002` ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0019\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001e\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010#\u001a\u00060\u001fj\u0002` 8\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\u0088\u0001#\u0092\u0001\u00060\u001fj\u0002` ø\u0001\u0001\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "(J)J", "elapsedNow", "duration", "plus-LRDsOJo", "(JJ)J", "plus", "minus-LRDsOJo", "minus", "", "hasPassedNow-impl", "(J)Z", "hasPassedNow", "hasNotPassedNow-impl", "hasNotPassedNow", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "", "Lkotlin/time/ValueTimeMarkReading;", "a", "J", "reading", "constructor-impl", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
        @kotlin.jvm.JvmInline
        @kotlin.time.ExperimentalTime
        public static final class ValueTimeMark implements kotlin.time.TimeMark {

            /* renamed from: a, reason: from kotlin metadata */
            public final long reading;

            public /* synthetic */ ValueTimeMark(long j) {
                this.reading = j;
            }

            /* renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ kotlin.time.TimeSource.Monotonic.ValueTimeMark m737boximpl(long j) {
                return new kotlin.time.TimeSource.Monotonic.ValueTimeMark(j);
            }

            /* renamed from: constructor-impl, reason: not valid java name */
            public static long m738constructorimpl(long j) {
                return j;
            }

            /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m739elapsedNowUwyO8pc(long j) {
                return kotlin.time.MonotonicTimeSource.INSTANCE.m731elapsedFrom6eNON_k(j);
            }

            /* renamed from: equals-impl, reason: not valid java name */
            public static boolean m740equalsimpl(long j, java.lang.Object obj) {
                return (obj instanceof kotlin.time.TimeSource.Monotonic.ValueTimeMark) && j == ((kotlin.time.TimeSource.Monotonic.ValueTimeMark) obj).getReading();
            }

            /* renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m741equalsimpl0(long j, long j2) {
                return j == j2;
            }

            /* renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m742hasNotPassedNowimpl(long j) {
                return kotlin.time.Duration.m658isNegativeimpl(m739elapsedNowUwyO8pc(j));
            }

            /* renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m743hasPassedNowimpl(long j) {
                return !kotlin.time.Duration.m658isNegativeimpl(m739elapsedNowUwyO8pc(j));
            }

            /* renamed from: hashCode-impl, reason: not valid java name */
            public static int m744hashCodeimpl(long j) {
                return (int) (j ^ (j >>> 32));
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m745minusLRDsOJo(long j, long j2) {
                return kotlin.time.MonotonicTimeSource.INSTANCE.m730adjustReading6QKq23U(j, kotlin.time.Duration.m677unaryMinusUwyO8pc(j2));
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m746plusLRDsOJo(long j, long j2) {
                return kotlin.time.MonotonicTimeSource.INSTANCE.m730adjustReading6QKq23U(j, j2);
            }

            /* renamed from: toString-impl, reason: not valid java name */
            public static java.lang.String m747toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public long mo625elapsedNowUwyO8pc() {
                return m739elapsedNowUwyO8pc(this.reading);
            }

            public boolean equals(java.lang.Object obj) {
                return m740equalsimpl(this.reading, obj);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m742hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m743hasPassedNowimpl(this.reading);
            }

            public int hashCode() {
                return m744hashCodeimpl(this.reading);
            }

            /* renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m748minusLRDsOJo(long j) {
                return m745minusLRDsOJo(this.reading, j);
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ kotlin.time.TimeMark mo626minusLRDsOJo(long j) {
                return m737boximpl(m748minusLRDsOJo(j));
            }

            /* renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m749plusLRDsOJo(long j) {
                return m746plusLRDsOJo(this.reading, j);
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ kotlin.time.TimeMark mo627plusLRDsOJo(long j) {
                return m737boximpl(m749plusLRDsOJo(j));
            }

            public java.lang.String toString() {
                return m747toStringimpl(this.reading);
            }

            /* renamed from: unbox-impl, reason: not valid java name and from getter */
            public final /* synthetic */ long getReading() {
                return this.reading;
            }
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ kotlin.time.TimeMark markNow() {
            return kotlin.time.TimeSource.Monotonic.ValueTimeMark.m737boximpl(m736markNowz9LOYto());
        }

        /* renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m736markNowz9LOYto() {
            return kotlin.time.MonotonicTimeSource.INSTANCE.m732markNowz9LOYto();
        }

        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return kotlin.time.MonotonicTimeSource.INSTANCE.toString();
        }
    }

    @org.jetbrains.annotations.NotNull
    kotlin.time.TimeMark markNow();
}
