package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\f\u001a6\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¨\u0006\u000e"}, d2 = {"and", "Landroid/util/Range;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "other", "plus", "value", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class RangeKt {
    @androidx.annotation.RequiresApi(21)
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> android.util.Range<T> and(@org.jetbrains.annotations.NotNull android.util.Range<T> and, @org.jetbrains.annotations.NotNull android.util.Range<T> other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(and, "$this$and");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        android.util.Range<T> intersect = and.intersect(other);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(intersect, "intersect(other)");
        return intersect;
    }

    @androidx.annotation.RequiresApi(21)
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> android.util.Range<T> plus(@org.jetbrains.annotations.NotNull android.util.Range<T> plus, @org.jetbrains.annotations.NotNull android.util.Range<T> other) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(other, "other");
        android.util.Range<T> extend = plus.extend(other);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(extend, "extend(other)");
        return extend;
    }

    @androidx.annotation.RequiresApi(21)
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> android.util.Range<T> plus(@org.jetbrains.annotations.NotNull android.util.Range<T> plus, @org.jetbrains.annotations.NotNull T value) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(value, "value");
        android.util.Range<T> extend = plus.extend((android.util.Range<T>) value);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(extend, "extend(value)");
        return extend;
    }

    @androidx.annotation.RequiresApi(21)
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> android.util.Range<T> rangeTo(@org.jetbrains.annotations.NotNull T rangeTo, @org.jetbrains.annotations.NotNull T that) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(rangeTo, "$this$rangeTo");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(that, "that");
        return new android.util.Range<>(rangeTo, that);
    }

    @androidx.annotation.RequiresApi(21)
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> kotlin.ranges.ClosedRange<T> toClosedRange(@org.jetbrains.annotations.NotNull android.util.Range<T> toClosedRange) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toClosedRange, "$this$toClosedRange");
        return new androidx.core.util.RangeKt$toClosedRange$1(toClosedRange);
    }

    @androidx.annotation.RequiresApi(21)
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> android.util.Range<T> toRange(@org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<T> toRange) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toRange, "$this$toRange");
        return new android.util.Range<>(toRange.getStart(), toRange.getEndInclusive());
    }
}
