package com.aliyun.svideosdk.common.impl;

/* loaded from: classes12.dex */
public class b extends com.aliyun.svideosdk.common.impl.c implements com.aliyun.svideosdk.common.AliyunIClipConstructor {
    public b(java.util.List<com.aliyun.svideosdk.common.struct.project.VideoTrackClip> list) {
        super(list);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addImage(java.lang.String str, long j, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        android.graphics.BitmapFactory.decodeFile(str, options);
        if (options.outWidth >= 2 && options.outHeight >= 2 && !android.text.TextUtils.isEmpty(options.outMimeType) && options.outMimeType.startsWith("image")) {
            return addMediaClip(new com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder().source(str).duration(j).displayMode(aliyunDisplayMode).transition(transitionBase).build());
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Not supported image for path '");
        sb.append(str);
        sb.append("'");
        return -20004003;
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addVideo(java.lang.String str, long j, long j2, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
        if (j2 >= j) {
            return addMediaClip(new com.aliyun.svideosdk.common.struct.common.AliyunVideoClip.Builder().source(str).startTime(j).endTime(j2).duration(j2 - j).displayMode(aliyunDisplayMode).transition(transitionBase).build());
        }
        throw new java.lang.RuntimeException("video duration invalid");
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int addVideo(java.lang.String str, com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase, com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
        android.media.MediaMetadataRetriever mediaMetadataRetriever = new android.media.MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            int addVideo = addVideo(str, 0L, java.lang.Long.parseLong(mediaMetadataRetriever.extractMetadata(9)), transitionBase, aliyunDisplayMode);
            mediaMetadataRetriever.release();
            return addVideo;
        } catch (java.lang.Exception unused) {
            mediaMetadataRetriever.release();
            return -20004001;
        } catch (java.lang.Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int deleteMediaClip() {
        return deleteLastMediaClip();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public com.aliyun.svideosdk.common.struct.common.AliyunClip getMediaPart(int i) {
        return getMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public int getMediaPartCount() {
        return getMediaClipCount();
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeMedia(int i) {
        deleteMediaClip(i);
    }

    @Override // com.aliyun.svideosdk.common.AliyunIClipConstructor
    public void removeVideo(java.lang.String str) throws java.lang.IllegalAccessException {
        throw new java.lang.IllegalAccessException("This function is deprecated");
    }
}
