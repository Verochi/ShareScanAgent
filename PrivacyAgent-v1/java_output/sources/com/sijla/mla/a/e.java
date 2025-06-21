package com.sijla.mla.a;

/* loaded from: classes19.dex */
public class e {
    public static final int[] a = {96, 113, 65, 84, 80, 80, 92, 108, 60, 16, 60, 84, 108, 124, 124, 124, 124, 124, 124, 96, 96, 96, 104, 34, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 228, 84, 84, 16, 98, 98, 4, 226, 20, 81, 80, 23};

    public static int a(int i) {
        return i & 63;
    }

    public static int b(int i) {
        return (i >> 6) & 255;
    }

    public static int c(int i) {
        return (i >> 6) & 67108863;
    }

    public static int d(int i) {
        return (i >> 23) & 511;
    }

    public static int e(int i) {
        return (i >> 14) & 511;
    }

    public static int f(int i) {
        return (i >> 14) & 262143;
    }

    public static int g(int i) {
        return ((i >> 14) & 262143) - 131071;
    }

    public static boolean h(int i) {
        return (i & 256) != 0;
    }

    public static int i(int i) {
        return i & (-257);
    }

    public static int j(int i) {
        return (a[i] >> 4) & 3;
    }

    public static int k(int i) {
        return (a[i] >> 2) & 3;
    }

    public static boolean l(int i) {
        return (a[i] & 64) != 0;
    }

    public static boolean m(int i) {
        return (a[i] & 128) != 0;
    }
}
