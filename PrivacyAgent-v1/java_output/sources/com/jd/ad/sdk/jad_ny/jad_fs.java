package com.jd.ad.sdk.jad_ny;

/* loaded from: classes23.dex */
public class jad_fs implements com.jd.ad.sdk.jad_ny.jad_er {
    @Override // com.jd.ad.sdk.jad_ny.jad_er
    @androidx.annotation.NonNull
    public android.graphics.Bitmap jad_an(int i, int i2, android.graphics.Bitmap.Config config) {
        return android.graphics.Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an() {
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an(int i) {
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an(android.graphics.Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    @androidx.annotation.NonNull
    public android.graphics.Bitmap jad_bo(int i, int i2, android.graphics.Bitmap.Config config) {
        return android.graphics.Bitmap.createBitmap(i, i2, config);
    }
}
