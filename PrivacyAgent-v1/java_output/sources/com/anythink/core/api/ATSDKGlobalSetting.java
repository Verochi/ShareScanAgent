package com.anythink.core.api;

/* loaded from: classes12.dex */
public class ATSDKGlobalSetting {
    private static volatile android.graphics.drawable.Drawable mDirectlySplashAdCTAButtongBgDrawable;
    private static volatile java.lang.String mDirectlySplashAdShakeIconString;

    public static android.graphics.drawable.Drawable getDirectlySplashAdCTAButtongBgDrawable() {
        return mDirectlySplashAdCTAButtongBgDrawable;
    }

    public static java.lang.String getDirectlySplashAdShakeIconString() {
        return mDirectlySplashAdShakeIconString;
    }

    public static void setDirectlySplashAdCTAButtongBgDrawable(android.graphics.drawable.Drawable drawable) {
        mDirectlySplashAdCTAButtongBgDrawable = drawable;
    }

    public static void setDirectlySplashAdShakeIconString(java.lang.String str) {
        mDirectlySplashAdShakeIconString = str;
    }
}
