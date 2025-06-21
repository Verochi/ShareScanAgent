package com.bytedance.android.live.base.api;

/* loaded from: classes.dex */
public interface ILiveOuterPreviewCoverView {
    void cancelAutoEnterGuide(boolean z);

    android.view.View getView();

    void onShow();

    void release();

    void setCustomBottomView(android.view.View view);

    void setOnDislikeCallback(com.bytedance.android.live.base.api.callback.EmptyCallback emptyCallback);

    void stream(java.lang.String str);
}
