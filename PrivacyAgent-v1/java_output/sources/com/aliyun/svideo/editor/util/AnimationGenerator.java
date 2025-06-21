package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class AnimationGenerator {
    private float mAlpha;
    private java.lang.StringBuffer mAnimationConfig = new java.lang.StringBuffer();
    private float mRotate;
    private float mScaleX;
    private float mScaleY;
    private float mTranslateX;
    private float mTranslateY;

    public void addAlphaPointer(float f) {
        java.lang.StringBuffer stringBuffer = this.mAnimationConfig;
        stringBuffer.append(f);
        stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        stringBuffer.append(this.mAlpha);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
    }

    public void addRotatePointer(float f) {
        java.lang.StringBuffer stringBuffer = this.mAnimationConfig;
        stringBuffer.append(f);
        stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        stringBuffer.append(this.mRotate);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
    }

    public void addScalePointer(float f) {
        java.lang.StringBuffer stringBuffer = this.mAnimationConfig;
        stringBuffer.append(f);
        stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        stringBuffer.append(this.mScaleX);
        stringBuffer.append(",");
        stringBuffer.append(this.mScaleY);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
    }

    public void addTranslatePointer(float f) {
        java.lang.StringBuffer stringBuffer = this.mAnimationConfig;
        stringBuffer.append(f);
        stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        stringBuffer.append(this.mTranslateX);
        stringBuffer.append(",");
        stringBuffer.append(this.mTranslateY);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
    }

    public java.lang.String generateAnimationConfig() {
        return this.mAnimationConfig.substring(0, r0.length() - 1);
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getRotate() {
        return this.mRotate;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setRotate(float f) {
        this.mRotate = f;
    }

    public void setScaleX(float f) {
        this.mScaleX = f;
    }

    public void setScaleY(float f) {
        this.mScaleY = f;
    }

    public void setTranslateX(float f) {
        this.mTranslateX = f;
    }

    public void setTranslateY(float f) {
        this.mTranslateY = f;
    }
}
