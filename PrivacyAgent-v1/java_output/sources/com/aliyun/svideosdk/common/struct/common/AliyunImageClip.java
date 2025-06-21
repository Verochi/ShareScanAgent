package com.aliyun.svideosdk.common.struct.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunImageClip extends com.aliyun.svideosdk.common.struct.common.AliyunClip {
    private long mDuration;

    @com.aliyun.Visible
    public static final class Builder {
        private com.aliyun.svideosdk.common.struct.common.AliyunImageClip mClip;

        public Builder() {
            com.aliyun.svideosdk.common.struct.common.AliyunImageClip aliyunImageClip = new com.aliyun.svideosdk.common.struct.common.AliyunImageClip(null);
            this.mClip = aliyunImageClip;
            aliyunImageClip.setMediaType(com.aliyun.svideosdk.common.struct.common.MediaType.ANY_IMAGE_TYPE);
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunImageClip build() {
            try {
                android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                android.graphics.BitmapFactory.decodeFile(this.mClip.getSource(), options);
                com.aliyun.svideosdk.common.struct.common.AliyunImageClip aliyunImageClip = this.mClip;
                aliyunImageClip.mClipWidth = options.outWidth;
                aliyunImageClip.mClipHeight = options.outHeight;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return this.mClip;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder displayMode(com.aliyun.svideosdk.common.struct.common.AliyunDisplayMode aliyunDisplayMode) {
            this.mClip.setDisplayMode(aliyunDisplayMode);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder duration(long j) {
            this.mClip.setDuration(j);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder id(int i) {
            this.mClip.setId(i);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder source(java.lang.String str) {
            this.mClip.setSource(str);
            return this;
        }

        public com.aliyun.svideosdk.common.struct.common.AliyunImageClip.Builder transition(com.aliyun.svideosdk.common.struct.effect.TransitionBase transitionBase) {
            this.mClip.setTransition(transitionBase);
            return this;
        }
    }

    private AliyunImageClip() {
    }

    public /* synthetic */ AliyunImageClip(com.aliyun.svideosdk.common.struct.common.AliyunImageClip.AnonymousClass1 anonymousClass1) {
        this();
    }

    public long getDuration() {
        return this.mDuration;
    }

    public int getImageHeight() {
        return getClipHeight();
    }

    public int getImageWidth() {
        return getClipWidth();
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }
}
