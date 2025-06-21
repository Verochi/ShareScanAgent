package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a\u0012\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a7\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\n\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a7\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\rj\b\u0012\u0004\u0012\u00028\u0000`\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0003\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a)\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u00112\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0003\"\u0004\u0018\u00018\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0006\u001a\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¨\u0006\u0016"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "emptySet", "", "elements", "setOf", "([Ljava/lang/Object;)Ljava/util/Set;", "", "mutableSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "hashSetOf", "([Ljava/lang/Object;)Ljava/util/HashSet;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "linkedSetOf", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "", "element", "setOfNotNull", "(Ljava/lang/Object;)Ljava/util/Set;", "optimizeReadOnlySet", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/SetsKt")
/* loaded from: classes14.dex */
public class SetsKt__SetsKt extends kotlin.collections.SetsKt__SetsJVMKt {
    @org.jetbrains.annotations.NotNull
    public static <T> java.util.Set<T> emptySet() {
        return kotlin.collections.EmptySet.INSTANCE;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.HashSet<T> hashSetOf(@org.jetbrains.annotations.NotNull T... elements) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (java.util.HashSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(elements, new java.util.HashSet(mapCapacity));
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.LinkedHashSet<T> linkedSetOf(@org.jetbrains.annotations.NotNull T... elements) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (java.util.LinkedHashSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(elements, new java.util.LinkedHashSet(mapCapacity));
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.Set<T> mutableSetOf(@org.jetbrains.annotations.NotNull T... elements) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(elements.length);
        return (java.util.Set) kotlin.collections.ArraysKt___ArraysKt.toCollection(elements, new java.util.LinkedHashSet(mapCapacity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static <T> java.util.Set<T> optimizeReadOnlySet(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set) {
        java.util.Set<T> emptySet;
        java.util.Set<T> of;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        int size = set.size();
        if (size == 0) {
            emptySet = emptySet();
            return emptySet;
        }
        if (size != 1) {
            return set;
        }
        of = kotlin.collections.SetsKt__SetsJVMKt.setOf(set.iterator().next());
        return of;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> setOf(@org.jetbrains.annotations.NotNull T... elements) {
        java.util.Set<T> emptySet;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length > 0) {
            return kotlin.collections.ArraysKt___ArraysKt.toSet(elements);
        }
        emptySet = emptySet();
        return emptySet;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> setOfNotNull(@org.jetbrains.annotations.Nullable T t) {
        java.util.Set<T> emptySet;
        java.util.Set<T> of;
        if (t != null) {
            of = kotlin.collections.SetsKt__SetsJVMKt.setOf(t);
            return of;
        }
        emptySet = emptySet();
        return emptySet;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> setOfNotNull(@org.jetbrains.annotations.NotNull T... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return (java.util.Set) kotlin.collections.ArraysKt___ArraysKt.filterNotNullTo(elements, new java.util.LinkedHashSet());
    }
}
