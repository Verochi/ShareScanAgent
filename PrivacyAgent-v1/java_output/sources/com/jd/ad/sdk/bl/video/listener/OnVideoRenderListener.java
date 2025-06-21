package com.jd.ad.sdk.bl.video.listener;

/* loaded from: classes23.dex */
public interface OnVideoRenderListener {
    void onVideoRenderFailed(int i, java.lang.String str);

    void onVideoRenderSuccess(android.view.View view);

    void updateMaterialMetaPreload(boolean z);

    void videoPlayerError(int i, int i2, int i3, int i4, java.lang.String str);

    void videoPlayerStatusChanged(int i, int i2);
}
