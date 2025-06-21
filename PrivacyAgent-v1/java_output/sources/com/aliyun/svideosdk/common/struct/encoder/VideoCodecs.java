package com.aliyun.svideosdk.common.struct.encoder;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public enum VideoCodecs {
    H264_HARDWARE,
    H264_SOFT_OPENH264;

    public static com.aliyun.svideosdk.common.struct.encoder.VideoCodecs getInstanceByValue(int i) {
        return i != 1 ? H264_HARDWARE : H264_SOFT_OPENH264;
    }
}
