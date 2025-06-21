package com.jd.ad.sdk.jad_vg;

@androidx.annotation.RequiresApi(28)
/* loaded from: classes23.dex */
public final class jad_an {
    public final java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_bo;

    /* renamed from: com.jd.ad.sdk.jad_vg.jad_an$jad_an, reason: collision with other inner class name */
    public static final class C0413jad_an implements com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> {
        public final android.graphics.drawable.AnimatedImageDrawable jad_an;

        public C0413jad_an(android.graphics.drawable.AnimatedImageDrawable animatedImageDrawable) {
            this.jad_an = animatedImageDrawable;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        @androidx.annotation.NonNull
        public android.graphics.drawable.Drawable get() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public int jad_bo() {
            int intrinsicWidth;
            int intrinsicHeight;
            intrinsicWidth = this.jad_an.getIntrinsicWidth();
            intrinsicHeight = this.jad_an.getIntrinsicHeight();
            return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(android.graphics.Bitmap.Config.ARGB_8888) * intrinsicHeight * intrinsicWidth * 2;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        @androidx.annotation.NonNull
        public java.lang.Class<android.graphics.drawable.Drawable> jad_cp() {
            return android.graphics.drawable.Drawable.class;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public void jad_dq() {
            this.jad_an.stop();
            this.jad_an.clearAnimationCallbacks();
        }
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, android.graphics.drawable.Drawable> {
        public final com.jd.ad.sdk.jad_vg.jad_an jad_an;

        public jad_bo(com.jd.ad.sdk.jad_vg.jad_an jad_anVar) {
            this.jad_an = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_ju.jad_ly
        public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
            android.graphics.ImageDecoder.Source createSource;
            createSource = android.graphics.ImageDecoder.createSource(byteBuffer);
            return this.jad_an.jad_an(createSource, i, i2, jad_jwVar);
        }

        @Override // com.jd.ad.sdk.jad_ju.jad_ly
        public boolean jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
            return this.jad_an.jad_an(byteBuffer);
        }
    }

    public static final class jad_cp implements com.jd.ad.sdk.jad_ju.jad_ly<java.io.InputStream, android.graphics.drawable.Drawable> {
        public final com.jd.ad.sdk.jad_vg.jad_an jad_an;

        public jad_cp(com.jd.ad.sdk.jad_vg.jad_an jad_anVar) {
            this.jad_an = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_ju.jad_ly
        public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
            android.graphics.ImageDecoder.Source createSource;
            createSource = android.graphics.ImageDecoder.createSource(com.jd.ad.sdk.jad_ir.jad_an.jad_an(inputStream));
            return this.jad_an.jad_an(createSource, i, i2, jad_jwVar);
        }

        @Override // com.jd.ad.sdk.jad_ju.jad_ly
        public boolean jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
            return this.jad_an.jad_an(inputStream);
        }
    }

    public jad_an(java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = list;
        this.jad_bo = jad_boVar;
    }

    public static com.jd.ad.sdk.jad_ju.jad_ly<java.nio.ByteBuffer, android.graphics.drawable.Drawable> jad_an(java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        return new com.jd.ad.sdk.jad_vg.jad_an.jad_bo(new com.jd.ad.sdk.jad_vg.jad_an(list, jad_boVar));
    }

    public static com.jd.ad.sdk.jad_ju.jad_ly<java.io.InputStream, android.graphics.drawable.Drawable> jad_bo(java.util.List<com.jd.ad.sdk.jad_ju.jad_fs> list, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        return new com.jd.ad.sdk.jad_vg.jad_an.jad_cp(new com.jd.ad.sdk.jad_vg.jad_an(list, jad_boVar));
    }

    public com.jd.ad.sdk.jad_mx.jad_xk<android.graphics.drawable.Drawable> jad_an(@androidx.annotation.NonNull android.graphics.ImageDecoder.Source source, int i, int i2, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        android.graphics.drawable.Drawable decodeDrawable;
        decodeDrawable = android.graphics.ImageDecoder.decodeDrawable(source, new com.jd.ad.sdk.jad_sd.jad_an(i, i2, jad_jwVar));
        if (decodeDrawable instanceof android.graphics.drawable.AnimatedImageDrawable) {
            return new com.jd.ad.sdk.jad_vg.jad_an.C0413jad_an((android.graphics.drawable.AnimatedImageDrawable) decodeDrawable);
        }
        throw new java.io.IOException("Received unexpected drawable type for animated webp, failing: " + decodeDrawable);
    }

    public boolean jad_an(java.io.InputStream inputStream) {
        return com.jd.ad.sdk.jad_ju.jad_jt.jad_bo(this.jad_an, inputStream, this.jad_bo) == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.ANIMATED_WEBP;
    }

    public boolean jad_an(java.nio.ByteBuffer byteBuffer) {
        return com.jd.ad.sdk.jad_ju.jad_jt.jad_an(this.jad_an, byteBuffer) == com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.ANIMATED_WEBP;
    }
}
