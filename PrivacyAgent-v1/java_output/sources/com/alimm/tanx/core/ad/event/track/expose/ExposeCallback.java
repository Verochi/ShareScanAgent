package com.alimm.tanx.core.ad.event.track.expose;

/* loaded from: classes.dex */
public interface ExposeCallback {
    void onFail(int i, java.lang.String str, java.lang.String str2);

    void onSucceed(int i, java.lang.String str);

    void send(java.lang.String str);
}
