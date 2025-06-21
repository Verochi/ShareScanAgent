package com.jd.ad.sdk.fdt.utils;

/* loaded from: classes23.dex */
public class ConversionUtils {
    public static double floatToDouble(float f) {
        try {
            return java.lang.Double.valueOf(java.lang.String.valueOf(f)).doubleValue();
        } catch (java.lang.Exception unused) {
            return 0.0d;
        }
    }
}
