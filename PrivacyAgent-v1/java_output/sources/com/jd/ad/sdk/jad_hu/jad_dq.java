package com.jd.ad.sdk.jad_hu;

/* loaded from: classes23.dex */
public class jad_dq implements java.lang.Runnable {
    public final /* synthetic */ android.content.Context jad_an;

    public jad_dq(android.content.Context context) {
        this.jad_an = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper.jad_an() && com.jd.ad.sdk.jad_qd.jad_jw.jad_dq(this.jad_an) && com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper.jad_dq == null) {
            com.jd.ad.sdk.jad_hu.jad_bo jad_an = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(this.jad_an, "jaddb.db", 2);
            com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper.jad_dq = jad_an;
            jad_an.jad_cp();
        }
    }
}
