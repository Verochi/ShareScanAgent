package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunLayoutParams extends com.aliyun.svideosdk.common.AliyunObject {
    private native long nativeCreate();

    private native void nativeDestroy(long j);

    private native float nativeGetLayoutAlpha(long j);

    private native float nativeGetLayoutCenterX(long j);

    private native float nativeGetLayoutCenterY(long j);

    private native int nativeGetLayoutLayerIndex(long j);

    private native float nativeGetLayoutRotationAngle(long j);

    private native float nativeGetLayoutScale(long j);

    private native void nativeSetLayoutAlpha(long j, float f);

    private native void nativeSetLayoutCenterX(long j, float f);

    private native void nativeSetLayoutCenterY(long j, float f);

    private native void nativeSetLayoutLayerIndex(long j, int i);

    private native void nativeSetLayoutRotationAngle(long j, float f);

    private native void nativeSetLayoutScale(long j, float f);

    public void createNativeHandler() {
        this.mNativeHandle = nativeCreate();
    }

    public float getAlpha() {
        return nativeGetLayoutAlpha(this.mNativeHandle);
    }

    public int getLayerIndex() {
        return nativeGetLayoutLayerIndex(this.mNativeHandle);
    }

    public android.graphics.PointF getPosition() {
        return new android.graphics.PointF(nativeGetLayoutCenterX(this.mNativeHandle), nativeGetLayoutCenterY(this.mNativeHandle));
    }

    public float getRotationRadian() {
        return nativeGetLayoutRotationAngle(this.mNativeHandle);
    }

    public float getScale() {
        return nativeGetLayoutScale(this.mNativeHandle);
    }

    public void release() {
        nativeDestroy(this.mNativeHandle);
    }

    public void setAlpha(float f) {
        nativeSetLayoutAlpha(this.mNativeHandle, f);
    }

    public void setLayerIndex(int i) {
        nativeSetLayoutLayerIndex(this.mNativeHandle, i);
    }

    public void setPosition(android.graphics.PointF pointF) {
        nativeSetLayoutCenterX(this.mNativeHandle, pointF.x);
        nativeSetLayoutCenterY(this.mNativeHandle, pointF.y);
    }

    public void setRotationRadian(float f) {
        nativeSetLayoutRotationAngle(this.mNativeHandle, f);
    }

    public void setScale(float f) {
        nativeSetLayoutScale(this.mNativeHandle, f);
    }
}
