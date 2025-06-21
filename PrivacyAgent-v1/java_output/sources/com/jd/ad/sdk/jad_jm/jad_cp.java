package com.jd.ad.sdk.jad_jm;

/* loaded from: classes23.dex */
public class jad_cp {
    public static final /* synthetic */ int jad_an = 0;

    public class jad_an extends java.lang.ThreadLocal<java.text.DecimalFormat> {
        @Override // java.lang.ThreadLocal
        public java.text.DecimalFormat initialValue() {
            try {
                java.text.DecimalFormat decimalFormat = (java.text.DecimalFormat) java.text.NumberFormat.getNumberInstance(java.util.Locale.ENGLISH);
                decimalFormat.applyPattern(com.baidu.mobads.sdk.internal.cl.d);
                return decimalFormat;
            } catch (java.lang.Exception unused) {
                return new java.text.DecimalFormat(com.baidu.mobads.sdk.internal.cl.d);
            }
        }
    }

    static {
        new com.jd.ad.sdk.jad_jm.jad_cp.jad_an();
    }

    public static void jad_an(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.io.IOException unused) {
            }
        }
    }
}
