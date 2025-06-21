package com.alibaba.sdk.android.vod.upload.common.utils;

/* loaded from: classes.dex */
public class VideoInfoUtil {
    private static final java.lang.String VOD_SOURCE_SHORT_VIDEO = "short_video";

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
    
        if (r1 == null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.alibaba.sdk.android.vod.upload.model.UserData getVideoBitrate(android.content.Context context, java.lang.String str) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever;
        android.media.MediaMetadataRetriever mediaMetadataRetriever2;
        com.alibaba.sdk.android.vod.upload.model.UserData userData = new com.alibaba.sdk.android.vod.upload.model.UserData();
        android.media.MediaMetadataRetriever mediaMetadataRetriever3 = null;
        android.media.MediaMetadataRetriever mediaMetadataRetriever4 = null;
        android.media.MediaMetadataRetriever mediaMetadataRetriever5 = null;
        try {
            try {
                mediaMetadataRetriever2 = new android.media.MediaMetadataRetriever();
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.lang.Error e) {
            e = e;
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        try {
            boolean isUriPath = com.aliyun.vod.common.utils.StringUtils.isUriPath(str);
            if (isUriPath != 0) {
                mediaMetadataRetriever2.setDataSource(context, android.net.Uri.parse(str));
            } else {
                mediaMetadataRetriever2.setDataSource(new java.io.File(str).getAbsolutePath());
            }
            userData.setBitrate(java.lang.String.valueOf(java.lang.Integer.parseInt(mediaMetadataRetriever2.extractMetadata(20)) / 1024));
            userData.setDuration(java.lang.String.valueOf(java.lang.Integer.parseInt(mediaMetadataRetriever2.extractMetadata(9)) / 1000));
            userData.setFps(mediaMetadataRetriever2.extractMetadata(25));
            userData.setWidth(mediaMetadataRetriever2.extractMetadata(18));
            userData.setHeight(mediaMetadataRetriever2.extractMetadata(19));
            userData.setSource(VOD_SOURCE_SHORT_VIDEO);
            mediaMetadataRetriever2.release();
            mediaMetadataRetriever3 = isUriPath;
        } catch (java.lang.Error e3) {
            e = e3;
            mediaMetadataRetriever4 = mediaMetadataRetriever2;
            e.printStackTrace();
            mediaMetadataRetriever3 = mediaMetadataRetriever4;
            if (mediaMetadataRetriever4 != null) {
                mediaMetadataRetriever = mediaMetadataRetriever4;
                mediaMetadataRetriever.release();
                mediaMetadataRetriever3 = mediaMetadataRetriever;
            }
            return userData;
        } catch (java.lang.Exception e4) {
            e = e4;
            mediaMetadataRetriever5 = mediaMetadataRetriever2;
            e.printStackTrace();
            mediaMetadataRetriever3 = mediaMetadataRetriever5;
            mediaMetadataRetriever = mediaMetadataRetriever5;
        } catch (java.lang.Throwable th2) {
            th = th2;
            mediaMetadataRetriever3 = mediaMetadataRetriever2;
            if (mediaMetadataRetriever3 != null) {
                mediaMetadataRetriever3.release();
            }
            throw th;
        }
        return userData;
    }
}
