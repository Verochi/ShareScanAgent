package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class MediaInfo {
    private java.lang.String mVideoId = "";
    private java.lang.String mTitle = "";
    private int mDuration = 0;
    private java.lang.String mStatus = "";
    private java.lang.String mCoverUrl = "";
    private java.lang.String mMediaType = "";
    private java.lang.String mTransCodeMode = com.aliyun.auth.common.AliyunVodHttpCommon.COMON_FAST_TRANSCODEMODE;
    private long mTotalBitrate = 0;
    private java.util.List<com.aliyun.player.nativeclass.TrackInfo> mTrackInfos = new java.util.ArrayList();
    private java.util.List<com.aliyun.player.nativeclass.Thumbnail> mThumbnailList = new java.util.ArrayList();

    private java.lang.Object[] getTrackInfoArray() {
        return this.mTrackInfos.toArray();
    }

    private void setThumbnailList(com.aliyun.player.nativeclass.Thumbnail[] thumbnailArr) {
        if (thumbnailArr == null || thumbnailArr.length <= 0) {
            return;
        }
        this.mThumbnailList.addAll(java.util.Arrays.asList(thumbnailArr));
    }

    public java.lang.String getCoverUrl() {
        return this.mCoverUrl;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public java.lang.String getMediaType() {
        return this.mMediaType;
    }

    public java.lang.String getStatus() {
        return this.mStatus;
    }

    public java.util.List<com.aliyun.player.nativeclass.Thumbnail> getThumbnailList() {
        return this.mThumbnailList;
    }

    public java.lang.String getTitle() {
        return this.mTitle;
    }

    public long getTotalBitrate() {
        return this.mTotalBitrate;
    }

    public java.util.List<com.aliyun.player.nativeclass.TrackInfo> getTrackInfos() {
        return this.mTrackInfos;
    }

    public java.lang.String getTransCodeMode() {
        return this.mTransCodeMode;
    }

    public java.lang.String getVideoId() {
        return this.mVideoId;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setTrackInfos(com.aliyun.player.nativeclass.TrackInfo[] trackInfoArr) {
        if (trackInfoArr == null || trackInfoArr.length <= 0) {
            return;
        }
        this.mTrackInfos.addAll(java.util.Arrays.asList(trackInfoArr));
    }
}
