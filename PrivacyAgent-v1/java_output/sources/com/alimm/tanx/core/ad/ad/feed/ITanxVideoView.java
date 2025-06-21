package com.alimm.tanx.core.ad.ad.feed;

/* loaded from: classes.dex */
public interface ITanxVideoView {
    void destroy();

    android.view.View getVideoAdView(com.alimm.tanx.core.ad.ad.feed.ITanxFeedVideoAdListener iTanxFeedVideoAdListener);

    boolean isMute();

    void mute();

    void pause();

    void play();

    void replay();

    void resumeVolume();

    void setVolume(int i);
}
