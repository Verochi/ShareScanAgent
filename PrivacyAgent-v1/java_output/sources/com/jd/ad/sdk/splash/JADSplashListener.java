package com.jd.ad.sdk.splash;

/* loaded from: classes23.dex */
public interface JADSplashListener {
    void onClick();

    void onClose();

    void onExposure();

    void onLoadFailure(int i, java.lang.String str);

    void onLoadSuccess();

    void onRenderFailure(int i, java.lang.String str);

    void onRenderSuccess(android.view.View view);
}
