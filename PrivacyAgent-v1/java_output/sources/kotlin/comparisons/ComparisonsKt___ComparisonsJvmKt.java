package kotlin.comparisons;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0002\b\u0002\u001a/\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a7\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0007\u001a;\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\n\u001a\u001c\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\n\u0010\t\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u001c\u0010\u0004\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010\t\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00112\n\u0010\t\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\n\u0010\t\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u001c\u0010\u0004\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u0016\"\u00020\u0015H\u0007\u001a/\u0010\u0017\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0005\u001a7\u0010\u0017\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0007\u001a;\u0010\u0017\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b\"\u00028\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\n\u001a\u001c\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\n\u0010\t\u001a\u00020\f\"\u00020\u000bH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u000e\"\u00020\rH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010\t\u001a\u00020\u0010\"\u00020\u000fH\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00112\n\u0010\t\u001a\u00020\u0012\"\u00020\u0011H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00132\n\u0010\t\u001a\u00020\u0014\"\u00020\u0013H\u0007\u001a\u001c\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u0016\"\u00020\u0015H\u0007¨\u0006\u0018"}, d2 = {"", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "maxOf", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "other", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "", "", "", "", "", "", "", "", "", "", "", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes14.dex */
class ComparisonsKt___ComparisonsJvmKt extends kotlin.comparisons.ComparisonsKt__ComparisonsKt {
    @kotlin.SinceKotlin(version = "1.4")
    public static final byte maxOf(byte b, @org.jetbrains.annotations.NotNull byte... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (byte b2 : other) {
            b = (byte) java.lang.Math.max((int) b, (int) b2);
        }
        return b;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final double maxOf(double d, @org.jetbrains.annotations.NotNull double... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (double d2 : other) {
            d = java.lang.Math.max(d, d2);
        }
        return d;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final float maxOf(float f, @org.jetbrains.annotations.NotNull float... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (float f2 : other) {
            f = java.lang.Math.max(f, f2);
        }
        return f;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final int maxOf(int i, @org.jetbrains.annotations.NotNull int... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = java.lang.Math.max(i, i2);
        }
        return i;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final long maxOf(long j, @org.jetbrains.annotations.NotNull long... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = java.lang.Math.max(j, j2);
        }
        return j;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static <T extends java.lang.Comparable<? super T>> T maxOf(@org.jetbrains.annotations.NotNull T a, @org.jetbrains.annotations.NotNull T b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        return a.compareTo(b) >= 0 ? a : b;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T maxOf(@org.jetbrains.annotations.NotNull T a, @org.jetbrains.annotations.NotNull T b, @org.jetbrains.annotations.NotNull T c) {
        java.lang.Comparable maxOf;
        java.lang.Comparable maxOf2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        maxOf = maxOf(b, c);
        maxOf2 = maxOf(a, maxOf);
        return (T) maxOf2;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T maxOf(@org.jetbrains.annotations.NotNull T a, @org.jetbrains.annotations.NotNull T... other) {
        java.lang.Comparable maxOf;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (T t : other) {
            maxOf = maxOf(a, t);
            a = (T) maxOf;
        }
        return a;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final short maxOf(short s2, @org.jetbrains.annotations.NotNull short... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (short s3 : other) {
            s2 = (short) java.lang.Math.max((int) s2, (int) s3);
        }
        return s2;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final byte minOf(byte b, @org.jetbrains.annotations.NotNull byte... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (byte b2 : other) {
            b = (byte) java.lang.Math.min((int) b, (int) b2);
        }
        return b;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final double minOf(double d, @org.jetbrains.annotations.NotNull double... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (double d2 : other) {
            d = java.lang.Math.min(d, d2);
        }
        return d;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final float minOf(float f, @org.jetbrains.annotations.NotNull float... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (float f2 : other) {
            f = java.lang.Math.min(f, f2);
        }
        return f;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final int minOf(int i, @org.jetbrains.annotations.NotNull int... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (int i2 : other) {
            i = java.lang.Math.min(i, i2);
        }
        return i;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final long minOf(long j, @org.jetbrains.annotations.NotNull long... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (long j2 : other) {
            j = java.lang.Math.min(j, j2);
        }
        return j;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T minOf(@org.jetbrains.annotations.NotNull T a, @org.jetbrains.annotations.NotNull T b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        return a.compareTo(b) <= 0 ? a : b;
    }

    @kotlin.SinceKotlin(version = "1.1")
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T minOf(@org.jetbrains.annotations.NotNull T a, @org.jetbrains.annotations.NotNull T b, @org.jetbrains.annotations.NotNull T c) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(b, "b");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(c, "c");
        return (T) minOf(a, minOf(b, c));
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <T extends java.lang.Comparable<? super T>> T minOf(@org.jetbrains.annotations.NotNull T a, @org.jetbrains.annotations.NotNull T... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (T t : other) {
            a = (T) minOf(a, t);
        }
        return a;
    }

    @kotlin.SinceKotlin(version = "1.4")
    public static final short minOf(short s2, @org.jetbrains.annotations.NotNull short... other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        for (short s3 : other) {
            s2 = (short) java.lang.Math.min((int) s2, (int) s3);
        }
        return s2;
    }
}
