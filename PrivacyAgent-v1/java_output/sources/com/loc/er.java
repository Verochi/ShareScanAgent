package com.loc;

/* loaded from: classes23.dex */
public final class er {
    public static double a(double d, double d2, double d3, double d4) {
        double d5 = (((90.0d - d2) * 21412.0d) / 90.0d) + 6356725.0d;
        double cos = ((d3 * 0.01745329238474369d) - (d * 0.01745329238474369d)) * java.lang.Math.cos((3.1415927410125732d * d2) / 180.0d) * d5;
        double d6 = ((d4 * 0.01745329238474369d) - (d2 * 0.01745329238474369d)) * d5;
        return java.lang.Math.pow((cos * cos) + (d6 * d6), 0.5d);
    }
}
