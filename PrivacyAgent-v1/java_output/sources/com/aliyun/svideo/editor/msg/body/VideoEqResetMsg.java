package com.aliyun.svideo.editor.msg.body;

/* loaded from: classes12.dex */
public class VideoEqResetMsg {
    private com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType mType;

    public com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType getType() {
        return this.mType;
    }

    public void setType(com.aliyun.svideosdk.common.internal.videoaugment.VideoAugmentationType videoAugmentationType) {
        this.mType = videoAugmentationType;
    }
}
