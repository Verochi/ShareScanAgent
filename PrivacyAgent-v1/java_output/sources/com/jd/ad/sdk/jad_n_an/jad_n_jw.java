package com.jd.ad.sdk.jad_n_an;

/* loaded from: classes23.dex */
public class jad_n_jw implements android.view.View.OnClickListener {
    public final /* synthetic */ android.view.View jad_n_an;
    public final /* synthetic */ boolean jad_n_bo;
    public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_cp;

    public jad_n_jw(com.jd.ad.sdk.jad_n_an.jad_n_iv jad_n_ivVar, android.view.View view, boolean z) {
        this.jad_n_cp = jad_n_ivVar;
        this.jad_n_an = view;
        this.jad_n_bo = z;
    }

    @Override // android.view.View.OnClickListener
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onClick(android.view.View view) {
        this.jad_n_cp.jad_n_bo(this.jad_n_an);
        if (this.jad_n_bo) {
            com.jd.ad.sdk.jad_n_an.jad_n_iv.jad_n_an(this.jad_n_cp, this.jad_n_an, false);
        }
        com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
