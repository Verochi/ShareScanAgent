package com.bytedance.android.live.base.api.outer;

/* loaded from: classes.dex */
public interface ILiveProvider {
    java.lang.String getCirculationData();

    com.bytedance.android.live.base.api.outer.ILivePreviewLayout getILivePreviewLayout(com.bytedance.android.live.base.api.outer.ILivePreviewLayout.Builder builder);

    java.lang.String getIdentity();

    com.bytedance.android.live.base.api.outer.ILiveView getLiveView(android.content.Context context, int i, java.lang.String str, boolean z, android.os.Bundle bundle);

    @java.lang.Deprecated
    java.util.List<com.bytedance.android.live.base.api.outer.data.RoomInfo> getRoomInfoList(int i, int i2, int i3);

    java.util.List<com.bytedance.android.live.base.api.outer.data.RoomInfo> getRoomInfoList(int i, int i2, int i3, android.os.Bundle bundle);

    com.bytedance.android.live.base.api.outer.IStandalonePreviewView makeStandalonePreviewView(android.content.Context context, int i, android.os.Bundle bundle);

    void reportShow(int i, java.lang.String str, android.os.Bundle bundle);

    void startLive(android.content.Context context, int i, java.lang.String str, android.os.Bundle bundle);
}
