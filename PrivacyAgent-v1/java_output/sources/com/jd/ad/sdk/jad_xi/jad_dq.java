package com.jd.ad.sdk.jad_xi;

/* loaded from: classes23.dex */
public class jad_dq implements com.jd.ad.sdk.jad_ju.jad_mz<com.jd.ad.sdk.jad_xi.jad_cp> {
    @Override // com.jd.ad.sdk.jad_ju.jad_mz
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_cp jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_ju.jad_cp.SOURCE;
    }

    public boolean jad_an(@androidx.annotation.NonNull com.jd.ad.sdk.jad_mx.jad_xk jad_xkVar, @androidx.annotation.NonNull java.io.File file) {
        try {
            com.jd.ad.sdk.jad_ir.jad_an.jad_an(((com.jd.ad.sdk.jad_xi.jad_cp) jad_xkVar.get()).jad_an.jad_an.jad_an.jad_er().asReadOnlyBuffer(), file);
            return true;
        } catch (java.io.IOException e) {
            if (android.util.Log.isLoggable("GifEncoder", 5)) {
                com.jd.ad.sdk.logger.Logger.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull java.lang.Object obj, @androidx.annotation.NonNull java.io.File file, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_an((com.jd.ad.sdk.jad_mx.jad_xk) obj, file);
    }
}
