package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_ly implements android.view.View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_an;
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_bo;

    public jad_n_ly(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar) {
        this.jad_n_bo = jad_n_ivVar;
        this.jad_n_an = jad_n_anVar;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(this.jad_n_bo, view, true);
        this.jad_n_an.jad_n_bo();
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
