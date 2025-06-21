package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\t\u001a\u00020\bH\u0001\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001\u001a-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aI\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0011j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u00122\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0014¨\u0006\u0015"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "element", "", "setOf", "(Ljava/lang/Object;)Ljava/util/Set;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", "createSetBuilder", "", "capacity", "builder", "build", "", "elements", "Ljava/util/TreeSet;", "sortedSetOf", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/SetsKt")
/* loaded from: classes14.dex */
public class SetsKt__SetsJVMKt {
    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static <E> java.util.Set<E> build(@org.jetbrains.annotations.NotNull java.util.Set<E> builder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
        return ((kotlin.collections.builders.SetBuilder) builder).build();
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final <E> java.util.Set<E> createSetBuilder() {
        return new kotlin.collections.builders.SetBuilder();
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static <E> java.util.Set<E> createSetBuilder(int i) {
        return new kotlin.collections.builders.SetBuilder(i);
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.Set<T> setOf(T t) {
        java.util.Set<T> singleton = java.util.Collections.singleton(t);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(singleton, "singleton(element)");
        return singleton;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.TreeSet<T> sortedSetOf(@org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator, @org.jetbrains.annotations.NotNull T... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return (java.util.TreeSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(elements, new java.util.TreeSet(comparator));
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.TreeSet<T> sortedSetOf(@org.jetbrains.annotations.NotNull T... elements) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        return (java.util.TreeSet) kotlin.collections.ArraysKt___ArraysKt.toCollection(elements, new java.util.TreeSet());
    }
}
