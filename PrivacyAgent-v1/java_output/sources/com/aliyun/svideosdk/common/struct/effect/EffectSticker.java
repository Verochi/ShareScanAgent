package com.aliyun.svideosdk.common.struct.effect;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class EffectSticker extends com.aliyun.svideosdk.common.struct.effect.EffectBase implements com.aliyun.svideosdk.common.struct.effect.IEffectRect, com.aliyun.svideosdk.common.struct.effect.ICopyable<com.aliyun.svideosdk.common.struct.effect.EffectSticker> {
    protected com.aliyun.svideosdk.common.struct.effect.EffectRect mRect = new com.aliyun.svideosdk.common.struct.effect.EffectRect();
    protected boolean mFlipH = false;

    public EffectSticker(com.aliyun.svideosdk.common.struct.project.Source source) {
        setSource(source);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public com.aliyun.svideosdk.common.struct.effect.EffectSticker copy() {
        com.aliyun.svideosdk.common.struct.effect.EffectSticker effectSticker = new com.aliyun.svideosdk.common.struct.effect.EffectSticker(this.mSource);
        effectSticker.setViewId(this.viewId);
        effectSticker.setResId(this.resId);
        effectSticker.mRect.copy(this.mRect);
        effectSticker.mFlipH = this.mFlipH;
        return effectSticker;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public void copy(com.aliyun.svideosdk.common.struct.effect.EffectSticker effectSticker) {
        super.copy((com.aliyun.svideosdk.common.struct.effect.EffectBase) effectSticker);
        this.mRect.copy(effectSticker.mRect);
        this.mFlipH = effectSticker.mFlipH;
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

    public boolean isFlipH() {
        return this.mFlipH;
    }

    public void setFlipH(boolean z) {
        this.mFlipH = z;
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
