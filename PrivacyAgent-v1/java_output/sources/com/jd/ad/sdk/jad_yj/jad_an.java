package com.jd.ad.sdk.jad_yj;

/* loaded from: classes23.dex */
public class jad_an implements com.jd.ad.sdk.jad_yj.jad_er<android.graphics.Bitmap, byte[]> {
    public final android.graphics.Bitmap.CompressFormat jad_an;

    public jad_an() {
        this(android.graphics.Bitmap.CompressFormat.JPEG, 100);
    }

    public jad_an(@androidx.annotation.NonNull android.graphics.Bitmap.CompressFormat compressFormat, int i) {
        this.jad_an = compressFormat;
    }

    @Override // com.jd.ad.sdk.jad_yj.jad_er
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_mx.jad_xk<byte[]> jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_xkVar, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        jad_xkVar.get().compress(this.jad_an, 100, byteArrayOutputStream);
        jad_xkVar.jad_dq();
        return new com.jd.ad.sdk.jad_uf.jad_bo(byteArrayOutputStream.toByteArray());
    }
}
