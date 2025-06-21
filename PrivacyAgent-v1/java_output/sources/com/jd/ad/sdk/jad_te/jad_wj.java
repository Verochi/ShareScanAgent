package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public final class jad_wj implements com.jd.ad.sdk.jad_ju.jad_ly<android.graphics.Bitmap, android.graphics.Bitmap> {

    public static final class jad_an implements com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> {
        public final android.graphics.Bitmap jad_an;

        public jad_an(@androidx.annotation.NonNull android.graphics.Bitmap bitmap) {
            this.jad_an = bitmap;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        @androidx.annotation.NonNull
        public android.graphics.Bitmap get() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public int jad_bo() {
            return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an);
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        @androidx.annotation.NonNull
        public java.lang.Class<android.graphics.Bitmap> jad_cp() {
            return android.graphics.Bitmap.class;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public void jad_dq() {
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.Bitmap> jad_an(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return new com.jd.ad.sdk.jad_te.jad_wj.jad_an(bitmap);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(@androidx.annotation.NonNull android.graphics.Bitmap bitmap, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
