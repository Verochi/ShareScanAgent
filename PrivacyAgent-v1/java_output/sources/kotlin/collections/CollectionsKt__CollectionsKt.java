package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u000b\u0010\t\u001a7\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\"\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a5\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010\u0000*\u00020\u00102\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\u0001\"\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\t\u001a&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\u0016\u001a\u00020\u0015H\u0007\u001a\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0000\u001aG\u0010\u001d\u001a\u00020\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0019*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\b\u0010\u0011\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001e\u001aU\u0010\u001d\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0011\u001a\u00028\u00002\u001a\u0010!\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u001fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000` 2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\"\u001ai\u0010'\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u000e\b\u0001\u0010#*\b\u0012\u0004\u0012\u00028\u00010\u0019*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0010$\u001a\u0004\u0018\u00018\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0016\b\u0004\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010%H\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a>\u0010\u001d\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0%\u001a'\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0002¢\u0006\u0004\b,\u0010-\u001a\b\u0010.\u001a\u00020+H\u0001\u001a\b\u0010/\u001a\u00020+H\u0001\"\u0019\u00103\u001a\u000200*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b1\u00102\"!\u00106\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\b4\u00105\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "emptyList", "elements", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "", "mutableListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayListOf", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "", "element", "listOfNotNull", "(Ljava/lang/Object;)Ljava/util/List;", "", "Lkotlin/random/Random;", "random", "shuffled", "optimizeReadOnlyList", "", "", "fromIndex", "toIndex", "binarySearch", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "K", "key", "Lkotlin/Function1;", "selector", "binarySearchBy", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "comparison", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "", "a", "(III)V", "throwIndexOverflow", "throwCountOverflow", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/util/List;)I", "lastIndex", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes14.dex */
public class CollectionsKt__CollectionsKt extends kotlin.collections.CollectionsKt__CollectionsJVMKt {
    public static final void a(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new java.lang.IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new java.lang.IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.ArrayList<T> arrayListOf(@org.jetbrains.annotations.NotNull T... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new java.util.ArrayList<>() : new java.util.ArrayList<>(new kotlin.collections.ArrayAsCollection(elements, true));
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Collection<T> asCollection(@org.jetbrains.annotations.NotNull T[] tArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new kotlin.collections.ArrayAsCollection(tArr, false);
    }

    public static final <T> int binarySearch(@org.jetbrains.annotations.NotNull java.util.List<? extends T> list, int i, int i2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Integer> comparison) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparison, "comparison");
        a(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int intValue = comparison.invoke(list.get(i4)).intValue();
            if (intValue < 0) {
                i = i4 + 1;
            } else {
                if (intValue <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static final <T extends java.lang.Comparable<? super T>> int binarySearch(@org.jetbrains.annotations.NotNull java.util.List<? extends T> list, @org.jetbrains.annotations.Nullable T t, int i, int i2) {
        int compareValues;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        a(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            compareValues = kotlin.comparisons.ComparisonsKt__ComparisonsKt.compareValues(list.get(i4), t);
            if (compareValues < 0) {
                i = i4 + 1;
            } else {
                if (compareValues <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static final <T> int binarySearch(@org.jetbrains.annotations.NotNull java.util.List<? extends T> list, T t, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        a(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int compare = comparator.compare(list.get(i4), t);
            if (compare < 0) {
                i = i4 + 1;
            } else {
                if (compare <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int binarySearch$default(java.util.List list, int i, int i2, kotlin.jvm.functions.Function1 function1, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, i, i2, function1);
    }

    public static /* synthetic */ int binarySearch$default(java.util.List list, java.lang.Comparable comparable, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return binarySearch((java.util.List<? extends java.lang.Comparable>) list, comparable, i, i2);
    }

    public static /* synthetic */ int binarySearch$default(java.util.List list, java.lang.Object obj, java.util.Comparator comparator, int i, int i2, int i3, java.lang.Object obj2) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, obj, comparator, i, i2);
    }

    public static final <T, K extends java.lang.Comparable<? super K>> int binarySearchBy(@org.jetbrains.annotations.NotNull java.util.List<? extends T> list, @org.jetbrains.annotations.Nullable K k, int i, int i2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends K> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        return binarySearch(list, i, i2, new kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1(selector, k));
    }

    public static /* synthetic */ int binarySearchBy$default(java.util.List list, java.lang.Comparable comparable, int i, int i2, kotlin.jvm.functions.Function1 function1, int i3, java.lang.Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return binarySearch(list, i, i2, new kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1(function1, comparable));
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.List<T> emptyList() {
        return kotlin.collections.EmptyList.INSTANCE;
    }

    @org.jetbrains.annotations.NotNull
    public static kotlin.ranges.IntRange getIndices(@org.jetbrains.annotations.NotNull java.util.Collection<?> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        return new kotlin.ranges.IntRange(0, collection.size() - 1);
    }

    public static <T> int getLastIndex(@org.jetbrains.annotations.NotNull java.util.List<? extends T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.List<T> listOf(@org.jetbrains.annotations.NotNull T... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? kotlin.collections.ArraysKt___ArraysJvmKt.asList(elements) : emptyList();
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> listOfNotNull(@org.jetbrains.annotations.Nullable T t) {
        return t != null ? kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(t) : emptyList();
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> listOfNotNull(@org.jetbrains.annotations.NotNull T... elements) {
        java.util.List<T> filterNotNull;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        filterNotNull = kotlin.collections.ArraysKt___ArraysKt.filterNotNull(elements);
        return filterNotNull;
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.List<T> mutableListOf(@org.jetbrains.annotations.NotNull T... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? new java.util.ArrayList() : new java.util.ArrayList(new kotlin.collections.ArrayAsCollection(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static <T> java.util.List<T> optimizeReadOnlyList(@org.jetbrains.annotations.NotNull java.util.List<? extends T> list) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(list.get(0)) : emptyList();
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> shuffled(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        java.util.List<T> mutableList = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(iterable);
        kotlin.collections.CollectionsKt___CollectionsKt.shuffle(mutableList, random);
        return mutableList;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    public static void throwCountOverflow() {
        throw new java.lang.ArithmeticException("Count overflow has happened.");
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    public static void throwIndexOverflow() {
        throw new java.lang.ArithmeticException("Index overflow has happened.");
    }
}
