package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class Hashing {
    public static int a(int i, double d) {
        int max = java.lang.Math.max(i, 2);
        int highestOneBit = java.lang.Integer.highestOneBit(max);
        if (max <= ((int) (d * highestOneBit))) {
            return highestOneBit;
        }
        int i2 = highestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    public static boolean b(int i, int i2, double d) {
        return ((double) i) > d * ((double) i2) && i2 < 1073741824;
    }

    public static int c(int i) {
        return (int) (java.lang.Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int d(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
