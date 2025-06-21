package kotlin.ranges;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0010\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lkotlin/ranges/ComparableRange;", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/ranges/ClosedRange;", "", "other", "", "equals", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Ljava/lang/Comparable;", "getStart", "()Ljava/lang/Comparable;", com.anythink.expressad.foundation.d.c.bT, "t", "getEndInclusive", "endInclusive", "<init>", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
class ComparableRange<T extends java.lang.Comparable<? super T>> implements kotlin.ranges.ClosedRange<T> {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final T start;

    /* renamed from: t, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final T endInclusive;

    public ComparableRange(@org.jetbrains.annotations.NotNull T start, @org.jetbrains.annotations.NotNull T endInclusive) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(start, "start");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
        this.start = start;
        this.endInclusive = endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean contains(@org.jetbrains.annotations.NotNull T t) {
        return kotlin.ranges.ClosedRange.DefaultImpls.contains(this, t);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (other instanceof kotlin.ranges.ComparableRange) {
            if (!isEmpty() || !((kotlin.ranges.ComparableRange) other).isEmpty()) {
                kotlin.ranges.ComparableRange comparableRange = (kotlin.ranges.ComparableRange) other;
                if (!kotlin.jvm.internal.Intrinsics.areEqual(getStart(), comparableRange.getStart()) || !kotlin.jvm.internal.Intrinsics.areEqual(getEndInclusive(), comparableRange.getEndInclusive())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    @org.jetbrains.annotations.NotNull
    public T getEndInclusive() {
        return this.endInclusive;
    }

    @Override // kotlin.ranges.ClosedRange
    @org.jetbrains.annotations.NotNull
    public T getStart() {
        return this.start;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return kotlin.ranges.ClosedRange.DefaultImpls.isEmpty(this);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
