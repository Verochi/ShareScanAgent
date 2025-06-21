package kotlin.ranges;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0011\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0016¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/ClosedFloatRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "a", "b", "", "d", "value", "isEmpty", "", "other", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "F", "_start", "t", "_endInclusive", "c", "()Ljava/lang/Float;", com.anythink.expressad.foundation.d.c.bT, "endInclusive", "<init>", "(FF)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class ClosedFloatRange implements kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> {

    /* renamed from: n, reason: from kotlin metadata */
    public final float _start;

    /* renamed from: t, reason: from kotlin metadata */
    public final float _endInclusive;

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    public boolean a(float value) {
        return value >= this._start && value <= this._endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    @org.jetbrains.annotations.NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public java.lang.Float getEndInclusive() {
        return java.lang.Float.valueOf(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    @org.jetbrains.annotations.NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public java.lang.Float getStart() {
        return java.lang.Float.valueOf(this._start);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(java.lang.Comparable comparable) {
        return a(((java.lang.Number) comparable).floatValue());
    }

    public boolean d(float a, float b) {
        return a <= b;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (!(other instanceof kotlin.ranges.ClosedFloatRange)) {
            return false;
        }
        if (!isEmpty() || !((kotlin.ranges.ClosedFloatRange) other).isEmpty()) {
            kotlin.ranges.ClosedFloatRange closedFloatRange = (kotlin.ranges.ClosedFloatRange) other;
            if (!(this._start == closedFloatRange._start)) {
                return false;
            }
            if (!(this._endInclusive == closedFloatRange._endInclusive)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (java.lang.Float.valueOf(this._start).hashCode() * 31) + java.lang.Float.valueOf(this._endInclusive).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this._start > this._endInclusive;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(java.lang.Float f, java.lang.Float f2) {
        return d(f.floatValue(), f2.floatValue());
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
