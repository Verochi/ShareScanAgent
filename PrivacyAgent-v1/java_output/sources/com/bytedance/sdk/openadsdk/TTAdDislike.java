package com.bytedance.sdk.openadsdk;

/* loaded from: classes22.dex */
public interface TTAdDislike {

    public interface DislikeInteractionCallback {
        void onCancel();

        void onSelected(int i, java.lang.String str, boolean z);

        void onShow();
    }

    boolean isShow();

    void resetDislikeStatus();

    void setDislikeInteractionCallback(com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeSource(java.lang.String str);

    void showDislikeDialog();
}
