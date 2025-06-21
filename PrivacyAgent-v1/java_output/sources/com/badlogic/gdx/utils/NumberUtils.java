package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public final class NumberUtils {
    public static long doubleToLongBits(double d) {
        return java.lang.Double.doubleToLongBits(d);
    }

    public static int floatToIntBits(float f) {
        return java.lang.Float.floatToIntBits(f);
    }

    public static int floatToIntColor(float f) {
        return java.lang.Float.floatToRawIntBits(f);
    }

    public static int floatToRawIntBits(float f) {
        return java.lang.Float.floatToRawIntBits(f);
    }

    public static float intBitsToFloat(int i) {
        return java.lang.Float.intBitsToFloat(i);
    }

    public static float intToFloatColor(int i) {
        return java.lang.Float.intBitsToFloat(i & (-16777217));
    }

    public static double longBitsToDouble(long j) {
        return java.lang.Double.longBitsToDouble(j);
    }
}
