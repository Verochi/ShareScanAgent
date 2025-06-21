package com.bumptech.glide.util;

/* loaded from: classes.dex */
public final class Util {
    private static final int HASH_ACCUMULATOR = 17;
    private static final int HASH_MULTIPLIER = 31;
    private static final char[] HEX_CHAR_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] SHA_256_CHARS = new char[64];

    /* renamed from: com.bumptech.glide.util.Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            android.graphics.Bitmap.Config config;
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
                int[] iArr2 = $SwitchMap$android$graphics$Bitmap$Config;
                config = android.graphics.Bitmap.Config.RGBA_F16;
                iArr2[config.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[android.graphics.Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
        }
    }

    private Util() {
    }

    public static void assertBackgroundThread() {
        if (!isOnBackgroundThread()) {
            throw new java.lang.IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void assertMainThread() {
        if (!isOnMainThread()) {
            throw new java.lang.IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean bothModelsNullEquivalentOrEquals(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        return obj == null ? obj2 == null : obj instanceof com.bumptech.glide.load.model.Model ? ((com.bumptech.glide.load.model.Model) obj).isEquivalentTo(obj2) : obj.equals(obj2);
    }

    public static boolean bothNullOrEqual(@androidx.annotation.Nullable java.lang.Object obj, @androidx.annotation.Nullable java.lang.Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @androidx.annotation.NonNull
    private static java.lang.String bytesToHex(@androidx.annotation.NonNull byte[] bArr, @androidx.annotation.NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = HEX_CHAR_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new java.lang.String(cArr);
    }

    @androidx.annotation.NonNull
    public static <T> java.util.Queue<T> createQueue(int i) {
        return new java.util.ArrayDeque(i);
    }

    public static int getBitmapByteSize(int i, int i2, @androidx.annotation.Nullable android.graphics.Bitmap.Config config) {
        return i * i2 * getBytesPerPixel(config);
    }

    @android.annotation.TargetApi(19)
    public static int getBitmapByteSize(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (java.lang.NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new java.lang.IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int getBytesPerPixel(@androidx.annotation.Nullable android.graphics.Bitmap.Config config) {
        if (config == null) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        }
        int i = com.bumptech.glide.util.Util.AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    @java.lang.Deprecated
    public static int getSize(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    @androidx.annotation.NonNull
    public static <T> java.util.List<T> getSnapshot(@androidx.annotation.NonNull java.util.Collection<T> collection) {
        java.util.ArrayList arrayList = new java.util.ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static int hashCode(float f) {
        return hashCode(f, 17);
    }

    public static int hashCode(float f, int i) {
        return hashCode(java.lang.Float.floatToIntBits(f), i);
    }

    public static int hashCode(int i) {
        return hashCode(i, 17);
    }

    public static int hashCode(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static int hashCode(@androidx.annotation.Nullable java.lang.Object obj, int i) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int hashCode(boolean z) {
        return hashCode(z, 17);
    }

    public static int hashCode(boolean z, int i) {
        return hashCode(z ? 1 : 0, i);
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

    @androidx.annotation.NonNull
    public static java.lang.String sha256BytesToHex(@androidx.annotation.NonNull byte[] bArr) {
        java.lang.String bytesToHex;
        char[] cArr = SHA_256_CHARS;
        synchronized (cArr) {
            bytesToHex = bytesToHex(bArr, cArr);
        }
        return bytesToHex;
    }
}
