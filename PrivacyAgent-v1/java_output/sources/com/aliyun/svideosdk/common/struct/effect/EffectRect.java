package com.aliyun.svideosdk.common.struct.effect;

/* loaded from: classes12.dex */
public class EffectRect implements com.aliyun.svideosdk.common.struct.effect.IEffectRect, com.aliyun.svideosdk.common.struct.effect.ICopyable<com.aliyun.svideosdk.common.struct.effect.EffectRect> {
    protected float x = 0.5f;
    protected float y = 0.5f;
    protected float width = 1.0f;
    protected float height = 1.0f;
    protected float rotation = 0.0f;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public com.aliyun.svideosdk.common.struct.effect.EffectRect copy() {
        com.aliyun.svideosdk.common.struct.effect.EffectRect effectRect = new com.aliyun.svideosdk.common.struct.effect.EffectRect();
        effectRect.x = this.x;
        effectRect.y = this.y;
        effectRect.width = this.width;
        effectRect.height = this.height;
        effectRect.rotation = this.rotation;
        return effectRect;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.ICopyable
    public void copy(com.aliyun.svideosdk.common.struct.effect.EffectRect effectRect) {
        this.x = effectRect.x;
        this.y = effectRect.y;
        this.width = effectRect.width;
        this.height = effectRect.height;
        this.rotation = effectRect.rotation;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getHeightRatio() {
        return this.height;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getRotation() {
        return this.rotation;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getWidthRatio() {
        return this.width;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getXRadio() {
        return this.x;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public float getYRadio() {
        return this.y;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setHeightRatio(float f) {
        this.height = ((java.lang.Float) com.aliyun.svideosdk.common.utils.a.a(java.lang.Float.valueOf(f), java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(1.0f))).floatValue();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setRotation(float f) {
        this.rotation = f;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setWidthRatio(float f) {
        this.width = ((java.lang.Float) com.aliyun.svideosdk.common.utils.a.a(java.lang.Float.valueOf(f), java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(1.0f))).floatValue();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setXRadio(float f) {
        this.x = ((java.lang.Float) com.aliyun.svideosdk.common.utils.a.a(java.lang.Float.valueOf(f), java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(1.0f))).floatValue();
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.IEffectRect
    public void setYRatio(float f) {
        this.y = ((java.lang.Float) com.aliyun.svideosdk.common.utils.a.a(java.lang.Float.valueOf(f), java.lang.Float.valueOf(0.0f), java.lang.Float.valueOf(1.0f))).floatValue();
    }
}
