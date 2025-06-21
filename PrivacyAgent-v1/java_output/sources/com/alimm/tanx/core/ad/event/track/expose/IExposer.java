package com.alimm.tanx.core.ad.event.track.expose;

/* loaded from: classes.dex */
public interface IExposer {
    public static final java.lang.String SDK_DEFAULT = "0";
    public static final java.lang.String SDK_MMA = "1";

    void onExpose(java.lang.String str, java.lang.String str2, com.alimm.tanx.core.ad.event.track.expose.ExposeCallback exposeCallback);
}
