package kotlin.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007\u001a\u000e\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\t\u001a\u000e\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b\u001a\u000e\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r\u001a\u000e\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f\u001a\u000e\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"iterator", "Lkotlin/collections/BooleanIterator;", "array", "", "Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/ShortIterator;", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ArrayIteratorsKt {
    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.BooleanIterator iterator(@org.jetbrains.annotations.NotNull boolean[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayBooleanIterator(array);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.ByteIterator iterator(@org.jetbrains.annotations.NotNull byte[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayByteIterator(array);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.CharIterator iterator(@org.jetbrains.annotations.NotNull char[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayCharIterator(array);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.DoubleIterator iterator(@org.jetbrains.annotations.NotNull double[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayDoubleIterator(array);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.FloatIterator iterator(@org.jetbrains.annotations.NotNull float[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayFloatIterator(array);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.IntIterator iterator(@org.jetbrains.annotations.NotNull int[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayIntIterator(array);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.LongIterator iterator(@org.jetbrains.annotations.NotNull long[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayLongIterator(array);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.collections.ShortIterator iterator(@org.jetbrains.annotations.NotNull short[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        return new kotlin.jvm.internal.ArrayShortIterator(array);
    }
}
