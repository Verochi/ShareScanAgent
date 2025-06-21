package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public final class k {
    private k() {
    }

    @android.annotation.TargetApi(19)
    public static int a(android.graphics.Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (java.lang.NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new java.lang.IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static <T> T a(T t) {
        t.getClass();
        return t;
    }

    public static void a(boolean z, java.lang.String str) {
        if (!z) {
            throw new java.lang.IllegalArgumentException(java.lang.String.valueOf(str));
        }
    }
}
