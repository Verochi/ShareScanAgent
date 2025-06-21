package com.jd.ad.sdk.jad_ju;

/* loaded from: classes23.dex */
public interface jad_fs {

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.values().length];
            jad_an = iArr;
            try {
                iArr[6] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                jad_an[5] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                jad_an[7] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    public enum jad_bo {
        GIF(true),
        JPEG(false),
        /* JADX INFO: Fake field, exist only in values array */
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        UNKNOWN(false);

        public final boolean jad_an;

        jad_bo(boolean z) {
            this.jad_an = z;
        }
    }

    int jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar);

    int jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar);

    @androidx.annotation.NonNull
    com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream);

    @androidx.annotation.NonNull
    com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer);
}
