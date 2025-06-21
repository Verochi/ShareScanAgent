package kotlin.time;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0002ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\u00020\u00028\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "elapsedNow", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "a", "Lkotlin/time/TimeMark;", "getMark", "()Lkotlin/time/TimeMark;", com.anythink.expressad.foundation.d.h.cG, "b", "J", "getAdjustment-UwyO8pc", "adjustment", "<init>", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.time.ExperimentalTime
/* loaded from: classes14.dex */
final class AdjustedTimeMark implements kotlin.time.TimeMark {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.time.TimeMark mark;

    /* renamed from: b, reason: from kotlin metadata */
    public final long adjustment;

    public AdjustedTimeMark(kotlin.time.TimeMark timeMark, long j) {
        this.mark = timeMark;
        this.adjustment = j;
    }

    public /* synthetic */ AdjustedTimeMark(kotlin.time.TimeMark timeMark, long j, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, j);
    }

    @Override // kotlin.time.TimeMark
    /* renamed from: elapsedNow-UwyO8pc */
    public long mo625elapsedNowUwyO8pc() {
        return kotlin.time.Duration.m660minusLRDsOJo(this.mark.mo625elapsedNowUwyO8pc(), this.adjustment);
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
        return new kotlin.time.AdjustedTimeMark(this.mark, kotlin.time.Duration.m661plusLRDsOJo(this.adjustment, duration), null);
    }
}
