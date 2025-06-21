package kotlin.comparisons;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a[\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002 \u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003H\u0002¢\u0006\u0004\b\u0001\u0010\t\u001a/\u0010\n\u001a\u00020\u0007\"\f\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a[\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004¢\u0006\u0004\b\u000e\u0010\u000f\u001aO\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\rH\u0086\u0004\u001aO\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r2\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\rH\u0086\u0004\u001a@\u0010\u0014\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\r\"\b\b\u0000\u0010\u0000*\u00020\u00132\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\r\u001a@\u0010\u0015\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\r\"\b\b\u0000\u0010\u0000*\u00020\u00132\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\r\u001a&\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u001a&\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005\u001a0\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\fj\b\u0012\u0004\u0012\u00028\u0000`\r¨\u0006\u0019"}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "", "Lkotlin/Function1;", "", "selectors", "", "compareValuesBy", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "compareBy", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "comparator", "then", "thenDescending", "", "nullsFirst", "nullsLast", "naturalOrder", "reverseOrder", "reversed", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes14.dex */
public class ComparisonsKt__ComparisonsKt {
    public static final <T> int a(T t, T t2, kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>>[] function1Arr) {
        int compareValues;
        for (kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>> function1 : function1Arr) {
            compareValues = compareValues(function1.invoke(t), function1.invoke(t2));
            if (compareValues != 0) {
                return compareValues;
            }
        }
        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Comparator<T> compareBy(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>>... selectors) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            return new kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$1(selectors);
        }
        throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
    }

    public static <T extends java.lang.Comparable<?>> int compareValues(@org.jetbrains.annotations.Nullable T t, @org.jetbrains.annotations.Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static final <T> int compareValuesBy(T t, T t2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Comparable<?>>... selectors) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selectors, "selectors");
        if (selectors.length > 0) {
            return a(t, t2, selectors);
        }
        throw new java.lang.IllegalArgumentException("Failed requirement.".toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> naturalOrder() {
        kotlin.comparisons.NaturalOrderComparator naturalOrderComparator = kotlin.comparisons.NaturalOrderComparator.n;
        kotlin.jvm.internal.Intrinsics.checkNotNull(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return naturalOrderComparator;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Comparator<T> nullsFirst(@org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new kotlin.comparisons.ComparisonsKt__ComparisonsKt$nullsFirst$1(comparator);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Comparator<T> nullsLast(@org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return new kotlin.comparisons.ComparisonsKt__ComparisonsKt$nullsLast$1(comparator);
    }

    @org.jetbrains.annotations.NotNull
    public static <T extends java.lang.Comparable<? super T>> java.util.Comparator<T> reverseOrder() {
        kotlin.comparisons.ReverseOrderComparator reverseOrderComparator = kotlin.comparisons.ReverseOrderComparator.n;
        kotlin.jvm.internal.Intrinsics.checkNotNull(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return reverseOrderComparator;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Comparator<T> reversed(@org.jetbrains.annotations.NotNull java.util.Comparator<T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "<this>");
        if (comparator instanceof kotlin.comparisons.ReversedComparator) {
            return ((kotlin.comparisons.ReversedComparator) comparator).a();
        }
        java.util.Comparator<T> comparator2 = kotlin.comparisons.NaturalOrderComparator.n;
        if (kotlin.jvm.internal.Intrinsics.areEqual(comparator, comparator2)) {
            kotlin.comparisons.ReverseOrderComparator reverseOrderComparator = kotlin.comparisons.ReverseOrderComparator.n;
            kotlin.jvm.internal.Intrinsics.checkNotNull(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
            return reverseOrderComparator;
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(comparator, kotlin.comparisons.ReverseOrderComparator.n)) {
            kotlin.jvm.internal.Intrinsics.checkNotNull(comparator2, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        } else {
            comparator2 = new kotlin.comparisons.ReversedComparator<>(comparator);
        }
        return comparator2;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Comparator<T> then(@org.jetbrains.annotations.NotNull java.util.Comparator<T> comparator, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new kotlin.comparisons.ComparisonsKt__ComparisonsKt$then$1(comparator, comparator2);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Comparator<T> thenDescending(@org.jetbrains.annotations.NotNull java.util.Comparator<T> comparator, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator2, "comparator");
        return new kotlin.comparisons.ComparisonsKt__ComparisonsKt$thenDescending$1(comparator, comparator2);
    }
}
