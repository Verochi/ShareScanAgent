package com.jd.ad.sdk.jad_lw;

/* loaded from: classes23.dex */
public final class jad_bo {
    public static boolean jad_an(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean jad_an(android.net.Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
