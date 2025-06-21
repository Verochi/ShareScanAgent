package com.jd.ad.sdk.jad_te;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes23.dex */
public final class jad_re implements com.jd.ad.sdk.jad_ju.jad_ly<android.os.ParcelFileDescriptor, android.graphics.Bitmap> {
    public final com.jd.ad.sdk.jad_te.jad_jw jad_an;

    public jad_re(com.jd.ad.sdk.jad_te.jad_jw jad_jwVar) {
        this.jad_an = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull android.os.ParcelFileDescriptor parcelFileDescriptor, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        com.jd.ad.sdk.jad_te.jad_jw jad_jwVar2 = this.jad_an;
        return jad_jwVar2.jad_an(new com.jd.ad.sdk.jad_te.jad_ob.jad_cp(parcelFileDescriptor, jad_jwVar2.jad_dq, jad_jwVar2.jad_cp), i, i2, jad_jwVar, com.jd.ad.sdk.jad_te.jad_jw.jad_kx);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(@androidx.annotation.NonNull android.os.ParcelFileDescriptor parcelFileDescriptor, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.os.ParcelFileDescriptor parcelFileDescriptor2 = parcelFileDescriptor;
        java.lang.String str = android.os.Build.MANUFACTURER;
        if (!(!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor2.getStatSize() <= tv.danmaku.ijk.media.player.IjkMediaMeta.AV_CH_STEREO_LEFT)) {
            return false;
        }
        this.jad_an.getClass();
        return com.jd.ad.sdk.jad_kv.jad_mz.jad_cp();
    }
}
