package com.xiaomi.push.service;

/* loaded from: classes19.dex */
final /* synthetic */ class af {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[com.xiaomi.push.gr.values().length];
        b = iArr;
        try {
            iArr[com.xiaomi.push.gr.INT.ordinal()] = 1;
        } catch (java.lang.NoSuchFieldError unused) {
        }
        try {
            b[com.xiaomi.push.gr.LONG.ordinal()] = 2;
        } catch (java.lang.NoSuchFieldError unused2) {
        }
        try {
            b[com.xiaomi.push.gr.STRING.ordinal()] = 3;
        } catch (java.lang.NoSuchFieldError unused3) {
        }
        try {
            b[com.xiaomi.push.gr.BOOLEAN.ordinal()] = 4;
        } catch (java.lang.NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[com.xiaomi.push.gq.values().length];
        a = iArr2;
        try {
            iArr2[com.xiaomi.push.gq.MISC_CONFIG.ordinal()] = 1;
        } catch (java.lang.NoSuchFieldError unused5) {
        }
        try {
            a[com.xiaomi.push.gq.PLUGIN_CONFIG.ordinal()] = 2;
        } catch (java.lang.NoSuchFieldError unused6) {
        }
    }
}
