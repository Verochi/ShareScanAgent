package com.squareup.gifencoder;

/* loaded from: classes19.dex */
final class GifMath {
    public static boolean a(int i) {
        return java.lang.Integer.bitCount(i) == 1;
    }

    public static int b(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }
}
