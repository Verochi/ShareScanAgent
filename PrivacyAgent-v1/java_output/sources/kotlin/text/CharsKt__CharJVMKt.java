package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\"\u0015\u0010\u0011\u001a\u00020\u000e*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0015\u001a\u00020\u0012*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"", "", "isWhitespace", "Ljava/util/Locale;", "locale", "", "uppercase", "lowercase", "titlecase", "char", "", "radix", "digitOf", "checkRadix", "Lkotlin/text/CharCategory;", "getCategory", "(C)Lkotlin/text/CharCategory;", "category", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "directionality", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/CharsKt")
/* loaded from: classes14.dex */
public class CharsKt__CharJVMKt {
    @kotlin.PublishedApi
    public static int checkRadix(int i) {
        if (new kotlin.ranges.IntRange(2, 36).contains(i)) {
            return i;
        }
        throw new java.lang.IllegalArgumentException("radix " + i + " was not in valid range " + new kotlin.ranges.IntRange(2, 36));
    }

    public static final int digitOf(char c, int i) {
        return java.lang.Character.digit((int) c, i);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.text.CharCategory getCategory(char c) {
        return kotlin.text.CharCategory.INSTANCE.valueOf(java.lang.Character.getType(c));
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.text.CharDirectionality getDirectionality(char c) {
        return kotlin.text.CharDirectionality.INSTANCE.valueOf(java.lang.Character.getDirectionality(c));
    }

    public static final boolean isWhitespace(char c) {
        return java.lang.Character.isWhitespace(c) || java.lang.Character.isSpaceChar(c);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String lowercase(char c, @org.jetbrains.annotations.NotNull java.util.Locale locale) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(locale, "locale");
        java.lang.String valueOf = java.lang.String.valueOf(c);
        kotlin.jvm.internal.Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        java.lang.String lowerCase = valueOf.toLowerCase(locale);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String titlecase(char c, @org.jetbrains.annotations.NotNull java.util.Locale locale) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(locale, "locale");
        java.lang.String uppercase = uppercase(c, locale);
        if (uppercase.length() <= 1) {
            java.lang.String valueOf = java.lang.String.valueOf(c);
            kotlin.jvm.internal.Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            java.lang.String upperCase = valueOf.toUpperCase(java.util.Locale.ROOT);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return !kotlin.jvm.internal.Intrinsics.areEqual(uppercase, upperCase) ? uppercase : java.lang.String.valueOf(java.lang.Character.toTitleCase(c));
        }
        if (c == 329) {
            return uppercase;
        }
        char charAt = uppercase.charAt(0);
        kotlin.jvm.internal.Intrinsics.checkNotNull(uppercase, "null cannot be cast to non-null type java.lang.String");
        java.lang.String substring = uppercase.substring(1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        java.lang.String lowerCase = substring.toLowerCase(java.util.Locale.ROOT);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return charAt + lowerCase;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String uppercase(char c, @org.jetbrains.annotations.NotNull java.util.Locale locale) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(locale, "locale");
        java.lang.String valueOf = java.lang.String.valueOf(c);
        kotlin.jvm.internal.Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        java.lang.String upperCase = valueOf.toUpperCase(locale);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }
}
