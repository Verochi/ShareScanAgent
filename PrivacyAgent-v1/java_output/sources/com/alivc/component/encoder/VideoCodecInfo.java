package com.alivc.component.encoder;

/* loaded from: classes.dex */
public class VideoCodecInfo {
    private static final java.lang.String TAG = "VideoCodecInfo";
    public int mHeightAlign;
    public int mMaxBitrate;
    public int mMaxHeight;
    public int mMaxWidth;
    final java.lang.String mMimeType = "video/avc";
    public int mMinBitrate;
    public int mMinHeight;
    public int mMinWidth;
    public android.media.MediaCodecInfo.VideoCapabilities mVideoCapabilities;
    public int mWidthAlign;

    public VideoCodecInfo() {
        android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType;
        this.mMaxBitrate = Integer.MAX_VALUE;
        this.mMinBitrate = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMinWidth = 0;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mMinHeight = 0;
        this.mWidthAlign = 16;
        this.mHeightAlign = 16;
        this.mVideoCapabilities = null;
        android.media.MediaCodecInfo selectCodecInfo = selectCodecInfo("video/avc");
        if (selectCodecInfo == null || (capabilitiesForType = selectCodecInfo.getCapabilitiesForType("video/avc")) == null) {
            return;
        }
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
        this.mVideoCapabilities = videoCapabilities;
        if (videoCapabilities == null) {
            return;
        }
        android.util.Range<java.lang.Integer> bitrateRange = videoCapabilities.getBitrateRange();
        this.mMaxBitrate = bitrateRange.getUpper().intValue();
        this.mMinBitrate = bitrateRange.getLower().intValue();
        this.mWidthAlign = this.mVideoCapabilities.getWidthAlignment();
        this.mHeightAlign = this.mVideoCapabilities.getHeightAlignment();
        android.util.Range<java.lang.Integer> supportedWidths = this.mVideoCapabilities.getSupportedWidths();
        this.mMaxWidth = supportedWidths.getUpper().intValue();
        this.mMinWidth = supportedWidths.getLower().intValue();
        android.util.Range<java.lang.Integer> supportedHeights = this.mVideoCapabilities.getSupportedHeights();
        this.mMaxHeight = supportedHeights.getUpper().intValue();
        this.mMinHeight = supportedHeights.getLower().intValue();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("bitrateRange [");
        sb.append(this.mMinBitrate);
        sb.append(",");
        sb.append(this.mMaxBitrate);
        sb.append("], widthAlignment = ");
        sb.append(this.mWidthAlign);
        sb.append(", heightAlignment = ");
        sb.append(this.mHeightAlign);
        sb.append(", widthRange [");
        sb.append(this.mMinWidth);
        sb.append(",");
        sb.append(this.mMaxWidth);
        sb.append("], heightRange [");
        sb.append(this.mMinHeight);
        sb.append(",");
        sb.append(this.mMaxHeight);
        sb.append("]");
    }

    private android.media.MediaCodecInfo selectCodecInfo(java.lang.String str) {
        int codecCount = android.media.MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            android.media.MediaCodecInfo codecInfoAt = android.media.MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (java.lang.String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }

    public void getSupportFormats() {
    }

    public void getSupportProfile() {
    }

    public boolean isSizeSupported(int i, int i2) {
        android.media.MediaCodecInfo.VideoCapabilities videoCapabilities = this.mVideoCapabilities;
        if (videoCapabilities != null) {
            return videoCapabilities.isSizeSupported(i, i2);
        }
        return true;
    }
}
