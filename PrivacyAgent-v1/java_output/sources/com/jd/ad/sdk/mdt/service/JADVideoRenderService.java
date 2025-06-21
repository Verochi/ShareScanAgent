package com.jd.ad.sdk.mdt.service;

/* loaded from: classes23.dex */
public interface JADVideoRenderService {
    com.jd.ad.sdk.bl.video.VideoRenderView createVideoRendView(android.content.Context context, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull com.jd.ad.sdk.dl.model.JADSlot jADSlot, long j, com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener onVideoRenderListener, com.jd.ad.sdk.bl.video.listener.VideoLoadListener videoLoadListener);

    void registerAdViewClick(android.content.Context context, com.jd.ad.sdk.bl.video.VideoRenderView videoRenderView, com.jd.ad.sdk.bl.video.listener.VideoInteractionListener videoInteractionListener);
}
