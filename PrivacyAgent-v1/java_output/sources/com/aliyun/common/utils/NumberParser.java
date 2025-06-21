package com.aliyun.common.utils;

/* loaded from: classes.dex */
public class NumberParser {
    public static boolean parseToBoolean(java.lang.String str, boolean z) {
        try {
            return java.lang.Boolean.parseBoolean(str);
        } catch (java.lang.Exception unused) {
            return z;
        }
    }

    public static double parseToDouble(java.lang.String str, double d) {
        try {
            return java.lang.Double.parseDouble(str);
        } catch (java.lang.Exception unused) {
            return d;
        }
    }

    public static float parseToFloat(java.lang.String str, float f) {
        try {
            return java.lang.Float.parseFloat(str);
        } catch (java.lang.Exception unused) {
            return f;
        }
    }

    public static int parseToInt(java.lang.String str, int i) {
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static long parseToLong(java.lang.String str, long j) {
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.Exception unused) {
            return j;
        }
    }

    public static short parseToShort(java.lang.String str, short s2) {
        try {
            return java.lang.Short.parseShort(str);
        } catch (java.lang.Exception unused) {
            return s2;
        }
    }
}
