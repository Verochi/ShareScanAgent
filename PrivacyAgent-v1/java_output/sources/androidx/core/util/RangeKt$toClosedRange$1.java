package androidx.core.util;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u001c\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"androidx/core/util/RangeKt$toClosedRange$1", "Lkotlin/ranges/ClosedRange;", "endInclusive", "kotlin.jvm.PlatformType", "getEndInclusive", "()Ljava/lang/Comparable;", com.anythink.expressad.foundation.d.c.bT, "getStart", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class RangeKt$toClosedRange$1<T> implements kotlin.ranges.ClosedRange<T> {
    final /* synthetic */ android.util.Range $this_toClosedRange;

    public RangeKt$toClosedRange$1(android.util.Range<T> range) {
        this.$this_toClosedRange = range;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    @Override // kotlin.ranges.ClosedRange
    public boolean contains(@org.jetbrains.annotations.NotNull java.lang.Comparable value) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");
        return kotlin.ranges.ClosedRange.DefaultImpls.contains(this, value);
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.ranges.ClosedRange
    public java.lang.Comparable getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.ranges.ClosedRange
    public java.lang.Comparable getStart() {
        return this.$this_toClosedRange.getLower();
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return kotlin.ranges.ClosedRange.DefaultImpls.isEmpty(this);
    }
}
