package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public enum VideoDisplayMode {
    SCALE(0),
    FILL(1);

    private int displayMode;

    VideoDisplayMode(int i) {
        this.displayMode = i;
    }

    public static com.aliyun.svideosdk.common.struct.common.VideoDisplayMode valueOf(int i) {
        return values()[i];
    }

    public int getDisplayMode() {
        return this.displayMode;
    }
}
