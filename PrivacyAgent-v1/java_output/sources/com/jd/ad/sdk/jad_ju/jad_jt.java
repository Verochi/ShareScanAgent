package com.jd.ad.sdk.jad_ju;

/* loaded from: classes23.dex */
public final class jad_jt {
    public static int jad_an(@androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, @androidx.annotation.Nullable java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new com.jd.ad.sdk.jad_te.jad_sf(inputStream, jad_boVar, 65536);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int jad_an = list.get(i).jad_an(inputStream, jad_boVar);
                if (jad_an != -1) {
                    return jad_an;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    @androidx.annotation.NonNull
    public static com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(@androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, @androidx.annotation.Nullable java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an = list.get(i).jad_an(byteBuffer);
            if (jad_an != com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN) {
                return jad_an;
            }
        }
        return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
    }

    @androidx.annotation.NonNull
    public static com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_bo(@androidx.annotation.NonNull java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, @androidx.annotation.Nullable java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        if (inputStream == null) {
            return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new com.jd.ad.sdk.jad_te.jad_sf(inputStream, jad_boVar, 65536);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an = list.get(i).jad_an(inputStream);
                inputStream.reset();
                if (jad_an != com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN) {
                    return jad_an;
                }
            } catch (java.lang.Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
    }
}
