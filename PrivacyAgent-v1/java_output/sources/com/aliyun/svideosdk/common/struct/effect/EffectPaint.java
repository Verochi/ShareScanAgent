package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectPaint {
    private android.graphics.Bitmap bitmap;
    private com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo;
    private java.lang.String path;
    private int viewId;

    @java.lang.Deprecated
    public android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    public com.aliyun.svideosdk.common.struct.CanvasInfo getCanvasInfo() {
        return this.canvasInfo;
    }

    public java.lang.String getPath() {
        return this.path;
    }

    public int getViewId() {
        return this.viewId;
    }

    @java.lang.Deprecated
    public void setBitmap(android.graphics.Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setCanvasInfo(com.aliyun.svideosdk.common.struct.CanvasInfo canvasInfo) {
        this.canvasInfo = canvasInfo;
    }

    public void setPath(java.lang.String str) {
        this.path = str;
    }

    public void setViewId(int i) {
        this.viewId = i;
    }
}
