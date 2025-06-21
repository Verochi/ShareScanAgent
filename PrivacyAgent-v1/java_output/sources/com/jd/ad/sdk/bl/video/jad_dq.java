package com.jd.ad.sdk.bl.video;

/* loaded from: classes23.dex */
public class jad_dq implements android.view.View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.bl.video.VideoSkipView jad_an;

    public jad_dq(com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView) {
        this.jad_an = videoSkipView;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.jd.ad.sdk.bl.video.VideoSkipView.jad_bo jad_boVar = this.jad_an.jad_bo;
        if (jad_boVar != null) {
            com.jd.ad.sdk.bl.video.jad_bo jad_boVar2 = (com.jd.ad.sdk.bl.video.jad_bo) jad_boVar;
            com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener = jad_boVar2.jad_an.jad_qd;
            if (videoInteractionListener != null) {
                videoInteractionListener.onAdSkip(view);
            }
            com.jd.ad.sdk.bl.video.VideoSkipView videoSkipView = jad_boVar2.jad_an.jad_it;
            if (videoSkipView != null) {
                videoSkipView.removeCallbacks(null);
            }
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
