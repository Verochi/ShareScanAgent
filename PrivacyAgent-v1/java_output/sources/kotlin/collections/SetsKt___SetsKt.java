package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\u0002\u001a-\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0002\u001a.\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\n\u0010\u0004\u001a6\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0086\u0002¢\u0006\u0004\b\n\u0010\u0007\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\u0002\u001a-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086\u0002¨\u0006\u000b"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "element", "minus", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "plus", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/SetsKt")
/* loaded from: classes14.dex */
class SetsKt___SetsKt extends kotlin.collections.SetsKt__SetsKt {
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> minus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> elements) {
        java.util.Set<T> set2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.util.Collection<?> convertToSetForSetOperationWith = kotlin.collections.BrittleContainsOptimizationKt.convertToSetForSetOperationWith(elements, set);
        if (convertToSetForSetOperationWith.isEmpty()) {
            set2 = kotlin.collections.CollectionsKt___CollectionsKt.toSet(set);
            return set2;
        }
        if (!(convertToSetForSetOperationWith instanceof java.util.Set)) {
            java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(set);
            linkedHashSet.removeAll(convertToSetForSetOperationWith);
            return linkedHashSet;
        }
        java.util.LinkedHashSet linkedHashSet2 = new java.util.LinkedHashSet();
        for (T t : set) {
            if (!convertToSetForSetOperationWith.contains(t)) {
                linkedHashSet2.add(t);
            }
        }
        return linkedHashSet2;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> minus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, T t) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(set.size());
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(mapCapacity);
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && kotlin.jvm.internal.Intrinsics.areEqual(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> minus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(set);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> minus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, @org.jetbrains.annotations.NotNull T[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(set);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.removeAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> plus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> elements) {
        int size;
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.lang.Integer collectionSizeOrNull = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrNull(elements);
        if (collectionSizeOrNull != null) {
            size = set.size() + collectionSizeOrNull.intValue();
        } else {
            size = set.size() * 2;
        }
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(size);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(set);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> plus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, T t) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(set.size() + 1);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> plus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> elements) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(set.size() * 2);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(set);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> plus(@org.jetbrains.annotations.NotNull java.util.Set<? extends T> set, @org.jetbrains.annotations.NotNull T[] elements) {
        int mapCapacity;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(set, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        mapCapacity = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(set.size() + elements.length);
        java.util.LinkedHashSet linkedHashSet = new java.util.LinkedHashSet(mapCapacity);
        linkedHashSet.addAll(set);
        kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(linkedHashSet, elements);
        return linkedHashSet;
    }
}
