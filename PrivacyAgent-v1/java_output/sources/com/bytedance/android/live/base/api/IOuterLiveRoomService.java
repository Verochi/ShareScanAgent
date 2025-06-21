package com.bytedance.android.live.base.api;

/* loaded from: classes.dex */
public interface IOuterLiveRoomService {
    void addEventListener(com.bytedance.android.live.base.api.IEventListener iEventListener);

    java.lang.Object callExpandMethod(java.lang.String str, java.lang.Object... objArr);

    @java.lang.Deprecated
    void enterRoomWithDraw();

    void enterRoomWithDraw(android.os.Bundle bundle);

    com.bytedance.android.live.base.api.outer.ILiveProvider getLiveProvider();

    com.bytedance.android.live.base.api.push.ILivePush getPushService();

    com.bytedance.android.live.base.api.outer.data.OpenUserInfo getUserInfo();

    com.bytedance.android.live.base.api.IBaseHorizontalLiveListView makeFollowListView(android.content.Context context, android.os.Bundle bundle, com.bytedance.android.live.base.api.ILiveBorderAnimController iLiveBorderAnimController);

    void removeEventListener(com.bytedance.android.live.base.api.IEventListener iEventListener);

    @java.lang.Deprecated
    void setEventListener(com.bytedance.android.live.base.api.IEventListener iEventListener);

    void setNeedPersonalRecommend(boolean z);

    void setUseBlackNavigationBar(boolean z);

    void updateConsumer(int i, com.bytedance.android.live.base.api.callback.Callback<java.lang.Object> callback, boolean z);
}
