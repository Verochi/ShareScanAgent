package com.jd.ad.sdk.bl.dynamicrender;

/* loaded from: classes23.dex */
public class jad_bo implements android.view.View.OnClickListener {
    public final /* synthetic */ android.content.Context jad_an;
    public final /* synthetic */ com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView jad_bo;

    public jad_bo(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView dynamicRenderView, android.content.Context context) {
        this.jad_bo = dynamicRenderView;
        this.jad_an = context;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback iDynamicRenderCallback = this.jad_bo.jad_cn;
        if (iDynamicRenderCallback != null) {
            iDynamicRenderCallback.onFullLottieViewClick(this.jad_an);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
