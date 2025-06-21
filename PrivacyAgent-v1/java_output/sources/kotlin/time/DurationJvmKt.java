package kotlin.time;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\"\u001a\u0010\r\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\" \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"", "decimals", "Ljava/text/DecimalFormat;", "a", "", "value", "", "formatToExactDecimals", "formatUpToDecimals", "", "Z", "getDurationAssertionsEnabled", "()Z", "durationAssertionsEnabled", "", "Ljava/lang/ThreadLocal;", "b", "[Ljava/lang/ThreadLocal;", "precisionFormats", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DurationJvmKt {
    public static final boolean a = false;

    @org.jetbrains.annotations.NotNull
    public static final java.lang.ThreadLocal<java.text.DecimalFormat>[] b;

    static {
        java.lang.ThreadLocal<java.text.DecimalFormat>[] threadLocalArr = new java.lang.ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new java.lang.ThreadLocal<>();
        }
        b = threadLocalArr;
    }

    public static final java.text.DecimalFormat a(int i) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("0");
        if (i > 0) {
            decimalFormat.setMinimumFractionDigits(i);
        }
        decimalFormat.setRoundingMode(java.math.RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String formatToExactDecimals(double d, int i) {
        java.text.DecimalFormat a2;
        java.lang.ThreadLocal<java.text.DecimalFormat>[] threadLocalArr = b;
        if (i < threadLocalArr.length) {
            java.lang.ThreadLocal<java.text.DecimalFormat> threadLocal = threadLocalArr[i];
            java.text.DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = a(i);
                threadLocal.set(decimalFormat);
            } else {
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(decimalFormat, "get() ?: default().also(this::set)");
            }
            a2 = decimalFormat;
        } else {
            a2 = a(i);
        }
        java.lang.String format = a2.format(d);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(format, "format.format(value)");
        return format;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String formatUpToDecimals(double d, int i) {
        java.text.DecimalFormat a2 = a(0);
        a2.setMaximumFractionDigits(i);
        java.lang.String format = a2.format(d);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }

    public static final boolean getDurationAssertionsEnabled() {
        return a;
    }
}
