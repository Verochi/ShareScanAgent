package com.jd.ad.sdk.jad_hu;

/* loaded from: classes23.dex */
public class jad_jw extends com.jd.ad.sdk.bl.dynamicrender.ShakeListener {
    public final /* synthetic */ com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView jad_na;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_jw(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, android.content.Context context, float f, float f2, float f3) {
        super(context, f, f2, f3);
        this.jad_na = dynamicRenderView;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
    public void onShake() {
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView = this.jad_na;
        boolean jad_an = com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.jad_an(dynamicRenderView, dynamicRenderView.jad_sf);
        com.jd.ad.sdk.logger.Logger.d("==== 摇一摇: " + jad_an);
        if (jad_an) {
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView2 = this.jad_na;
            com.jd.ad.sdk.jad_hu.jad_an jad_anVar = dynamicRenderView2.jad_wj.get(dynamicRenderView2.jad_xk);
            if (jad_anVar != null) {
                com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView3 = this.jad_na;
                float f = dynamicRenderView3.jad_kv;
                float f2 = dynamicRenderView3.jad_mx;
                float f3 = dynamicRenderView3.jad_ny;
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
                jad_anVar.jad_dq = ordinal;
                jad_anVar.jad_an(this.jad_na.jad_sf);
            }
        }
    }
}
