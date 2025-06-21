package kotlin.time;

@kotlin.SinceKotlin(version = "1.3")
@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H$J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\u00020\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "", "read", "Lkotlin/time/TimeMark;", "markNow", "Lkotlin/time/DurationUnit;", "a", "Lkotlin/time/DurationUnit;", "getUnit", "()Lkotlin/time/DurationUnit;", "unit", "<init>", "(Lkotlin/time/DurationUnit;)V", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.time.ExperimentalTime
/* loaded from: classes14.dex */
public abstract class AbstractLongTimeSource implements kotlin.time.TimeSource {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.time.DurationUnit unit;

    @kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0002ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0012\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "elapsedNow", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "", "a", "J", "startedAt", "Lkotlin/time/AbstractLongTimeSource;", "b", "Lkotlin/time/AbstractLongTimeSource;", "timeSource", "c", "offset", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
    public static final class LongTimeMark implements kotlin.time.TimeMark {

        /* renamed from: a, reason: from kotlin metadata */
        public final long startedAt;

        /* renamed from: b, reason: from kotlin metadata */
        @org.jetbrains.annotations.NotNull
        public final kotlin.time.AbstractLongTimeSource timeSource;

        /* renamed from: c, reason: from kotlin metadata */
        public final long offset;

        public LongTimeMark(long j, kotlin.time.AbstractLongTimeSource abstractLongTimeSource, long j2) {
            this.startedAt = j;
            this.timeSource = abstractLongTimeSource;
            this.offset = j2;
        }

        public /* synthetic */ LongTimeMark(long j, kotlin.time.AbstractLongTimeSource abstractLongTimeSource, long j2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public long mo625elapsedNowUwyO8pc() {
            return kotlin.time.Duration.m660minusLRDsOJo(kotlin.time.DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return kotlin.time.TimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return kotlin.time.TimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        @org.jetbrains.annotations.NotNull
        /* renamed from: minus-LRDsOJo */
        public kotlin.time.TimeMark mo626minusLRDsOJo(long j) {
            return kotlin.time.TimeMark.DefaultImpls.m734minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        @org.jetbrains.annotations.NotNull
        /* renamed from: plus-LRDsOJo */
        public kotlin.time.TimeMark mo627plusLRDsOJo(long duration) {
            return new kotlin.time.AbstractLongTimeSource.LongTimeMark(this.startedAt, this.timeSource, kotlin.time.Duration.m661plusLRDsOJo(this.offset, duration), null);
        }
    }

    public AbstractLongTimeSource(@org.jetbrains.annotations.NotNull kotlin.time.DurationUnit unit) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
    }

    @org.jetbrains.annotations.NotNull
    public final kotlin.time.DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource
    @org.jetbrains.annotations.NotNull
    public kotlin.time.TimeMark markNow() {
        return new kotlin.time.AbstractLongTimeSource.LongTimeMark(read(), this, kotlin.time.Duration.INSTANCE.m706getZEROUwyO8pc(), null);
    }

    public abstract long read();
}
