package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_jt implements com.jd.ad.sdk.bl.video.listener.VideoInteractionListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_jt(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdClicked(int i, int i2) {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_an(), this.jad_s_an.jad_s_jt, 1, i, i2);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdCountdown(int i) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, i);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdSkip(android.view.View view) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, view);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onAdTimeOver() {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an);
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoInteractionListener
    public void onVideoAnimationEnd() {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an);
    }
}
