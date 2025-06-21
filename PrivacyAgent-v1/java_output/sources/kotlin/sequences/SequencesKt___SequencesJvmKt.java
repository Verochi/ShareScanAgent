package kotlin.sequences;

@kotlin.Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u001aC\u0010\b\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\b\u0010\t\u001a&\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\n*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a8\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u000f\u001a\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0011*\b\u0012\u0004\u0012\u00020\u00110\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00140\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0015\u001a+\u0010\u0012\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\n*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0016\u001aI\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010\n*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a=\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u000fH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u0011*\b\u0012\u0004\u0012\u00020\u00110\u0001H\u0007¢\u0006\u0004\b\u001d\u0010\u0013\u001a\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00140\u0001H\u0007¢\u0006\u0004\b\u001d\u0010\u0015\u001a+\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\n*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u001d\u0010\u0016\u001aI\u0010\u001e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010\n*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001a\u001a=\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0010\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000ej\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u000fH\u0007¢\u0006\u0004\b\u001f\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"R", "Lkotlin/sequences/Sequence;", "Ljava/lang/Class;", "klass", "filterIsInstance", "", "C", "destination", "filterIsInstanceTo", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/SortedSet;", "toSortedSet", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "", org.apache.tools.ant.types.selectors.DepthSelector.MAX_KEY, "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "Lkotlin/Function1;", "selector", "maxBy", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY, "minBy", "minWith", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes14.dex */
class SequencesKt___SequencesJvmKt extends kotlin.sequences.SequencesKt__SequencesKt {
    @org.jetbrains.annotations.NotNull
    public static final <R> kotlin.sequences.Sequence<R> filterIsInstance(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<?> sequence, @org.jetbrains.annotations.NotNull java.lang.Class<R> klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        kotlin.sequences.Sequence<R> filter = kotlin.sequences.SequencesKt___SequencesKt.filter(sequence, new kotlin.sequences.SequencesKt___SequencesJvmKt$filterIsInstance$1(klass));
        kotlin.jvm.internal.Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return filter;
    }

    @org.jetbrains.annotations.NotNull
    public static final <C extends java.util.Collection<? super R>, R> C filterIsInstanceTo(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<?> sequence, @org.jetbrains.annotations.NotNull C destination, @org.jetbrains.annotations.NotNull java.lang.Class<R> klass) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(klass, "klass");
        for (java.lang.Object obj : sequence) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Comparable max(kotlin.sequences.Sequence sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return kotlin.sequences.SequencesKt___SequencesKt.maxOrNull(sequence);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    /* renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ java.lang.Double m609max(kotlin.sequences.Sequence sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return kotlin.sequences.SequencesKt___SequencesKt.m613maxOrNull((kotlin.sequences.Sequence<java.lang.Double>) sequence);
    }

    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    /* renamed from: max, reason: collision with other method in class */
    public static final /* synthetic */ java.lang.Float m610max(kotlin.sequences.Sequence sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return kotlin.sequences.SequencesKt___SequencesKt.m614maxOrNull((kotlin.sequences.Sequence<java.lang.Float>) sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends java.lang.Comparable<? super R>> T maxBy(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        java.util.Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R invoke = selector.invoke(next);
            do {
                T next2 = it.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it.hasNext());
        }
        return next;
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Object maxWith(kotlin.sequences.Sequence sequence, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.sequences.SequencesKt___SequencesKt.maxWithOrNull(sequence, comparator);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Comparable min(kotlin.sequences.Sequence sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return kotlin.sequences.SequencesKt___SequencesKt.minOrNull(sequence);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    /* renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ java.lang.Double m611min(kotlin.sequences.Sequence sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return kotlin.sequences.SequencesKt___SequencesKt.m617minOrNull((kotlin.sequences.Sequence<java.lang.Double>) sequence);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.SinceKotlin(version = "1.1")
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    /* renamed from: min, reason: collision with other method in class */
    public static final /* synthetic */ java.lang.Float m612min(kotlin.sequences.Sequence sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return kotlin.sequences.SequencesKt___SequencesKt.m618minOrNull((kotlin.sequences.Sequence<java.lang.Float>) sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <T, R extends java.lang.Comparable<? super R>> T minBy(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function1<? super T, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        java.util.Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        if (it.hasNext()) {
            R invoke = selector.invoke(next);
            do {
                T next2 = it.next();
                R invoke2 = selector.invoke(next2);
                next = next;
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                    next = next2;
                }
            } while (it.hasNext());
        }
        return next;
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Object minWith(kotlin.sequences.Sequence sequence, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.sequences.SequencesKt___SequencesKt.minWithOrNull(sequence, comparator);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> java.util.SortedSet<T> toSortedSet(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (java.util.SortedSet) kotlin.sequences.SequencesKt___SequencesKt.toCollection(sequence, new java.util.TreeSet());
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.SortedSet<T> toSortedSet(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (java.util.SortedSet) kotlin.sequences.SequencesKt___SequencesKt.toCollection(sequence, new java.util.TreeSet(comparator));
    }
}
