package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000^\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a6\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u001a\\\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0006*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022$\u0010\n\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007H\u0086\bø\u0001\u0000\u001ac\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0006*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022$\u0010\n\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\f0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aw\u0010\u0012\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0006\"\u0010\b\u0003\u0010\u0010*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u000f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0011\u001a\u00028\u00032$\u0010\n\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aw\u0010\u0012\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0006\"\u0010\b\u0003\u0010\u0010*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u000f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0011\u001a\u00028\u00032$\u0010\n\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\f0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013\u001aV\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0006*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0086\bø\u0001\u0000\u001a\\\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0006*\u00020\u0016*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022 \u0010\n\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0007H\u0086\bø\u0001\u0000\u001aw\u0010\u0018\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\b\b\u0002\u0010\u0006*\u00020\u0016\"\u0010\b\u0003\u0010\u0010*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u000f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0011\u001a\u00028\u00032 \u0010\n\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00018\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0013\u001aq\u0010\u0019\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0006\"\u0010\b\u0003\u0010\u0010*\n\u0012\u0006\b\u0000\u0012\u00028\u00020\u000f*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0011\u001a\u00028\u00032\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00028\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0013\u001aJ\u0010\u001c\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\u001a0\u0007H\u0086\bø\u0001\u0000\u001a$\u0010\u001d\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u001aJ\u0010\u001d\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\u001a0\u0007H\u0086\bø\u0001\u0000\u001aJ\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\u001a0\u0007H\u0086\bø\u0001\u0000\u001aJ\u0010\"\u001a\u00020 \"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010!\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020 0\u0007H\u0087\bø\u0001\u0000\u001a$\u0010#\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u001aJ\u0010#\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u001e\u0010\u001b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\u001a0\u0007H\u0086\bø\u0001\u0000\u001a[\u0010%\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010$*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002*\u00028\u00022\u001e\u0010!\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020 0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ap\u0010+\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0016\b\u0002\u0010$*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002*\u00028\u000223\u0010!\u001a/\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020 0'H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a6\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, d2 = {"K", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "Lkotlin/Pair;", "toList", "R", "Lkotlin/Function1;", "", "", "transform", "flatMap", "Lkotlin/sequences/Sequence;", "flatMapSequence", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "", "C", "destination", "flatMapTo", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "map", "", "mapNotNull", "mapNotNullTo", "mapTo", "", "predicate", "all", org.apache.commons.codec.language.bm.Languages.ANY, "", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "", "action", "forEach", "none", "M", "onEach", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "onEachIndexed", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "asSequence", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/MapsKt")
/* loaded from: classes14.dex */
class MapsKt___MapsKt extends kotlin.collections.MapsKt___MapsJvmKt {
    public static final <K, V> boolean all(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean any(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean any(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V> kotlin.sequences.Sequence<java.util.Map.Entry<K, V>> asSequence(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        return kotlin.collections.CollectionsKt___CollectionsKt.asSequence(map.entrySet());
    }

    public static final <K, V> int count(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        if (map.isEmpty()) {
            return 0;
        }
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, R> java.util.List<R> flatMap(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends java.lang.Iterable<? extends R>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.jvm.JvmName(name = "flatMapSequence")
    @org.jetbrains.annotations.NotNull
    @kotlin.OverloadResolutionByLambdaReturnType
    public static final <K, V, R> java.util.List<R> flatMapSequence(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.Sequence<? extends R>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(it.next()));
        }
        return arrayList;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.jvm.JvmName(name = "flatMapSequenceTo")
    @org.jetbrains.annotations.NotNull
    @kotlin.OverloadResolutionByLambdaReturnType
    public static final <K, V, R, C extends java.util.Collection<? super R>> C flatMapSequenceTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends kotlin.sequences.Sequence<? extends R>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, R, C extends java.util.Collection<? super R>> C flatMapTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends java.lang.Iterable<? extends R>> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(it.next()));
        }
        return destination;
    }

    @kotlin.internal.HidesMembers
    public static final <K, V> void forEach(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, R> java.util.List<R> map(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(transform.invoke(it.next()));
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, R> java.util.List<R> mapNotNull(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, R, C extends java.util.Collection<? super R>> C mapNotNullTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R invoke = transform.invoke(it.next());
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    @org.jetbrains.annotations.NotNull
    public static final <K, V, R, C extends java.util.Collection<? super R>> C mapTo(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            destination.add(transform.invoke(it.next()));
        }
        return destination;
    }

    public static final <K, V> boolean none(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean none(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, java.lang.Boolean> predicate) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (predicate.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? extends K, ? extends V>> M onEach(@org.jetbrains.annotations.NotNull M m, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(m, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Iterator<java.util.Map.Entry<K, V>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        return m;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <K, V, M extends java.util.Map<? extends K, ? extends V>> M onEachIndexed(@org.jetbrains.annotations.NotNull M m, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.util.Map.Entry<? extends K, ? extends V>, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(m, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(action, "action");
        java.util.Iterator<T> it = m.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            defpackage.a aVar = (java.lang.Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            action.mo5invoke(java.lang.Integer.valueOf(i), aVar);
            i = i2;
        }
        return m;
    }

    @org.jetbrains.annotations.NotNull
    public static <K, V> java.util.List<kotlin.Pair<K, V>> toList(@org.jetbrains.annotations.NotNull java.util.Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.size() == 0) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        java.util.Iterator<java.util.Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        java.util.Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(new kotlin.Pair(next.getKey(), next.getValue()));
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(map.size());
        arrayList.add(new kotlin.Pair(next.getKey(), next.getValue()));
        do {
            java.util.Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new kotlin.Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
