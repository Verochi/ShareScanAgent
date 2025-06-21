package com.aliyun.svideosdk.common.struct.project;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class MainVideoTrackClip extends com.aliyun.svideosdk.common.struct.project.VideoTrackClip {

    @com.google.gson.annotations.SerializedName("ClassType")
    java.lang.String ClassType = "main";

    @com.google.gson.annotations.SerializedName("DisplayMode")
    private int mDisplayMode;

    public int getDisplayMode() {
        return this.mDisplayMode;
    }

    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
    }
}
