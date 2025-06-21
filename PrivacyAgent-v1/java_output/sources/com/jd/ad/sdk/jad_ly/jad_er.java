package com.jd.ad.sdk.jad_ly;

/* loaded from: classes23.dex */
public class jad_er implements android.view.View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.bl.video.VideoRenderView jad_an;

    public jad_er(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView) {
        this.jad_an = videoRenderView;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = this.jad_an;
        com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener = videoRenderView.jad_qd;
        if (videoInteractionListener != null) {
            videoInteractionListener.onAdClicked(videoRenderView.jad_pc, com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.CLICK.ordinal());
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
