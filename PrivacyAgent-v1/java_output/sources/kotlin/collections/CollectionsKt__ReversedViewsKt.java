package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0000\u001a%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "", "index", "e", "(Ljava/util/List;I)I", "f", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "asReversed", "", "asReversedMutable", "(Ljava/util/List;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes14.dex */
class CollectionsKt__ReversedViewsKt extends kotlin.collections.CollectionsKt__MutableCollectionsKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> asReversed(@org.jetbrains.annotations.NotNull java.util.List<? extends T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        return new kotlin.collections.ReversedListReadOnly(list);
    }

    @kotlin.jvm.JvmName(name = "asReversedMutable")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> asReversedMutable(@org.jetbrains.annotations.NotNull java.util.List<T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        return new kotlin.collections.ReversedList(list);
    }

    public static final int e(java.util.List<?> list, int i) {
        if (new kotlin.ranges.IntRange(0, kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list)).contains(i)) {
            return kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list) - i;
        }
        throw new java.lang.IndexOutOfBoundsException("Element index " + i + " must be in range [" + new kotlin.ranges.IntRange(0, kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list)) + "].");
    }

    public static final int f(java.util.List<?> list, int i) {
        if (new kotlin.ranges.IntRange(0, list.size()).contains(i)) {
            return list.size() - i;
        }
        throw new java.lang.IndexOutOfBoundsException("Position index " + i + " must be in range [" + new kotlin.ranges.IntRange(0, list.size()) + "].");
    }
}
