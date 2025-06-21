package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_fs implements com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_fs(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdClicked(int i, int i2) {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_an(), this.jad_s_an.jad_s_jt, 3, i, i2);
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdSkip(android.view.View view) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, view);
    }
}
