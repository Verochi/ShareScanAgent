package com.bytedance.android.live.base.api.outer;

/* loaded from: classes.dex */
public interface ILiveStatusListener {
    void onError(java.lang.String str);

    void onFirstFrame();

    void onLiveStatusChange(boolean z);

    void onPrepare();

    void onRoomInvalid();

    void onVideoSizeChanged(int i, int i2);
}
