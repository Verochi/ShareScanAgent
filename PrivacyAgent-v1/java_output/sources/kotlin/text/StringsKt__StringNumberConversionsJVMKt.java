package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0007\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0007\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u0000H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0007¨\u0006\u000f"}, d2 = {"", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "Ljava/math/BigInteger;", "toBigIntegerOrNull", "", "radix", "Ljava/math/BigDecimal;", "toBigDecimalOrNull", "Ljava/math/MathContext;", "mathContext", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
public class StringsKt__StringNumberConversionsJVMKt extends kotlin.text.StringsKt__StringBuilderKt {
    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.Nullable
    public static final java.math.BigDecimal toBigDecimalOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (kotlin.text.ScreenFloatValueRegEx.value.matches(str)) {
                return new java.math.BigDecimal(str);
            }
            return null;
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.Nullable
    public static final java.math.BigDecimal toBigDecimalOrNull(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.math.MathContext mathContext) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (kotlin.text.ScreenFloatValueRegEx.value.matches(str)) {
                return new java.math.BigDecimal(str, mathContext);
            }
            return null;
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.Nullable
    public static final java.math.BigInteger toBigIntegerOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return toBigIntegerOrNull(str, 10);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.Nullable
    public static final java.math.BigInteger toBigIntegerOrNull(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        int checkRadix;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i2 = str.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                if (kotlin.text.CharsKt__CharJVMKt.digitOf(str.charAt(i2), i) < 0) {
                    return null;
                }
            }
        } else if (kotlin.text.CharsKt__CharJVMKt.digitOf(str.charAt(0), i) < 0) {
            return null;
        }
        checkRadix = kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
        return new java.math.BigInteger(str, checkRadix);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Double toDoubleOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (kotlin.text.ScreenFloatValueRegEx.value.matches(str)) {
                return java.lang.Double.valueOf(java.lang.Double.parseDouble(str));
            }
            return null;
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static java.lang.Float toFloatOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (kotlin.text.ScreenFloatValueRegEx.value.matches(str)) {
                return java.lang.Float.valueOf(java.lang.Float.parseFloat(str));
            }
            return null;
        } catch (java.lang.NumberFormatException unused) {
            return null;
        }
    }
}
