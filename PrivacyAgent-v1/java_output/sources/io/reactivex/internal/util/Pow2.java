package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class Pow2 {
    public Pow2() {
        throw new java.lang.IllegalStateException("No instances!");
    }

    public static boolean isPowerOfTwo(int i) {
        return (i & (i + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i) {
        return 1 << (32 - java.lang.Integer.numberOfLeadingZeros(i - 1));
    }
}
