package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001aQ\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\t\u001aX\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\f2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u0002H\u00010\tH\u0007¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"getOrImplicitDefault", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes14.dex */
class MapsKt__MapWithDefaultKt {
    @kotlin.PublishedApi
    @kotlin.jvm.JvmName(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V getOrImplicitDefaultNullable(@org.jetbrains.annotations.NotNull java.util.Map<K, ? extends V> map, K k) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof kotlin.collections.MapWithDefault) {
            return (V) ((kotlin.collections.MapWithDefault) map).c(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new java.util.NoSuchElementException("Key " + k + " is missing in the map.");
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> withDefault(@org.jetbrains.annotations.NotNull java.util.Map<K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return map instanceof kotlin.collections.MapWithDefault ? withDefault(((kotlin.collections.MapWithDefault) map).getMap(), defaultValue) : new kotlin.collections.MapWithDefaultImpl(map, defaultValue);
    }

    @kotlin.jvm.JvmName(name = "withDefaultMutable")
    @org.jetbrains.annotations.NotNull
    public static final <K, V> java.util.Map<K, V> withDefaultMutable(@org.jetbrains.annotations.NotNull java.util.Map<K, V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return map instanceof kotlin.collections.MutableMapWithDefault ? withDefaultMutable(((kotlin.collections.MutableMapWithDefault) map).getMap(), defaultValue) : new kotlin.collections.MutableMapWithDefaultImpl(map, defaultValue);
    }
}
