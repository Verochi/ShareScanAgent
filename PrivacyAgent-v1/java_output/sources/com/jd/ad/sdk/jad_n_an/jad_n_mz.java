package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_mz implements android.view.View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_an;

    public jad_n_mz(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar) {
        this.jad_n_an = jad_n_ivVar;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(this.jad_n_an, view, true);
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
