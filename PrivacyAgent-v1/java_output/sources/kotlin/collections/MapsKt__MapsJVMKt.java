package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000D\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\u001a2\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u001a \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0001\u001a(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\t\u001a\u00020\bH\u0001\u001a4\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0001\u001aE\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\r\u001a\u00028\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a:\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u001a@\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015\u001a[\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0001\u0010\u00012*\u0010\u0018\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0017\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001ac\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00152*\u0010\u0018\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0017\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b\u0019\u0010\u001b\u001a2\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0000\u001a\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "pair", "", "mapOf", "", "createMapBuilder", "", "capacity", "builder", "build", "Ljava/util/concurrent/ConcurrentMap;", "key", "Lkotlin/Function0;", "defaultValue", "getOrPut", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Ljava/util/SortedMap;", "toSortedMap", "Ljava/util/Comparator;", "comparator", "", "pairs", "sortedMapOf", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "toSingletonMap", "expectedSize", "mapCapacity", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/MapsKt")
/* loaded from: classes14.dex */
public class MapsKt__MapsJVMKt extends kotlin.collections.MapsKt__MapWithDefaultKt {
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.Map<K, V> build(@org.jetbrains.annotations.NotNull java.util.Map<K, V> builder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
        return ((kotlin.collections.builders.MapBuilder) builder).build();
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> createMapBuilder() {
        return new kotlin.collections.builders.MapBuilder();
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.Map<K, V> createMapBuilder(int i) {
        return new kotlin.collections.builders.MapBuilder(i);
    }

    public static final <K, V> V getOrPut(@org.jetbrains.annotations.NotNull java.util.concurrent.ConcurrentMap<K, V> concurrentMap, K k, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends V> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(concurrentMap, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V invoke = defaultValue.invoke();
        V putIfAbsent = concurrentMap.putIfAbsent(k, invoke);
        return putIfAbsent == null ? invoke : putIfAbsent;
    }

    @kotlin.PublishedApi
    public static int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.Map<K, V> mapOf(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pair, "pair");
        java.util.Map<K, V> singletonMap = java.util.Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.SortedMap<K, V> sortedMapOf(@org.jetbrains.annotations.NotNull java.util.Comparator<? super K> comparator, @org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        java.util.TreeMap treeMap = new java.util.TreeMap(comparator);
        kotlin.collections.MapsKt__MapsKt.putAll(treeMap, pairs);
        return treeMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K extends java.lang.Comparable<? super K>, V> java.util.SortedMap<K, V> sortedMapOf(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(pairs, "pairs");
        java.util.TreeMap treeMap = new java.util.TreeMap();
        kotlin.collections.MapsKt__MapsKt.putAll(treeMap, pairs);
        return treeMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> toSingletonMap(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        java.util.Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        java.util.Map<K, V> singletonMap = java.util.Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K extends java.lang.Comparable<? super K>, V> java.util.SortedMap<K, V> toSortedMap(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        return new java.util.TreeMap(map);
    }

    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.SortedMap<K, V> toSortedMap(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull java.util.Comparator<? super K> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        java.util.TreeMap treeMap = new java.util.TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
