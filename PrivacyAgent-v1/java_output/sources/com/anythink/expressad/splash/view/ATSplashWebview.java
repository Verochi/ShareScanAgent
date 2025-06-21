package com.anythink.expressad.splash.view;

/* loaded from: classes12.dex */
public class ATSplashWebview extends com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView {
    private static final java.lang.String a = "ATSplashWebview";
    private java.lang.String b;

    public ATSplashWebview(android.content.Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public java.lang.String getRequestId() {
        return this.b;
    }

    public void setRequestId(java.lang.String str) {
        this.b = str;
    }
}
