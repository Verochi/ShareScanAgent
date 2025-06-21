package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunCaption extends com.aliyun.svideosdk.common.AliyunObject {
    private static final int ALIVC_OBJECT_NOT_INITED = -20011025;
    protected java.util.List<java.lang.Object> mActions = new java.util.ArrayList();
    private com.aliyun.svideosdk.common.ISource mBubbleSource;
    private com.aliyun.svideosdk.common.ISource mFontEffectSource;
    private com.aliyun.svideosdk.common.ISource mFontSource;

    public AliyunCaption() {
        this.mNativeHandle = nativeCreate();
    }

    private AliyunCaption(long j) {
        this.mNativeHandle = j;
    }

    private native void nativeAddFrameAnimation(long j, java.lang.Object obj);

    private native void nativeClearFrameAnimation(long j);

    private native long nativeCreate();

    private native void nativeDispose(long j);

    private native com.aliyun.svideosdk.common.AliyunColor nativeGetBackgroundColor(long j);

    private native float nativeGetBackgroundCornerRadius(long j);

    private native java.lang.String nativeGetBubbleEffectTemplate(long j);

    private native com.aliyun.svideosdk.common.AliyunColor nativeGetColor(long j);

    private native long nativeGetDuration(long j);

    private native java.lang.String nativeGetFontEffectTemplate(long j);

    private native com.aliyun.svideosdk.common.AliyunFontStyle nativeGetFontStyle(long j);

    private native int nativeGetId(long j);

    private native com.aliyun.svideosdk.common.AliyunColor nativeGetOutlineColor(long j);

    private native float nativeGetOutlineWidth(long j);

    private native android.graphics.PointF nativeGetPosition(long j);

    private native float nativeGetRotation(long j);

    private native float nativeGetScale(long j);

    private native com.aliyun.svideosdk.common.AliyunColor nativeGetShadowColor(long j);

    private native android.graphics.PointF nativeGetShadowOffset(long j);

    private native android.graphics.RectF nativeGetSize(long j);

    private native long nativeGetStartTime(long j);

    private native java.lang.String nativeGetText(long j);

    private native int nativeGetTextAlignment(long j);

    private native void nativeRemoveFrameAnimation(long j, java.lang.Object obj);

    private native void nativeSetBackgroundColor(long j, com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    private native void nativeSetBackgroundCornerRadius(long j, float f);

    private native void nativeSetBubbleEffectTemplate(long j, java.lang.String str);

    private native void nativeSetColor(long j, com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    private native void nativeSetDuration(long j, long j2);

    private native void nativeSetFontEffectTemplate(long j, java.lang.String str);

    private native void nativeSetFontStyle(long j, com.aliyun.svideosdk.common.AliyunFontStyle aliyunFontStyle);

    private native void nativeSetOutlineColor(long j, com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    private native void nativeSetOutlineWidth(long j, float f);

    private native void nativeSetPosition(long j, android.graphics.PointF pointF);

    private native void nativeSetRotation(long j, float f);

    private native void nativeSetScale(long j, float f);

    private native void nativeSetShadowColor(long j, com.aliyun.svideosdk.common.AliyunColor aliyunColor);

    private native void nativeSetShadowOffset(long j, android.graphics.PointF pointF);

    private native void nativeSetSize(long j, android.graphics.RectF rectF);

    private native void nativeSetStartTime(long j, long j2);

    private native void nativeSetText(long j, java.lang.String str);

    private native void nativeSetTextAlignment(long j, int i);

    public int addAction(java.lang.Object obj) {
        if (this.mNativeHandle == 0) {
            return ALIVC_OBJECT_NOT_INITED;
        }
        this.mActions.add(obj);
        nativeAddFrameAnimation(this.mNativeHandle, obj);
        return 0;
    }

    public int clearAction() {
        if (this.mNativeHandle == 0) {
            return ALIVC_OBJECT_NOT_INITED;
        }
        this.mActions.clear();
        nativeClearFrameAnimation(this.mNativeHandle);
        return 0;
    }

    public java.util.List<java.lang.Object> getActionList() {
        return this.mActions;
    }

    public com.aliyun.svideosdk.common.AliyunColor getBackgroundColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetBackgroundColor(j);
        }
        return null;
    }

    public float getBackgroundCornerRadius() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetBackgroundCornerRadius(j);
        }
        return 0.0f;
    }

    public com.aliyun.svideosdk.common.ISource getBubbleSource() {
        return this.mBubbleSource;
    }

    public com.aliyun.svideosdk.common.AliyunColor getColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetColor(j);
        }
        return null;
    }

    public long getDuration() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetDuration(j);
        }
        return -20011025L;
    }

    public com.aliyun.svideosdk.common.ISource getFontEffectSource() {
        return this.mFontEffectSource;
    }

    public com.aliyun.svideosdk.common.ISource getFontSource() {
        return this.mFontSource;
    }

    public com.aliyun.svideosdk.common.AliyunFontStyle getFontStyle() {
        com.aliyun.svideosdk.common.ISource iSource;
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        com.aliyun.svideosdk.common.AliyunFontStyle nativeGetFontStyle = nativeGetFontStyle(j);
        if (nativeGetFontStyle != null && (iSource = this.mFontSource) != null) {
            nativeGetFontStyle.setFontSource(iSource);
        }
        return nativeGetFontStyle;
    }

    public int getId() {
        long j = this.mNativeHandle;
        return j != 0 ? nativeGetId(j) : ALIVC_OBJECT_NOT_INITED;
    }

    public com.aliyun.svideosdk.common.AliyunColor getOutlineColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetOutlineColor(j);
        }
        return null;
    }

    public float getOutlineWidth() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetOutlineWidth(j);
        }
        return -2.0011024E7f;
    }

    public android.graphics.PointF getPosition() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetPosition(j);
        }
        return null;
    }

    public float getRotate() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetRotation(j);
        }
        return -2.0011024E7f;
    }

    public float getScale() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetScale(j);
        }
        return -2.0011024E7f;
    }

    public com.aliyun.svideosdk.common.AliyunColor getShadowColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetShadowColor(j);
        }
        return null;
    }

    public android.graphics.PointF getShadowOffset() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetShadowOffset(j);
        }
        return null;
    }

    public android.graphics.RectF getSize() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetSize(j);
        }
        return null;
    }

    public long getStartTime() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetStartTime(j);
        }
        return -20011025L;
    }

    public java.lang.String getText() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetText(j);
        }
        return null;
    }

    public int getTextAlignment() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetTextAlignment(j);
        }
        return 1;
    }

    public int removeAction(java.lang.Object obj) {
        if (this.mNativeHandle == 0) {
            return ALIVC_OBJECT_NOT_INITED;
        }
        this.mActions.remove(obj);
        nativeRemoveFrameAnimation(this.mNativeHandle, obj);
        return 0;
    }

    public void setBackgroundColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetBackgroundColor(j, aliyunColor);
        }
    }

    public void setBackgroundCornerRadius(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetBackgroundCornerRadius(j, f);
        }
    }

    public void setBubbleSource(com.aliyun.svideosdk.common.ISource iSource) {
        if (this.mNativeHandle != 0) {
            this.mBubbleSource = iSource;
            nativeSetBubbleEffectTemplate(this.mNativeHandle, iSource != null ? iSource.getPath() : null);
        }
    }

    public void setColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetColor(j, aliyunColor);
        }
    }

    public void setDuration(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeSetDuration(j2, j);
        }
    }

    public void setFontEffectSource(com.aliyun.svideosdk.common.ISource iSource) {
        if (this.mNativeHandle != 0) {
            this.mFontEffectSource = iSource;
            nativeSetFontEffectTemplate(this.mNativeHandle, iSource != null ? iSource.getPath() : null);
        }
    }

    public void setFontStyle(com.aliyun.svideosdk.common.AliyunFontStyle aliyunFontStyle) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetFontStyle(j, aliyunFontStyle);
            java.lang.String path = aliyunFontStyle.getFontSource() != null ? aliyunFontStyle.getFontSource().getPath() : null;
            com.aliyun.svideosdk.common.ISource iSource = this.mFontSource;
            if (iSource == null || com.aliyun.common.utils.StringUtils.isEmpty(iSource.getPath()) || !this.mFontSource.getPath().equals(path)) {
                this.mFontSource = aliyunFontStyle.getFontSource();
            }
        }
    }

    public void setOutlineColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetOutlineColor(j, aliyunColor);
        }
    }

    public void setOutlineWidth(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetOutlineWidth(j, f);
        }
    }

    public void setPosition(android.graphics.PointF pointF) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetPosition(j, pointF);
        }
    }

    public void setRotate(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetRotation(j, f);
        }
    }

    public void setScale(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetScale(j, f);
        }
    }

    public void setShadowColor(com.aliyun.svideosdk.common.AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetShadowColor(j, aliyunColor);
        }
    }

    public void setShadowOffset(android.graphics.PointF pointF) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetShadowOffset(j, pointF);
        }
    }

    public void setSize(android.graphics.RectF rectF) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetSize(j, rectF);
        }
    }

    public void setStartTime(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeSetStartTime(j2, j);
        }
    }

    public void setText(java.lang.String str) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetText(j, str);
        }
    }

    public void setTextAlignment(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetTextAlignment(j, i);
        }
    }
}
