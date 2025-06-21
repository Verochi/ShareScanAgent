package com.alimm.tanx.core.orange.bean;

/* loaded from: classes.dex */
public class FeedMonitorBean extends com.alimm.tanx.core.ad.bean.BaseBean {
    public java.lang.String minRatio;

    public float getMinRatio() {
        try {
            return java.lang.Float.parseFloat(this.minRatio);
        } catch (java.lang.Exception unused) {
            return 0.0f;
        }
    }
}
