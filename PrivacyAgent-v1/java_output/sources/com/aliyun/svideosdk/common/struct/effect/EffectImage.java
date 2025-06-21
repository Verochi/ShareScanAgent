package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectImage extends com.aliyun.svideosdk.common.struct.effect.EffectBase implements com.aliyun.svideosdk.common.struct.effect.IEffectRect, com.aliyun.svideosdk.common.struct.effect.ICopyable<com.aliyun.svideosdk.common.struct.effect.EffectImage> {
    private android.graphics.Bitmap bitmap;
    private com.aliyun.svideosdk.common.struct.effect.EffectRect mRect = new com.aliyun.svideosdk.common.struct.effect.EffectRect();

    public EffectImage(android.graphics.Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public EffectImage(com.aliyun.svideosdk.common.struct.project.Source source) {
        setSource(source);
    }

    public EffectImage(java.lang.String str) {
        setPath(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public com.aliyun.svideosdk.common.struct.effect.EffectImage copy() {
        com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage = new com.aliyun.svideosdk.common.struct.effect.EffectImage(this.mSource);
        effectImage.setViewId(this.viewId);
        effectImage.setResId(this.resId);
        effectImage.mRect.copy(this.mRect);
        effectImage.bitmap = this.bitmap;
        return effectImage;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public void copy(com.aliyun.svideosdk.common.struct.effect.EffectImage effectImage) {
        super.copy((com.aliyun.svideosdk.common.struct.effect.EffectBase) effectImage);
        this.mRect.copy(effectImage.mRect);
        this.bitmap = effectImage.bitmap;
    }

    public android.graphics.Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getHeightRatio() {
        return this.mRect.getHeightRatio();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getRotation() {
        return this.mRect.getRotation();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getWidthRatio() {
        return this.mRect.getWidthRatio();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getXRadio() {
        return this.mRect.getXRadio();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getYRadio() {
        return this.mRect.getYRadio();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setHeightRatio(float f) {
        this.mRect.setHeightRatio(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setRotation(float f) {
        this.mRect.setRotation(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setWidthRatio(float f) {
        this.mRect.setWidthRatio(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setXRadio(float f) {
        this.mRect.setXRadio(f);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setYRatio(float f) {
        this.mRect.setYRatio(f);
    }
}
