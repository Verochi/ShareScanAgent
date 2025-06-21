package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002\u001a,\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u001a\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000\u001a\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\bH\u0000\u001a%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\tH\u0000¢\u0006\u0004\b\u0007\u0010\n¨\u0006\u000b"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "", "a", "", com.tencent.open.SocialConstants.PARAM_SOURCE, "convertToSetForSetOperationWith", "convertToSetForSetOperation", "Lkotlin/sequences/Sequence;", "", "([Ljava/lang/Object;)Ljava/util/Collection;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class BrittleContainsOptimizationKt {
    public static final <T> boolean a(java.util.Collection<? extends T> collection) {
        return kotlin.collections.CollectionSystemProperties.brittleContainsOptimizationEnabled && collection.size() > 2 && (collection instanceof java.util.ArrayList);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Collection<T> convertToSetForSetOperation(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof java.util.Set) {
            return (java.util.Collection) iterable;
        }
        if (!(iterable instanceof java.util.Collection)) {
            return kotlin.collections.CollectionSystemProperties.brittleContainsOptimizationEnabled ? kotlin.collections.CollectionsKt___CollectionsKt.toHashSet(iterable) : kotlin.collections.CollectionsKt___CollectionsKt.toList(iterable);
        }
        java.util.Collection<T> collection = (java.util.Collection) iterable;
        return a(collection) ? kotlin.collections.CollectionsKt___CollectionsKt.toHashSet(iterable) : collection;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Collection<T> convertToSetForSetOperation(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence) {
        java.util.HashSet hashSet;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        if (!kotlin.collections.CollectionSystemProperties.brittleContainsOptimizationEnabled) {
            return kotlin.sequences.SequencesKt___SequencesKt.toList(sequence);
        }
        hashSet = kotlin.sequences.SequencesKt___SequencesKt.toHashSet(sequence);
        return hashSet;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Collection<T> convertToSetForSetOperation(@org.jetbrains.annotations.NotNull T[] tArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        return kotlin.collections.CollectionSystemProperties.brittleContainsOptimizationEnabled ? kotlin.collections.ArraysKt___ArraysKt.toHashSet(tArr) : kotlin.collections.ArraysKt___ArraysJvmKt.asList(tArr);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Collection<T> convertToSetForSetOperationWith(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable, @org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> source) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        if (iterable instanceof java.util.Set) {
            return (java.util.Collection) iterable;
        }
        if (!(iterable instanceof java.util.Collection)) {
            return kotlin.collections.CollectionSystemProperties.brittleContainsOptimizationEnabled ? kotlin.collections.CollectionsKt___CollectionsKt.toHashSet(iterable) : kotlin.collections.CollectionsKt___CollectionsKt.toList(iterable);
        }
        if ((source instanceof java.util.Collection) && ((java.util.Collection) source).size() < 2) {
            return (java.util.Collection) iterable;
        }
        java.util.Collection<T> collection = (java.util.Collection) iterable;
        return a(collection) ? kotlin.collections.CollectionsKt___CollectionsKt.toHashSet(iterable) : collection;
    }
}
