package com.aliyun.svideosdk.common.struct.recorder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public enum CameraType {
    FRONT(1),
    BACK(0);

    private int type;

    CameraType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
