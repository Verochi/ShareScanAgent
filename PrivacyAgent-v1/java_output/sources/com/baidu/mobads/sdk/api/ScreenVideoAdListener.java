package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public interface ScreenVideoAdListener {
    void onAdClick();

    void onAdClose(float f);

    void onAdFailed(java.lang.String str);

    void onAdLoaded();

    void onAdShow();

    void onAdSkip(float f);

    void onVideoDownloadFailed();

    void onVideoDownloadSuccess();

    void playCompletion();
}
