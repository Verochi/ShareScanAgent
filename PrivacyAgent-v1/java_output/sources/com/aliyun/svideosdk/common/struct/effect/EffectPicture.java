package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
@java.lang.Deprecated
/* loaded from: classes12.dex */
public class EffectPicture {
    private android.graphics.Bitmap bitmap;
    public long end;
    public float height;

    @java.lang.Deprecated
    public boolean isTrack;
    private java.lang.String mPicturePath;
    public boolean mirror;
    private int oldId;
    public float rotation;
    public long start;
    private int viewId;
    public float width;
    public float x;
    public float y;

    public EffectPicture(android.graphics.Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public EffectPicture(java.lang.String str) {
        this.mPicturePath = str;
    }

    public EffectPicture(java.lang.String str, float f, float f2, long j, long j2, float f3, float f4, float f5, boolean z, boolean z2) {
        this.mPicturePath = str;
        this.x = f;
        this.y = f2;
        this.start = j;
        this.end = j2;
        this.width = f3;
        this.height = f4;
        this.rotation = f5;
        this.mirror = z;
        this.isTrack = z2;
    }

    public boolean equals(java.lang.Object obj) {
        return (obj instanceof com.aliyun.svideosdk.common.struct.effect.EffectPicture) && this.viewId == ((com.aliyun.svideosdk.common.struct.effect.EffectPicture) obj).getViewId();
    }

    public android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getOldId() {
        return this.oldId;
    }

    public java.lang.String getPicturePath() {
        return this.mPicturePath;
    }

    public int getViewId() {
        return this.viewId;
    }

    public void setOldId(int i) {
        this.oldId = i;
    }

    public void setViewId(int i) {
        this.viewId = i;
    }

    public java.lang.String toString() {
        return "EffectPicture{viewId=" + this.viewId + ", bitmap=" + this.bitmap + ", mPicturePath='" + this.mPicturePath + "', x=" + this.x + ", y=" + this.y + ", start=" + this.start + ", end=" + this.end + ", width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + ", mirror=" + this.mirror + ", isTrack=" + this.isTrack + '}';
    }

    public com.aliyun.svideosdk.common.struct.effect.TrackEffect<com.aliyun.svideosdk.common.struct.effect.EffectImage> toTrackEffectImage() {
        com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage = new com.aliyun.svideosdk.common.struct.effect.EffectImage(getBitmap());
        effectImage.setSource(new com.aliyun.svideosdk.common.struct.project.Source(getPicturePath()));
        effectImage.setViewId(getViewId());
        effectImage.setXRadio(this.x);
        effectImage.setYRatio(this.y);
        effectImage.setWidthRatio(this.width);
        effectImage.setHeightRatio(this.height);
        effectImage.setRotation(this.rotation);
        java.util.concurrent.TimeUnit timeUnit = java.util.concurrent.TimeUnit.MICROSECONDS;
        return new com.aliyun.svideosdk.common.struct.effect.TrackEffect<>(timeUnit.toMillis(this.start), timeUnit.toMillis(this.end - this.start), effectImage);
    }
}
