package com.bytedance.android.live.base.api.outer;

/* loaded from: classes.dex */
public interface IStandalonePreviewView {
    android.view.View getView();

    void release();

    void setLiveStatusListener(com.bytedance.android.live.base.api.outer.ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z);

    void show();

    void stream();
}
