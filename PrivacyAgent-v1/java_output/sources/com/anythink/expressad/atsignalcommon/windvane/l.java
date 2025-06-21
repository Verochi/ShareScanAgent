package com.anythink.expressad.atsignalcommon.windvane;

/* loaded from: classes12.dex */
public abstract class l {
    protected android.content.Context e;
    protected java.lang.Object f;
    protected com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView g;

    public void initialize(android.content.Context context, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        this.e = context;
        this.g = windVaneWebView;
    }

    public void initialize(java.lang.Object obj, com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView windVaneWebView) {
        this.f = obj;
        this.g = windVaneWebView;
    }
}
