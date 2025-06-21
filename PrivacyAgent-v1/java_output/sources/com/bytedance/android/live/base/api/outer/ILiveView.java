package com.bytedance.android.live.base.api.outer;

/* loaded from: classes.dex */
public interface ILiveView {
    android.view.View getView();

    void onDislike();

    void openLive();

    void release();

    void reportShow();

    void setLiveStatusListener(com.bytedance.android.live.base.api.outer.ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z);

    void show();

    void stream();
}
