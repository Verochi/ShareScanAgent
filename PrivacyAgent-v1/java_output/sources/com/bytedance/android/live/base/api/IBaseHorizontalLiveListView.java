package com.bytedance.android.live.base.api;

/* loaded from: classes.dex */
public interface IBaseHorizontalLiveListView {
    void refresh();

    android.view.View self();

    void setEmptyListener(com.bytedance.android.live.base.api.callback.Callback<java.lang.Boolean> callback);

    void setErrorListener(com.bytedance.android.live.base.api.callback.Callback<java.lang.Boolean> callback);

    void setRoomCountListener(com.bytedance.android.live.base.api.callback.Callback<java.lang.Integer> callback);
}
