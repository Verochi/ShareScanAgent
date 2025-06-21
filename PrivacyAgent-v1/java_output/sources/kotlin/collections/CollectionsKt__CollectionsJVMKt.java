package kotlin.collections;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001\u001a\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\t\u001a\u00020\bH\u0001\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001\u001a\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\fH\u0007\u001a&\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007\u001a3\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0010\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\t\u0010\u0016\u001a\u00020\u0011H\u0080\b¨\u0006\u0017"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "element", "", "listOf", "(Ljava/lang/Object;)Ljava/util/List;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "", "createListBuilder", "", "capacity", "builder", "build", "", "shuffled", "Ljava/util/Random;", "random", "", "", "isVarargs", "", "copyToArrayOfAny", "([Ljava/lang/Object;Z)[Ljava/lang/Object;", "brittleContainsOptimizationEnabled", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes14.dex */
public class CollectionsKt__CollectionsJVMKt {
    public static final boolean brittleContainsOptimizationEnabled() {
        return kotlin.collections.CollectionSystemProperties.brittleContainsOptimizationEnabled;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static <E> java.util.List<E> build(@org.jetbrains.annotations.NotNull java.util.List<E> builder) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(builder, "builder");
        return ((kotlin.collections.builders.ListBuilder) builder).build();
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.lang.Object[] copyToArrayOfAny(@org.jetbrains.annotations.NotNull T[] tArr, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (z && kotlin.jvm.internal.Intrinsics.areEqual(tArr.getClass(), java.lang.Object[].class)) {
            return tArr;
        }
        java.lang.Object[] copyOf = java.util.Arrays.copyOf(tArr, tArr.length, java.lang.Object[].class);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static <E> java.util.List<E> createListBuilder() {
        return new kotlin.collections.builders.ListBuilder();
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static <E> java.util.List<E> createListBuilder(int i) {
        return new kotlin.collections.builders.ListBuilder(i);
    }

    @org.jetbrains.annotations.NotNull
    public static <T> java.util.List<T> listOf(T t) {
        java.util.List<T> singletonList = java.util.Collections.singletonList(t);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(element)");
        return singletonList;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> shuffled(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.List<T> mutableList = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(iterable);
        java.util.Collections.shuffle(mutableList);
        return mutableList;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> shuffled(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> iterable, @org.jetbrains.annotations.NotNull java.util.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        java.util.List<T> mutableList = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(iterable);
        java.util.Collections.shuffle(mutableList, random);
        return mutableList;
    }
}
