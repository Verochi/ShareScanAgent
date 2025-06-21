package com.jd.ad.sdk.jad_sd;

@androidx.annotation.RequiresApi(api = 28)
/* loaded from: classes23.dex */
public final class jad_an implements android.graphics.ImageDecoder.OnHeaderDecodedListener {
    public final com.jd.ad.sdk.jad_te.jad_na jad_an = com.jd.ad.sdk.jad_te.jad_na.jad_an();
    public final int jad_bo;
    public final int jad_cp;
    public final com.jd.ad.sdk.jad_ju.jad_bo jad_dq;
    public final com.jd.ad.sdk.jad_te.jad_iv jad_er;
    public final boolean jad_fs;
    public final com.jd.ad.sdk.jad_ju.jad_kx jad_jt;

    /* renamed from: com.jd.ad.sdk.jad_sd.jad_an$jad_an, reason: collision with other inner class name */
    public class C0409jad_an implements android.graphics.ImageDecoder.OnPartialImageListener {
        public C0409jad_an(com.jd.ad.sdk.jad_sd.jad_an jad_anVar) {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(@androidx.annotation.NonNull android.graphics.ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public jad_an(int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        this.jad_bo = i;
        this.jad_cp = i2;
        this.jad_dq = (com.jd.ad.sdk.jad_ju.jad_bo) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_jw.jad_fs);
        this.jad_er = (com.jd.ad.sdk.jad_te.jad_iv) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_iv.jad_dq);
        com.jd.ad.sdk.jad_ju.jad_iv<java.lang.Boolean> jad_ivVar = com.jd.ad.sdk.jad_te.jad_jw.jad_iv;
        this.jad_fs = jad_jwVar.jad_an(jad_ivVar) != null && ((java.lang.Boolean) jad_jwVar.jad_an(jad_ivVar)).booleanValue();
        this.jad_jt = (com.jd.ad.sdk.jad_ju.jad_kx) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_jw.jad_jt);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(@androidx.annotation.NonNull android.graphics.ImageDecoder imageDecoder, @androidx.annotation.NonNull android.graphics.ImageDecoder.ImageInfo imageInfo, @androidx.annotation.NonNull android.graphics.ImageDecoder.Source source) {
        android.util.Size size;
        android.graphics.ColorSpace.Named named;
        android.graphics.ColorSpace colorSpace;
        android.graphics.ColorSpace colorSpace2;
        android.graphics.ColorSpace colorSpace3;
        android.graphics.ColorSpace colorSpace4;
        boolean isWideGamut;
        boolean z = false;
        if (this.jad_an.jad_an(this.jad_bo, this.jad_cp, this.jad_fs, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.jad_dq == com.jd.ad.sdk.jad_ju.jad_bo.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new com.jd.ad.sdk.jad_sd.jad_an.C0409jad_an(this));
        size = imageInfo.getSize();
        int i = this.jad_bo;
        if (i == Integer.MIN_VALUE) {
            i = size.getWidth();
        }
        int i2 = this.jad_cp;
        if (i2 == Integer.MIN_VALUE) {
            i2 = size.getHeight();
        }
        float jad_bo = this.jad_er.jad_bo(size.getWidth(), size.getHeight(), i, i2);
        int round = java.lang.Math.round(size.getWidth() * jad_bo);
        int round2 = java.lang.Math.round(size.getHeight() * jad_bo);
        if (android.util.Log.isLoggable("ImageDecoder", 2)) {
            java.lang.StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Resizing from [");
            jad_an.append(size.getWidth());
            jad_an.append("x");
            jad_an.append(size.getHeight());
            jad_an.append("] to [");
            jad_an.append(round);
            jad_an.append("x");
            jad_an.append(round2);
            jad_an.append("] scaleFactor: ");
            jad_an.append(jad_bo);
            com.jd.ad.sdk.logger.Logger.v("ImageDecoder", jad_an.toString());
        }
        imageDecoder.setTargetSize(round, round2);
        com.jd.ad.sdk.jad_ju.jad_kx jad_kxVar = this.jad_jt;
        if (jad_kxVar != null) {
            int i3 = android.os.Build.VERSION.SDK_INT;
            if (i3 < 28) {
                if (i3 >= 26) {
                    named = android.graphics.ColorSpace.Named.SRGB;
                    colorSpace = android.graphics.ColorSpace.get(named);
                    imageDecoder.setTargetColorSpace(colorSpace);
                    return;
                }
                return;
            }
            if (jad_kxVar == com.jd.ad.sdk.jad_ju.jad_kx.DISPLAY_P3) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        z = true;
                    }
                }
            }
            colorSpace2 = android.graphics.ColorSpace.get(z ? android.graphics.ColorSpace.Named.DISPLAY_P3 : android.graphics.ColorSpace.Named.SRGB);
            imageDecoder.setTargetColorSpace(colorSpace2);
        }
    }
}
