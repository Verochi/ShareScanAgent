package com.jd.ad.sdk.jad_ir;

/* loaded from: classes23.dex */
public final class jad_ly {
    public static final char[] jad_an = "0123456789abcdef".toCharArray();
    public static final char[] jad_bo = new char[64];

    @androidx.annotation.Nullable
    public static volatile android.os.Handler jad_cp;

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            android.graphics.Bitmap.Config config;
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            jad_an = iArr;
            try {
                iArr[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_an[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                jad_an[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                int[] iArr2 = jad_an;
                config = android.graphics.Bitmap.Config.RGBA_F16;
                iArr2[config.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                jad_an[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    public static int jad_an(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static int jad_an(@androidx.annotation.Nullable android.graphics.Bitmap.Config config) {
        if (config == null) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        }
        int i = com.jd.ad.sdk.jad_ir.jad_ly.jad_an.jad_an[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    @android.annotation.TargetApi(19)
    public static int jad_an(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (java.lang.NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new java.lang.IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int jad_an(@androidx.annotation.Nullable java.lang.Object obj, int i) {
        return jad_an(obj == null ? 0 : obj.hashCode(), i);
    }

    @androidx.annotation.NonNull
    public static <T> java.util.List<T> jad_an(@androidx.annotation.NonNull java.util.Collection<T> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @androidx.annotation.NonNull
    public static <T> java.util.Queue<T> jad_an(int i) {
        return new java.util.ArrayDeque(i);
    }

    public static void jad_an() {
        if (!jad_dq()) {
            throw new java.lang.IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void jad_an(java.lang.Runnable runnable) {
        jad_bo().post(runnable);
    }

    public static boolean jad_an(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static android.os.Handler jad_bo() {
        if (jad_cp == null) {
            synchronized (com.jd.ad.sdk.jad_ir.jad_ly.class) {
                if (jad_cp == null) {
                    jad_cp = new android.os.Handler(android.os.Looper.getMainLooper());
                }
            }
        }
        return jad_cp;
    }

    public static boolean jad_bo(int i, int i2) {
        if (i > 0 || i == Integer.MIN_VALUE) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }
        return false;
    }

    public static boolean jad_cp() {
        return !jad_dq();
    }

    public static boolean jad_dq() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }
}
