package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u009e\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\bø\u0001\u0000\u001a·\u0001\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102b\u0010\u0006\u001a^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aI\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00150\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u0010H\u0007¢\u0006\u0002\u0010\u0016\u001a¿\u0001\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\bø\u0001\u0000\u001a\u007f\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aØ\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u001026\u0010\u0018\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00192K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u001aH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0093\u0001\u0010\u001d\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u001b\u001a\u0002H\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0019H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u008b\u0001\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0001\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\bø\u0001\u0000\u001a¤\u0001\u0010\"\u001a\u0002H\u0010\"\u0004\b\u0000\u0010!\"\b\b\u0001\u0010\u0004*\u0002H!\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H!0\u0011*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001a\u0002H\u00102K\u0010\u0006\u001aG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H!¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H!0\u001aH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"aggregate", "", "K", "R", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/GroupingKt")
/* loaded from: classes14.dex */
class GroupingKt__GroupingKt extends kotlin.collections.GroupingKt__GroupingJVMKt {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K, R> java.util.Map<K, R> aggregate(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super K, ? super R, ? super T, ? super java.lang.Boolean, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            java.lang.Object keyOf = grouping.keyOf(next);
            ShareEntity.MJShareMethod mJShareMethod = (java.lang.Object) linkedHashMap.get(keyOf);
            linkedHashMap.put(keyOf, operation.invoke(keyOf, mJShareMethod, next, java.lang.Boolean.valueOf(mJShareMethod == null && !linkedHashMap.containsKey(keyOf))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K, R, M extends java.util.Map<? super K, R>> M aggregateTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super K, ? super R, ? super T, ? super java.lang.Boolean, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            java.lang.Object keyOf = grouping.keyOf(next);
            ShareEntity.MJShareMethod mJShareMethod = (java.lang.Object) destination.get(keyOf);
            destination.put(keyOf, operation.invoke(keyOf, mJShareMethod, next, java.lang.Boolean.valueOf(mJShareMethod == null && !destination.containsKey(keyOf))));
        }
        return destination;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K, M extends java.util.Map<? super K, java.lang.Integer>> M eachCountTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull M destination) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            K keyOf = grouping.keyOf(sourceIterator.next());
            java.lang.Object obj = destination.get(keyOf);
            if (obj == null && !destination.containsKey(keyOf)) {
                obj = 0;
            }
            destination.put(keyOf, java.lang.Integer.valueOf(((java.lang.Number) obj).intValue() + 1));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K, R> java.util.Map<K, R> fold(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            K keyOf = grouping.keyOf(next);
            defpackage.a aVar = (java.lang.Object) linkedHashMap.get(keyOf);
            if (aVar == null && !linkedHashMap.containsKey(keyOf)) {
                aVar = (java.lang.Object) r;
            }
            linkedHashMap.put(keyOf, operation.mo5invoke(aVar, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K, R> java.util.Map<K, R> fold(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super T, ? extends R> initialValueSelector, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            java.lang.Object keyOf = grouping.keyOf(next);
            R r = (java.lang.Object) linkedHashMap.get(keyOf);
            if (r == null && !linkedHashMap.containsKey(keyOf)) {
                r = initialValueSelector.mo5invoke(keyOf, next);
            }
            linkedHashMap.put(keyOf, operation.invoke(keyOf, r, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K, R, M extends java.util.Map<? super K, R>> M foldTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull M destination, R r, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            K keyOf = grouping.keyOf(next);
            defpackage.a aVar = (java.lang.Object) destination.get(keyOf);
            if (aVar == null && !destination.containsKey(keyOf)) {
                aVar = (java.lang.Object) r;
            }
            destination.put(keyOf, operation.mo5invoke(aVar, next));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T, K, R, M extends java.util.Map<? super K, R>> M foldTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super K, ? super T, ? extends R> initialValueSelector, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            ?? next = sourceIterator.next();
            java.lang.Object keyOf = grouping.keyOf(next);
            R r = (java.lang.Object) destination.get(keyOf);
            if (r == null && !destination.containsKey(keyOf)) {
                r = initialValueSelector.mo5invoke(keyOf, next);
            }
            destination.put(keyOf, operation.invoke(keyOf, r, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <S, T extends S, K> java.util.Map<K, S> reduce(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
        java.util.Iterator sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            S s2 = (java.lang.Object) sourceIterator.next();
            java.lang.Object keyOf = grouping.keyOf(s2);
            ShareEntity.MJShareMethod mJShareMethod = (java.lang.Object) linkedHashMap.get(keyOf);
            if (!(mJShareMethod == null && !linkedHashMap.containsKey(keyOf))) {
                s2 = operation.invoke(keyOf, mJShareMethod, s2);
            }
            linkedHashMap.put(keyOf, s2);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <S, T extends S, K, M extends java.util.Map<? super K, S>> M reduceTo(@org.jetbrains.annotations.NotNull kotlin.collections.Grouping<T, ? extends K> grouping, @org.jetbrains.annotations.NotNull M destination, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(grouping, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(operation, "operation");
        java.util.Iterator sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            S s2 = (java.lang.Object) sourceIterator.next();
            java.lang.Object keyOf = grouping.keyOf(s2);
            ShareEntity.MJShareMethod mJShareMethod = (java.lang.Object) destination.get(keyOf);
            if (!(mJShareMethod == null && !destination.containsKey(keyOf))) {
                s2 = operation.invoke(keyOf, mJShareMethod, s2);
            }
            destination.put(keyOf, s2);
        }
        return destination;
    }
}
