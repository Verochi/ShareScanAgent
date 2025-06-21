package com.alimm.tanx.core.orange.bean;

/* loaded from: classes.dex */
public class SplashMonitorBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public java.lang.String coverRatio;

    public float getCoverRatio() {
        try {
            return java.lang.Float.parseFloat(this.coverRatio);
        } catch (java.lang.Exception unused) {
            return 0.0f;
        }
    }
}
