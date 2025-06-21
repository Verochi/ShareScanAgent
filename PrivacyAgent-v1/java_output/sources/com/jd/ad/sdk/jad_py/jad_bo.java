package com.jd.ad.sdk.jad_py;

/* loaded from: classes23.dex */
public class jad_bo {
    public static final java.lang.Object jad_er = new java.lang.Object();
    public final android.content.Context jad_an;
    public final java.lang.String jad_bo;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_bo jad_cp;
    public final java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_na> jad_dq;

    public jad_bo(android.graphics.drawable.Drawable.Callback callback, java.lang.String str, com.jd.ad.sdk.jad_lu.jad_bo jad_boVar, java.util.Map<java.lang.String, com.jd.ad.sdk.jad_lu.jad_na> map) {
        if (!android.text.TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            str = str + '/';
        }
        this.jad_bo = str;
        if (callback instanceof android.view.View) {
            this.jad_an = ((android.view.View) callback).getContext();
            this.jad_dq = map;
            jad_an(jad_boVar);
        } else {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieDrawable must be inside of a view for images to work.");
            this.jad_dq = new java.util.HashMap();
            this.jad_an = null;
        }
    }

    public final android.graphics.Bitmap jad_an(java.lang.String str, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        synchronized (jad_er) {
            this.jad_dq.get(str).jad_er = bitmap;
        }
        return bitmap;
    }

    public void jad_an(@androidx.annotation.Nullable com.jd.ad.sdk.jad_lu.jad_bo jad_boVar) {
        this.jad_cp = jad_boVar;
    }
}
