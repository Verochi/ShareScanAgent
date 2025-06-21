package com.anythink.splashad.api;

/* loaded from: classes12.dex */
public interface IATSplashEyeAd {
    void destroy();

    int[] getSuggestedSize(android.content.Context context);

    void onFinished();

    void setEyeAdContainer(android.view.ViewGroup viewGroup);

    void show(android.content.Context context, android.graphics.Rect rect, com.anythink.splashad.api.ATSplashEyeAdListener aTSplashEyeAdListener);
}
