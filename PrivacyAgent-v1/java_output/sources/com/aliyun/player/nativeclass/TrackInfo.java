package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class TrackInfo {
    public static final int AUTO_SELECT_INDEX = -1;
    public int audioChannels;
    public java.lang.String audioLang;
    public int audioSampleFormat;
    public int audioSampleRate;
    public java.lang.String codecName;
    public java.lang.String description;
    public int index;
    public java.lang.String subtitleLang;
    public int videoBitrate;
    public int videoHeight;
    public int videoWidth;
    public java.lang.String vodDefinition;
    public long vodFileSize;
    public java.lang.String vodFormat;
    public java.lang.String vodPlayUrl;
    public java.lang.String vodWaterMarkPlayUrl;
    public com.aliyun.player.nativeclass.TrackInfo.Type mType = com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_VOD;
    public com.aliyun.player.nativeclass.TrackInfo.VideoHDRType videoHDRType = com.aliyun.player.nativeclass.TrackInfo.VideoHDRType.VideoHDRType_SDR;

    public enum Type {
        TYPE_VIDEO,
        TYPE_AUDIO,
        TYPE_SUBTITLE,
        TYPE_VOD
    }

    public enum VideoHDRType {
        VideoHDRType_SDR,
        VideoHDRType_HDR10
    }

    private int nGetType() {
        return this.mType.ordinal();
    }

    private void setType(int i) {
        com.aliyun.player.nativeclass.TrackInfo.Type type = com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_VIDEO;
        if (i != type.ordinal()) {
            type = com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_AUDIO;
            if (i != type.ordinal()) {
                type = com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_SUBTITLE;
                if (i != type.ordinal()) {
                    type = com.aliyun.player.nativeclass.TrackInfo.Type.TYPE_VOD;
                    if (i != type.ordinal()) {
                        return;
                    }
                }
            }
        }
        this.mType = type;
    }

    public int getAudioChannels() {
        return this.audioChannels;
    }

    public java.lang.String getAudioLang() {
        return this.audioLang;
    }

    public int getAudioSampleFormat() {
        return this.audioSampleFormat;
    }

    public int getAudioSampleRate() {
        return this.audioSampleRate;
    }

    public java.lang.String getCodecName() {
        return this.codecName;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public int getIndex() {
        return this.index;
    }

    public java.lang.String getSubtitleLang() {
        return this.subtitleLang;
    }

    public com.aliyun.player.nativeclass.TrackInfo.Type getType() {
        return this.mType;
    }

    public int getVideoBitrate() {
        return this.videoBitrate;
    }

    public int getVideoHDRType() {
        return this.videoHDRType.ordinal();
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public java.lang.String getVodDefinition() {
        return this.vodDefinition;
    }

    public long getVodFileSize() {
        return this.vodFileSize;
    }

    public java.lang.String getVodFormat() {
        return this.vodFormat;
    }

    public java.lang.String getVodPlayUrl() {
        return this.vodPlayUrl;
    }

    public java.lang.String getVodWaterMarkPlayUrl() {
        return this.vodWaterMarkPlayUrl;
    }

    public void setVideoHDRType(int i) {
        com.aliyun.player.nativeclass.TrackInfo.VideoHDRType videoHDRType = com.aliyun.player.nativeclass.TrackInfo.VideoHDRType.VideoHDRType_SDR;
        if (i != videoHDRType.ordinal()) {
            videoHDRType = com.aliyun.player.nativeclass.TrackInfo.VideoHDRType.VideoHDRType_HDR10;
            if (i != videoHDRType.ordinal()) {
                return;
            }
        }
        this.videoHDRType = videoHDRType;
    }
}
