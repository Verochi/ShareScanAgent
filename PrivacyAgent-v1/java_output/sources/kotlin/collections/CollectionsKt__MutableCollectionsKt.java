package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\u001a&\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a&\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u001a/\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0005\u0010\b\u001a&\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a&\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u001a/\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\b\u001a&\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a/\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007¢\u0006\u0004\b\n\u0010\b\u001a&\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u001a\u0017\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a*\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000e\u001a*\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000e\u001a;\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a!\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u001f\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0015\u001a!\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0007¢\u0006\u0004\b\u0018\u0010\u0015\u001a*\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000e\u001a*\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000e\u001a;\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00132\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "elements", "", "addAll", "Lkotlin/sequences/Sequence;", "", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "removeAll", "retainAll", "d", "(Ljava/util/Collection;)Z", "", "Lkotlin/Function1;", "predicate", "predicateResultToRemove", "b", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;Z)Z", "", "removeFirst", "(Ljava/util/List;)Ljava/lang/Object;", "removeFirstOrNull", "removeLast", "removeLastOrNull", "c", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Z)Z", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes14.dex */
public class CollectionsKt__MutableCollectionsKt extends kotlin.collections.CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean addAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof java.util.Collection) {
            return collection.addAll((java.util.Collection) elements);
        }
        java.util.Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean addAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.util.Iterator<? extends T> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean addAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull T[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return collection.addAll(kotlin.collections.ArraysKt___ArraysJvmKt.asList(elements));
    }

    public static final <T> boolean b(java.lang.Iterable<? extends T> iterable, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> function1, boolean z) {
        java.util.Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public static final <T> boolean c(java.util.List<T> list, kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> function1, boolean z) {
        if (!(list instanceof java.util.RandomAccess)) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return b(kotlin.jvm.internal.TypeIntrinsics.asMutableIterable(list), function1, z);
        }
        ?? it = new kotlin.ranges.IntRange(0, kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list)).iterator();
        int i = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t = list.get(nextInt);
            if (function1.invoke(t).booleanValue() != z) {
                if (i != nextInt) {
                    list.set(i, t);
                }
                i++;
            }
        }
        if (i >= list.size()) {
            return false;
        }
        int lastIndex = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list);
        if (i > lastIndex) {
            return true;
        }
        while (true) {
            list.remove(lastIndex);
            if (lastIndex == i) {
                return true;
            }
            lastIndex--;
        }
    }

    public static final boolean d(java.util.Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static final <T> boolean removeAll(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        return b(iterable, predicate, true);
    }

    public static final <T> boolean removeAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(collection).removeAll(kotlin.collections.BrittleContainsOptimizationKt.convertToSetForSetOperationWith(elements, collection));
    }

    public static final <T> boolean removeAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.util.Collection<?> convertToSetForSetOperation = kotlin.collections.BrittleContainsOptimizationKt.convertToSetForSetOperation(elements);
        return (convertToSetForSetOperation.isEmpty() ^ true) && collection.removeAll(convertToSetForSetOperation);
    }

    public static final <T> boolean removeAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull T[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return ((elements.length == 0) ^ true) && collection.removeAll(kotlin.collections.BrittleContainsOptimizationKt.convertToSetForSetOperation(elements));
    }

    public static <T> boolean removeAll(@org.jetbrains.annotations.NotNull java.util.List<T> list, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        return c(list, predicate, true);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final <T> T removeFirst(@org.jetbrains.annotations.NotNull java.util.List<T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final <T> T removeFirstOrNull(@org.jetbrains.annotations.NotNull java.util.List<T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static <T> T removeLast(@org.jetbrains.annotations.NotNull java.util.List<T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            throw new java.util.NoSuchElementException("List is empty.");
        }
        return list.remove(kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final <T> T removeLastOrNull(@org.jetbrains.annotations.NotNull java.util.List<T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    public static <T> boolean retainAll(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        return b(iterable, predicate, false);
    }

    public static final <T> boolean retainAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(collection).retainAll(kotlin.collections.BrittleContainsOptimizationKt.convertToSetForSetOperationWith(elements, collection));
    }

    public static final <T> boolean retainAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        java.util.Collection<?> convertToSetForSetOperation = kotlin.collections.BrittleContainsOptimizationKt.convertToSetForSetOperation(elements);
        return convertToSetForSetOperation.isEmpty() ^ true ? collection.retainAll(convertToSetForSetOperation) : d(collection);
    }

    public static final <T> boolean retainAll(@org.jetbrains.annotations.NotNull java.util.Collection<? super T> collection, @org.jetbrains.annotations.NotNull T[] elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return (elements.length == 0) ^ true ? collection.retainAll(kotlin.collections.BrittleContainsOptimizationKt.convertToSetForSetOperation(elements)) : d(collection);
    }

    public static final <T> boolean retainAll(@org.jetbrains.annotations.NotNull java.util.List<T> list, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        return c(list, predicate, false);
    }
}
