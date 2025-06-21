package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0003\u001a\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a \u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0001\u001a\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0001\u001a@\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\u0001¨\u0006\f"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "default", "collectionSizeOrDefault", "", "flatten", "R", "Lkotlin/Pair;", "unzip", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes14.dex */
public class CollectionsKt__IterablesKt extends kotlin.collections.CollectionsKt__CollectionsKt {
    @kotlin.PublishedApi
    public static <T> int collectionSizeOrDefault(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        return iterable instanceof java.util.Collection ? ((java.util.Collection) iterable).size() : i;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public static final <T> java.lang.Integer collectionSizeOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof java.util.Collection) {
            return java.lang.Integer.valueOf(((java.util.Collection) iterable).size());
        }
        return null;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> flatten(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends java.lang.Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<? extends java.lang.Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(arrayList, it.next());
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlin.Pair<java.util.List<T>, java.util.List<R>> unzip(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends kotlin.Pair<? extends T, ? extends R>> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        int collectionSizeOrDefault = collectionSizeOrDefault(iterable, 10);
        java.util.ArrayList arrayList = new java.util.ArrayList(collectionSizeOrDefault);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(collectionSizeOrDefault);
        for (kotlin.Pair<? extends T, ? extends R> pair : iterable) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.TuplesKt.to(arrayList, arrayList2);
    }
}
