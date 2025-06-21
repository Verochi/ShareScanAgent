package com.alimm.tanx.ui.image.glide.util;

/* loaded from: classes.dex */
public final class Util {
    private static final char[] HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] SHA_256_CHARS = new char[64];
    private static final char[] SHA_1_CHARS = new char[40];

    /* renamed from: com.alimm.tanx.ui.image.glide.util.Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[android.graphics.Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[android.graphics.Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
        }
    }

    private Util() {
    }

    public static void assertBackgroundThread() {
        if (!isOnBackgroundThread()) {
            throw new java.lang.IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new java.lang.IllegalArgumentException("You must call this method on the main thread");
        }
    }

    private static java.lang.String bytesToHex(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = HEX_CHAR_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new java.lang.String(cArr);
    }

    public static <T> java.util.Queue<T> createQueue(int i) {
        return new java.util.ArrayDeque(i);
    }

    public static int getBitmapByteSize(int i, int i2, android.graphics.Bitmap.Config config) {
        return i * i2 * getBytesPerPixel(config);
    }

    @android.annotation.TargetApi(19)
    public static int getBitmapByteSize(android.graphics.Bitmap bitmap) {
        try {
            return bitmap.getAllocationByteCount();
        } catch (java.lang.NullPointerException unused) {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }

    private static int getBytesPerPixel(android.graphics.Bitmap.Config config) {
        if (config == null) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        }
        int i = com.alimm.tanx.ui.image.glide.util.Util.AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? 2 : 4;
        }
        return 1;
    }

    @java.lang.Deprecated
    public static int getSize(android.graphics.Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    public static <T> java.util.List<T> getSnapshot(java.util.Collection<T> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        java.util.Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static boolean isOnBackgroundThread() {
        return !isOnMainThread();
    }

    public static boolean isOnMainThread() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }

    private static boolean isValidDimension(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean isValidDimensions(int i, int i2) {
        return isValidDimension(i) && isValidDimension(i2);
    }

    public static java.lang.String sha1BytesToHex(byte[] bArr) {
        java.lang.String bytesToHex;
        char[] cArr = SHA_1_CHARS;
        synchronized (cArr) {
            bytesToHex = bytesToHex(bArr, cArr);
        }
        return bytesToHex;
    }

    public static java.lang.String sha256BytesToHex(byte[] bArr) {
        java.lang.String bytesToHex;
        char[] cArr = SHA_256_CHARS;
        synchronized (cArr) {
            bytesToHex = bytesToHex(bArr, cArr);
        }
        return bytesToHex;
    }
}
