package com.bytedance.android.live.base.api;

/* loaded from: classes.dex */
public interface IOuterLiveService extends com.bytedance.android.live.base.api.IOuterLiveRoomService {
    boolean canHandleScheme(android.net.Uri uri);

    void enterLiveRoom(android.content.Context context, long j, android.os.Bundle bundle);

    boolean handleSchema(android.content.Context context, android.net.Uri uri);

    com.bytedance.android.live.base.api.ILiveOuterPreviewCoverView makePreviewCoverView(android.content.Context context, android.os.Bundle bundle);
}
