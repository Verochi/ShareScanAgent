package com.jd.ad.sdk.jad_tc;

/* loaded from: classes23.dex */
public class jad_cp extends com.jd.ad.sdk.jad_tc.jad_an {
    public final android.graphics.Paint jad_do;
    public final android.graphics.Rect jad_ep;
    public final android.graphics.Rect jad_fq;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_gr;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_ox.jad_an<android.graphics.Bitmap, android.graphics.Bitmap> jad_hs;

    public jad_cp(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_er jad_erVar) {
        super(jad_mzVar, jad_erVar);
        this.jad_do = new com.jd.ad.sdk.jad_mv.jad_an(3);
        this.jad_ep = new android.graphics.Rect();
        this.jad_fq = new android.graphics.Rect();
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(android.graphics.RectF rectF, android.graphics.Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        if (jad_ly() != null) {
            rectF.set(0.0f, 0.0f, com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * r3.getWidth(), com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * r3.getHeight());
            this.jad_mz.mapRect(rectF);
        }
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, @androidx.annotation.Nullable com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_mx) {
            if (jad_cpVar == null) {
                this.jad_gr = null;
                return;
            } else {
                this.jad_gr = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
                return;
            }
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_pa) {
            if (jad_cpVar == null) {
                this.jad_hs = null;
            } else {
                this.jad_hs = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public void jad_bo(@androidx.annotation.NonNull android.graphics.Canvas canvas, android.graphics.Matrix matrix, int i) {
        android.graphics.Bitmap jad_ly = jad_ly();
        if (jad_ly == null || jad_ly.isRecycled()) {
            return;
        }
        float jad_an = com.jd.ad.sdk.jad_xg.jad_hu.jad_an();
        this.jad_do.setAlpha(i);
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.ColorFilter, android.graphics.ColorFilter> jad_anVar = this.jad_gr;
        if (jad_anVar != null) {
            this.jad_do.setColorFilter(jad_anVar.jad_fs());
        }
        canvas.save();
        canvas.concat(matrix);
        this.jad_ep.set(0, 0, jad_ly.getWidth(), jad_ly.getHeight());
        this.jad_fq.set(0, 0, (int) (jad_ly.getWidth() * jad_an), (int) (jad_ly.getHeight() * jad_an));
        canvas.drawBitmap(jad_ly, this.jad_ep, this.jad_fq, this.jad_do);
        canvas.restore();
    }

    @androidx.annotation.Nullable
    public final android.graphics.Bitmap jad_ly() {
        com.jd.ad.sdk.jad_py.jad_bo jad_boVar;
        java.lang.String str;
        android.graphics.Bitmap bitmap;
        android.graphics.Bitmap jad_fs;
        com.jd.ad.sdk.jad_ox.jad_an<android.graphics.Bitmap, android.graphics.Bitmap> jad_anVar = this.jad_hs;
        if (jad_anVar != null && (jad_fs = jad_anVar.jad_fs()) != null) {
            return jad_fs;
        }
        java.lang.String str2 = this.jad_ob.jad_jt;
        com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar = this.jad_na;
        if (jad_mzVar.getCallback() == null) {
            jad_boVar = null;
        } else {
            com.jd.ad.sdk.jad_py.jad_bo jad_boVar2 = jad_mzVar.jad_iv;
            if (jad_boVar2 != null) {
                android.graphics.drawable.Drawable.Callback callback = jad_mzVar.getCallback();
                android.content.Context context = (callback != null && (callback instanceof android.view.View)) ? ((android.view.View) callback).getContext() : null;
                if (!((context == null && jad_boVar2.jad_an == null) || jad_boVar2.jad_an.equals(context))) {
                    jad_mzVar.jad_iv = null;
                }
            }
            if (jad_mzVar.jad_iv == null) {
                jad_mzVar.jad_iv = new com.jd.ad.sdk.jad_py.jad_bo(jad_mzVar.getCallback(), jad_mzVar.jad_jw, jad_mzVar.jad_kx, jad_mzVar.jad_bo.jad_dq);
            }
            jad_boVar = jad_mzVar.jad_iv;
        }
        if (jad_boVar == null) {
            com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = jad_mzVar.jad_bo;
            com.jd.ad.sdk.jad_lu.jad_na jad_naVar = jad_jtVar == null ? null : jad_jtVar.jad_dq.get(str2);
            if (jad_naVar != null) {
                return jad_naVar.jad_er;
            }
            return null;
        }
        com.jd.ad.sdk.jad_lu.jad_na jad_naVar2 = jad_boVar.jad_dq.get(str2);
        if (jad_naVar2 == null) {
            return null;
        }
        android.graphics.Bitmap bitmap2 = jad_naVar2.jad_er;
        if (bitmap2 != null) {
            return bitmap2;
        }
        com.jd.ad.sdk.jad_lu.jad_bo jad_boVar3 = jad_boVar.jad_cp;
        if (jad_boVar3 != null) {
            com.jd.ad.sdk.jad_hu.jad_jt jad_jtVar2 = (com.jd.ad.sdk.jad_hu.jad_jt) jad_boVar3;
            java.lang.String str3 = jad_naVar2.jad_cp;
            java.util.Map map = jad_jtVar2.jad_an;
            if (map == null || !map.containsKey(str3)) {
                android.graphics.Bitmap[] bitmapArr = {null};
                try {
                    com.jd.ad.sdk.jad_gr.jad_cp.jad_bo(jad_jtVar2.jad_bo).jad_er().jad_an(jad_naVar2.jad_dq).jad_an((com.jd.ad.sdk.jad_gr.jad_iv<android.graphics.Bitmap>) new com.jd.ad.sdk.jad_hu.jad_fs(jad_jtVar2, jad_naVar2, bitmapArr));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                bitmap = bitmapArr[0];
            } else {
                bitmap = (android.graphics.Bitmap) jad_jtVar2.jad_an.get(str3);
            }
            android.graphics.Bitmap bitmap3 = bitmap;
            if (bitmap3 == null) {
                return bitmap3;
            }
            jad_boVar.jad_an(str2, bitmap3);
            return bitmap3;
        }
        java.lang.String str4 = jad_naVar2.jad_dq;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
        if (str4.startsWith("data:") && str4.indexOf("base64,") > 0) {
            try {
                byte[] decode = android.util.Base64.decode(str4.substring(str4.indexOf(44) + 1), 0);
                return jad_boVar.jad_an(str2, android.graphics.BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (java.lang.IllegalArgumentException e2) {
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (android.text.TextUtils.isEmpty(jad_boVar.jad_bo)) {
                throw new java.lang.IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                android.graphics.Bitmap decodeStream = android.graphics.BitmapFactory.decodeStream(jad_boVar.jad_an.getAssets().open(jad_boVar.jad_bo + str4), null, options);
                int i = jad_naVar2.jad_an;
                int i2 = jad_naVar2.jad_bo;
                java.lang.ThreadLocal<android.graphics.PathMeasure> threadLocal = com.jd.ad.sdk.jad_xg.jad_hu.jad_an;
                if (decodeStream.getWidth() != i || decodeStream.getHeight() != i2) {
                    android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(decodeStream, i, i2, true);
                    decodeStream.recycle();
                    decodeStream = createScaledBitmap;
                }
                return jad_boVar.jad_an(str2, decodeStream);
            } catch (java.lang.IllegalArgumentException e3) {
                e = e3;
                str = "Unable to decode image.";
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an(str, e);
                return null;
            }
        } catch (java.io.IOException e4) {
            e = e4;
            str = "Unable to open asset.";
        }
    }
}
