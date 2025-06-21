package com.anythink.network.toutiao;

/* loaded from: classes12.dex */
public class TTATCustomVideo implements com.anythink.core.api.ATCustomVideo {
    com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo a;

    public TTATCustomVideo(com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo) {
        this.a = customizeVideo;
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public java.lang.String getVideoUrl() {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            return customizeVideo.getVideoUrl();
        }
        return null;
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoAutoStart() {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoBreak(long j) {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoContinue(long j) {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoError(long j, int i, int i2) {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i, i2);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoFinish() {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoPause(long j) {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoStart() {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.anythink.core.api.ATCustomVideo
    public void reportVideoStartError(int i, int i2) {
        com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo customizeVideo = this.a;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i, i2);
        }
    }
}
