package com.jd.ad.sdk.jad_py;

/* loaded from: classes23.dex */
public class jad_an {
    public final android.content.res.AssetManager jad_dq;

    @androidx.annotation.Nullable
    public com.jd.ad.sdk.jad_lu.jad_an jad_er;
    public final com.jd.ad.sdk.jad_qz.jad_iv<java.lang.String> jad_an = new com.jd.ad.sdk.jad_qz.jad_iv<>();
    public final java.util.Map<com.jd.ad.sdk.jad_qz.jad_iv<java.lang.String>, android.graphics.Typeface> jad_bo = new java.util.HashMap();
    public final java.util.Map<java.lang.String, android.graphics.Typeface> jad_cp = new java.util.HashMap();
    public java.lang.String jad_fs = ".ttf";

    public jad_an(android.graphics.drawable.Drawable.Callback callback, @androidx.annotation.Nullable com.jd.ad.sdk.jad_lu.jad_an jad_anVar) {
        android.content.res.AssetManager assets;
        this.jad_er = jad_anVar;
        if (callback instanceof android.view.View) {
            assets = ((android.view.View) callback).getContext().getAssets();
        } else {
            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.jad_dq = assets;
    }
}
