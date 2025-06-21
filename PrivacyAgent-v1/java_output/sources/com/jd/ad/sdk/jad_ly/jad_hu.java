package com.jd.ad.sdk.jad_ly;

/* loaded from: classes23.dex */
public class jad_hu extends com.jd.ad.sdk.bl.dynamicrender.ShakeListener {
    public final /* synthetic */ com.jd.ad.sdk.bl.video.VideoRenderView jad_na;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_hu(com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView, android.content.Context context, float f, float f2, float f3) {
        super(context, f, f2, f3);
        this.jad_na = videoRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView = this.jad_na;
        if (com.jd.ad.sdk.bl.video.VideoRenderView.jad_an(videoRenderView, videoRenderView.jad_tg)) {
            com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView2 = this.jad_na;
            if (videoRenderView2.jad_qd != null) {
                float f = videoRenderView2.jad_jw;
                float f2 = videoRenderView2.jad_ly;
                float f3 = videoRenderView2.jad_mz;
                com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType adTriggerSourceType = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE;
                int ordinal = adTriggerSourceType.ordinal();
                if (f3 > 0.0f) {
                    if (f > 0.0f && f2 > 0.0f) {
                        ordinal = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
                    } else if (f > 0.0f) {
                        ordinal = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
                    } else if (f2 > 0.0f) {
                        ordinal = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal();
                    }
                } else if (f > 0.0f && f2 > 0.0f) {
                    ordinal = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
                } else if (f > 0.0f) {
                    ordinal = adTriggerSourceType.ordinal();
                } else if (f2 > 0.0f) {
                    ordinal = com.jd.ad.sdk.dl.common.CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal();
                }
                com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView3 = this.jad_na;
                videoRenderView3.jad_qd.onAdClicked(videoRenderView3.jad_pc, ordinal);
            }
        }
    }
}
