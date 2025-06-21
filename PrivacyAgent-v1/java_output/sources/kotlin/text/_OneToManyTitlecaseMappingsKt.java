package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", "", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class _OneToManyTitlecaseMappingsKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String titlecaseImpl(char c) {
        java.lang.String valueOf = java.lang.String.valueOf(c);
        kotlin.jvm.internal.Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        java.util.Locale locale = java.util.Locale.ROOT;
        java.lang.String upperCase = valueOf.toUpperCase(locale);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() <= 1) {
            return java.lang.String.valueOf(java.lang.Character.toTitleCase(c));
        }
        if (c == 329) {
            return upperCase;
        }
        char charAt = upperCase.charAt(0);
        kotlin.jvm.internal.Intrinsics.checkNotNull(upperCase, "null cannot be cast to non-null type java.lang.String");
        java.lang.String substring = upperCase.substring(1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        java.lang.String lowerCase = substring.toLowerCase(locale);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return charAt + lowerCase;
    }
}
