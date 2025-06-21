package com.esotericsoftware.spine.utils;

/* loaded from: classes22.dex */
public class SpineUtils {
    public static final float PI = 3.1415927f;
    public static final float PI2 = 6.2831855f;
    public static final float degRad = 0.017453292f;
    public static final float degreesToRadians = 0.017453292f;
    public static final float radDeg = 57.295776f;
    public static final float radiansToDegrees = 57.295776f;

    public static float atan2(float f, float f2) {
        return (float) java.lang.Math.atan2(f, f2);
    }

    public static float cos(float f) {
        return (float) java.lang.Math.cos(f);
    }

    public static float cosDeg(float f) {
        return (float) java.lang.Math.cos(f * 0.017453292f);
    }

    public static float sin(float f) {
        return (float) java.lang.Math.sin(f);
    }

    public static float sinDeg(float f) {
        return (float) java.lang.Math.sin(f * 0.017453292f);
    }
}
