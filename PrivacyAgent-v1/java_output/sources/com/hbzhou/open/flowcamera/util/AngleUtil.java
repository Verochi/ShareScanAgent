package com.hbzhou.open.flowcamera.util;

/* loaded from: classes22.dex */
public class AngleUtil {
    public static int getSensorAngle(float f, float f2) {
        if (java.lang.Math.abs(f) <= java.lang.Math.abs(f2)) {
            return (f2 <= 7.0f && f2 < -7.0f) ? 180 : 0;
        }
        if (f > 4.0f) {
            return 270;
        }
        return f < -4.0f ? 90 : 0;
    }
}
