package com.aliyun.svideo.editor.editor.thumblinebar;

/* loaded from: classes12.dex */
public class ThumbLineConfig {
    private int screenWidth;
    private int thumbnailCount;
    private com.aliyun.svideosdk.common.AliyunIThumbnailFetcher thumbnailFetcher;
    private android.graphics.Point thumbnailPoint;

    public static class Builder {
        private com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig mConfig = new com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig(null);

        public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig build() {
            return this.mConfig;
        }

        public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig.Builder screenWidth(int i) {
            this.mConfig.screenWidth = i;
            return this;
        }

        public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig.Builder thumbPoint(android.graphics.Point point) {
            this.mConfig.thumbnailPoint = point;
            return this;
        }

        public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig.Builder thumbnailCount(int i) {
            this.mConfig.thumbnailCount = i;
            return this;
        }

        public com.aliyun.svideo.editor.editor.thumblinebar.ThumbLineConfig.Builder thumbnailFetcher(com.aliyun.svideosdk.common.AliyunIThumbnailFetcher aliyunIThumbnailFetcher) {
            this.mConfig.thumbnailFetcher = aliyunIThumbnailFetcher;
            return this;
        }
    }

    private ThumbLineConfig() {
        this.thumbnailCount = 10;
    }

    public /* synthetic */ ThumbLineConfig(defpackage.l13 l13Var) {
        this();
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getThumbnailCount() {
        return this.thumbnailCount;
    }

    public com.aliyun.svideosdk.common.AliyunIThumbnailFetcher getThumbnailFetcher() {
        return this.thumbnailFetcher;
    }

    public android.graphics.Point getThumbnailPoint() {
        return this.thumbnailPoint;
    }
}
