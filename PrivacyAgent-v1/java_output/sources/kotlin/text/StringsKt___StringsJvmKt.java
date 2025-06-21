package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0002*\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a=\u0010\n\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0006*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u000f\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020\fj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0005\u001a=\u0010\u0012\u001a\u0004\u0018\u00010\u0002\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u00028\u00000\u0006*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000b\u001a1\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00002\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00020\fj\n\u0012\u0006\b\u0000\u0012\u00020\u0002`\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"", "Ljava/util/SortedSet;", "", "toSortedSet", org.apache.tools.ant.types.selectors.DepthSelector.MAX_KEY, "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "", "R", "Lkotlin/Function1;", "selector", "maxBy", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "maxWith", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", org.apache.tools.ant.types.selectors.DepthSelector.MIN_KEY, "minBy", "minWith", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
class StringsKt___StringsJvmKt extends kotlin.text.StringsKt__StringsKt {
    @kotlin.Deprecated(message = "Use maxOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character max(java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return kotlin.text.StringsKt___StringsKt.maxOrNull(charSequence);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use maxByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Character maxBy(java.lang.CharSequence charSequence, kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return java.lang.Character.valueOf(charAt);
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(charAt));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(java.lang.Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) < 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    @kotlin.Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character maxWith(java.lang.CharSequence charSequence, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.text.StringsKt___StringsKt.maxWithOrNull(charSequence, comparator);
    }

    @kotlin.Deprecated(message = "Use minOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character min(java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return kotlin.text.StringsKt___StringsKt.minOrNull(charSequence);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @kotlin.Deprecated(message = "Use minByOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ <R extends java.lang.Comparable<? super R>> java.lang.Character minBy(java.lang.CharSequence charSequence, kotlin.jvm.functions.Function1<? super java.lang.Character, ? extends R> selector) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int lastIndex = kotlin.text.StringsKt__StringsKt.getLastIndex(charSequence);
        if (lastIndex == 0) {
            return java.lang.Character.valueOf(charAt);
        }
        R invoke = selector.invoke(java.lang.Character.valueOf(charAt));
        ?? it = new kotlin.ranges.IntRange(1, lastIndex).iterator();
        while (it.hasNext()) {
            char charAt2 = charSequence.charAt(it.nextInt());
            R invoke2 = selector.invoke(java.lang.Character.valueOf(charAt2));
            if (invoke.compareTo(invoke2) > 0) {
                charAt = charAt2;
                invoke = invoke2;
            }
        }
        return java.lang.Character.valueOf(charAt);
    }

    @kotlin.Deprecated(message = "Use minWithOrNull instead.", replaceWith = @kotlin.ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.DeprecatedSinceKotlin(errorSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5, hiddenSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6, warningSince = "1.4")
    public static final /* synthetic */ java.lang.Character minWith(java.lang.CharSequence charSequence, java.util.Comparator comparator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(comparator, "comparator");
        return kotlin.text.StringsKt___StringsKt.minWithOrNull(charSequence, comparator);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.SortedSet<java.lang.Character> toSortedSet(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (java.util.SortedSet) kotlin.text.StringsKt___StringsKt.toCollection(charSequence, new java.util.TreeSet());
    }
}
