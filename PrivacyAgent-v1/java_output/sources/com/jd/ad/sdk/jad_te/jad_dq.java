package com.jd.ad.sdk.jad_te;

@androidx.annotation.RequiresApi(api = 28)
/* loaded from: classes23.dex */
public final class jad_dq implements com.jd.ad.sdk.jad_ju.jad_ly<android.graphics.ImageDecoder.Source, android.graphics.Bitmap> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an = new com.jd.ad.sdk.jad_ny.jad_fs();

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source source, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.graphics.Bitmap decodeBitmap;
        decodeBitmap = android.graphics.ImageDecoder.decodeBitmap(source, new com.jd.ad.sdk.jad_sd.jad_an(i, i2, jad_jwVar));
        if (android.util.Log.isLoggable("BitmapImageDecoder", 2)) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded [");
            jad_an.append(decodeBitmap.getWidth());
            jad_an.append("x");
            jad_an.append(decodeBitmap.getHeight());
            jad_an.append("] for [");
            jad_an.append(i);
            jad_an.append("x");
            jad_an.append(i2);
            jad_an.append("]");
            com.jd.ad.sdk.logger.Logger.v("BitmapImageDecoder", jad_an.toString());
        }
        return new com.jd.ad.sdk.jad_te.jad_er(decodeBitmap, this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source source, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
