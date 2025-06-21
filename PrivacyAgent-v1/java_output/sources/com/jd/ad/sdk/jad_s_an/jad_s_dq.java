package com.jd.ad.sdk.jad_s_an;

/* loaded from: classes23.dex */
public class jad_s_dq implements com.jd.ad.sdk.bl.video.listener.VideoLoadListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_dq(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoLoadListener
    public void onLoadFailure(int i, @androidx.annotation.Nullable java.lang.String str) {
        try {
            com.jd.ad.sdk.mdt.service.JADEventService eventService = com.jd.ad.sdk.mdt.servicemediator.JADMediator.getInstance().getEventService();
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
            eventService.reportRenderFailedEvent(jad_s_anVar.jad_s_er, i, jad_s_anVar.jad_s_an(str), this.jad_s_an.jad_s_fs);
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.logger.Logger.d(android.util.Log.getStackTraceString(e));
        }
    }

    @Override // com.jd.ad.sdk.bl.video.listener.VideoLoadListener
    public void onLoadSuccess() {
    }
}
