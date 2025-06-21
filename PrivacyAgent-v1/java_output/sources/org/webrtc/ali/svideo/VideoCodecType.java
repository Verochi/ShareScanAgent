package org.webrtc.ali.svideo;

/* loaded from: classes26.dex */
enum VideoCodecType {
    VP8("video/x-vnd.on2.vp8"),
    VP9("video/x-vnd.on2.vp9"),
    H264("video/avc");

    private final java.lang.String mimeType;

    VideoCodecType(java.lang.String str) {
        this.mimeType = str;
    }

    public java.lang.String mimeType() {
        return this.mimeType;
    }
}
