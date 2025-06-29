package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
public class StringsKt__StringNumberConversionsKt extends kotlin.text.StringsKt__StringNumberConversionsJVMKt {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.Void numberFormatError(@org.jetbrains.annotations.NotNull java.lang.String input) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(input, "input");
        throw new java.lang.NumberFormatException("Invalid number format: '" + input + '\'');
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Byte toByteOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return toByteOrNull(str, 10);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Byte toByteOrNull(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        int intValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        java.lang.Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return java.lang.Byte.valueOf((byte) intValue);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static java.lang.Integer toIntOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return toIntOrNull(str, 10);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer toIntOrNull(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        boolean z;
        int i2;
        int i3;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        int i5 = -2147483647;
        if (kotlin.jvm.internal.Intrinsics.compare((int) charAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z = false;
            }
        } else {
            z = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int digitOf = kotlin.text.CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
            if (digitOf < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / i))) || (i3 = i4 * i) < i5 + digitOf) {
                return null;
            }
            i4 = i3 - digitOf;
            i2++;
        }
        return z ? java.lang.Integer.valueOf(i4) : java.lang.Integer.valueOf(-i4);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static java.lang.Long toLongOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return toLongOrNull(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Long toLongOrNull(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (kotlin.jvm.internal.Intrinsics.compare((int) charAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
                long j2 = -256204778801521550L;
                long j3 = 0;
                long j4 = -256204778801521550L;
                while (i2 < length) {
                    int digitOf = kotlin.text.CharsKt__CharJVMKt.digitOf(str.charAt(i2), i);
                    if (digitOf < 0) {
                        return null;
                    }
                    if (j3 < j4) {
                        if (j4 == j2) {
                            j4 = j / i;
                            if (j3 < j4) {
                            }
                        }
                        return null;
                    }
                    long j5 = j3 * i;
                    long j6 = digitOf;
                    if (j5 < j + j6) {
                        return null;
                    }
                    j3 = j5 - j6;
                    i2++;
                    j2 = -256204778801521550L;
                }
                return !z ? java.lang.Long.valueOf(j3) : java.lang.Long.valueOf(-j3);
            }
            if (charAt != '+') {
                return null;
            }
            i2 = 1;
        }
        z = false;
        long j22 = -256204778801521550L;
        long j32 = 0;
        long j42 = -256204778801521550L;
        while (i2 < length) {
        }
        if (!z) {
        }
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Short toShortOrNull(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return toShortOrNull(str, 10);
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Short toShortOrNull(@org.jetbrains.annotations.NotNull java.lang.String str, int i) {
        int intValue;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        java.lang.Integer intOrNull = toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return java.lang.Short.valueOf((short) intValue);
    }
}
