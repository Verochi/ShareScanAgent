package com.jd.ad.sdk.bl.video.listener;

/* loaded from: classes23.dex */
public interface VideoInteractionListener {
    void onAdClicked(int i, int i2);

    void onAdCountdown(int i);

    void onAdSkip(android.view.View view);

    void onAdTimeOver();

    void onVideoAnimationEnd();
}
