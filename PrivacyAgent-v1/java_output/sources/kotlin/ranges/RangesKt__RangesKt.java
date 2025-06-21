package kotlin.ranges;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0002\u001a\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0087\u0002\u001a\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "that", "Lkotlin/ranges/ClosedRange;", "rangeTo", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "isPositive", "", "step", "", "checkStepIsPositive", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes14.dex */
class RangesKt__RangesKt {
    public static final void checkStepIsPositive(boolean z, @org.jetbrains.annotations.NotNull java.lang.Number step) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            return;
        }
        throw new java.lang.IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.ClosedFloatingPointRange<java.lang.Double> rangeTo(double d, double d2) {
        return new kotlin.ranges.ClosedDoubleRange(d, d2);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> rangeTo(float f, float f2) {
        return new kotlin.ranges.ClosedFloatRange(f, f2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> kotlin.ranges.ClosedRange<T> rangeTo(@org.jetbrains.annotations.NotNull T t, @org.jetbrains.annotations.NotNull T that) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(t, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(that, "that");
        return new kotlin.ranges.ComparableRange(t, that);
    }
}
