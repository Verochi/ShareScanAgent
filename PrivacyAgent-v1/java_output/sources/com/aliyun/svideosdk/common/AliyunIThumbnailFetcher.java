package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public interface AliyunIThumbnailFetcher {

    @com.aliyun.Visible
    public enum CropMode {
        Mediate(1),
        TOP(2),
        LEFT(4),
        RIGHT(8),
        BOTTOM(16);

        int value;

        CropMode(int i) {
            this.value = i;
        }
    }

    @com.aliyun.Visible
    public interface OnThumbnailCompletion {
        void onError(int i);

        void onThumbnailReady(android.graphics.Bitmap bitmap, long j, int i);
    }

    int addImageSource(java.lang.String str, long j, long j2);

    int addVideoSource(java.lang.String str);

    int addVideoSource(java.lang.String str, long j, long j2, long j3);

    int fromConfigJson(java.lang.String str);

    long getTotalDuration();

    void release();

    int requestThumbnailImage(int i, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion);

    int requestThumbnailImage(long[] jArr, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.OnThumbnailCompletion onThumbnailCompletion);

    int setFastMode(boolean z);

    int setParameters(int i, int i2, com.aliyun.svideosdk.common.AliyunIThumbnailFetcher.CropMode cropMode, com.aliyun.svideosdk.common.struct.common.VideoDisplayMode videoDisplayMode, int i3);
}
